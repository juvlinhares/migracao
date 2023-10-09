package com.migracao.autbank;

import java.text.ParseException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MigracaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MigracaoApplication.class, args);
		System.out.println("Programa finalizado.");
		//System.exit(0);
	}
}
