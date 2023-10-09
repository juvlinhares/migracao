package com.migracao.autbank.services;

import lombok.experimental.UtilityClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class LeitorDeArquivo {
    private static final Logger logger = LoggerFactory.getLogger(LeitorDeArquivo.class);
    String diretorioRaiz = System.getProperty("user.dir");

    public static List<String> leitorDeArquivo(String nomeDaTabela) {
        logger.info(diretorioRaiz);
        List<String> paths = new ArrayList<>();
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(diretorioRaiz), entry -> {
            String fileName = entry.getFileName().toString();
            return fileName.startsWith(nomeDaTabela) && fileName.endsWith(".csv");
        })) {

            for (Path arquivo : stream) {
                paths.add(arquivo.toString());
                logger.info("caminho do arquivo encontrado: " + arquivo.toString());
            }
            if(paths.isEmpty()){
                logger.warn("Arquivo CSV não encontrado");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return paths;
    }
}
