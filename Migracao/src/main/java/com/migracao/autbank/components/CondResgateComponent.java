package com.migracao.autbank.components;

import com.migracao.autbank.services.CondResgateMigrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class CondResgateComponent {
    @Autowired
    private CondResgateMigrationService condResgateMigrationService;

    @PostConstruct
    public void ExecuteService() {
        condResgateMigrationService.saveCondResgateOnDbFromCsvFile();
    }
}
