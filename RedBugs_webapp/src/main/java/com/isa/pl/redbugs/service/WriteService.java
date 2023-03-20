package com.isa.pl.redbugs.service;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class WriteService {

    public void writeToJson(List<Object> objectList, String fileName) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        String arrayListAsSting = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(objectList);

        Path path = Paths.get(fileName);
        Files.write(path, arrayListAsSting.getBytes());

        path.toFile().deleteOnExit();
    }
}
