package com.isa.pl.redbugs.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ReadService {

    public List<Object> readJson(String fileName) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Path path = Paths.get(fileName);

        String readFromJson = Files.readString(path);

        return objectMapper.readValue(readFromJson, new TypeReference<List<Object>>() {
        });
    }
}
