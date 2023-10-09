package com.migracao.autbank.services;

import com.migracao.autbank.entities.Movimentacao;
import com.migracao.autbank.repositories.MovimentacaoRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static com.migracao.autbank.services.LeitorDeArquivo.leitorDeArquivo;

@Service
@Slf4j
public class MovimentacaoMigrationService {
    private CSVParser csvParser = null;
    private List<CSVRecord> csvRecords = new ArrayList<>();
    AtomicInteger contadorDeLInhas = new AtomicInteger(1);
    @Autowired
    private MovimentacaoRepository repository;

    public void saveMovimentacaoOnDbFromCsvFile() throws IOException, ParseException {
        leitorDeArquivo("tb_movimentacoes").forEach(arquivo -> {
            BufferedReader br;

            try {
                br = new BufferedReader(new FileReader(arquivo));
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }

            try {
                this.csvParser = CSVParser.parse(br,
                        CSVFormat.EXCEL.withFirstRecordAsHeader().withIgnoreHeaderCase().withDelimiter(';').withTrim());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            csvRecords.addAll(csvParser.getRecords());

            //csvParser.stream().forEach(csvParser -> csvRecords.add(csvParser));

            csvRecords.stream().forEach(record -> {
                        if (record.size() > 2) {
                            try {
                                int contador = contadorDeLInhas.getAndIncrement();
                                log.debug("Lendo a linha de movimentacoes do csv: " + record);

                                repository.save(new Movimentacao(record));

                                log.info("linha salva: " + contador);

                            } catch (Exception e) {
                                log.error("Erro na linha: " + contadorDeLInhas.get() + "\nErro: ", e);
                            }
                        }
                    }
            );
            log.info("processo de movimentacoes concluido");
        });
    }
}
