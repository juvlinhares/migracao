package com.migracao.autbank.components;

import com.migracao.autbank.services.MovimentacaoMigrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.text.ParseException;

@Component
public class MovimentacaoComponent {
    @Autowired
    private MovimentacaoMigrationService movimentacaoMigrationService;

    @PostConstruct
    public void ExecuteService() throws IOException, ParseException {
        movimentacaoMigrationService.saveMovimentacaoOnDbFromCsvFile();
    }
}
