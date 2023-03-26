package com.isa.pl.redbugs.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class ReadService <T>{

    public List<T> readJson(String fileName, Class<T[]> clazz) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Path path = Paths.get(fileName);

        String readFromJson = Files.readString(path);

        T[] array = objectMapper.readValue(readFromJson, clazz);
        return Arrays.asList(array);
    }
}
