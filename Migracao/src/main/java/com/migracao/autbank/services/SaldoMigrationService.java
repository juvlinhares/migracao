package com.migracao.autbank.services;

import com.migracao.autbank.entities.Saldo;
import com.migracao.autbank.repositories.SaldoRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static com.migracao.autbank.services.LeitorDeArquivo.leitorDeArquivo;

@Service
@Slf4j
public class SaldoMigrationService {

    List<Saldo> saldos = new ArrayList<>();
    AtomicInteger contadorDeLinhas = new AtomicInteger(1);
    @Autowired
    private SaldoRepository repository;

    public void saveSaldoOnDbFromCsvFile() {
        leitorDeArquivo("tb_saldos").parallelStream().forEach(arquivo -> {
            BufferedReader br = null;
            try {
                br = new BufferedReader(new FileReader(arquivo));
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            CSVParser records = null;
            try {
                records = CSVParser.parse(br,
                        CSVFormat.EXCEL.withFirstRecordAsHeader().withIgnoreHeaderCase().withDelimiter(';').withTrim());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            records.stream().parallel().forEach(record -> {
                if (record.size() > 2) {
                    try {
                        int contador = contadorDeLinhas.getAndIncrement();
                        log.debug("Lendo a linha de saldos do csv: " + record);

                        saldos.set(record.get());
                        repository.saveAll(new Saldo(record));
                        log.info("Linha salva: " + contador);

                    } catch (Exception e) {
                        log.error("Erro na linha: " + contadorDeLinhas.get() + "\nErro: ", e);
                    }
                }
            });
            log.info("processo de saldos concluído");
        });
    }
}
