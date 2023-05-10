package com.isa.pl.redbugs.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Component
public class WriteService <T>{
    ObjectMapper objectMapper = new ObjectMapper();

    public void writeToJson(List<T> objectList, String fileName) throws IOException {

        String arrayListAsSting = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(objectList);

        Path path = Paths.get(fileName);
        Files.write(path, arrayListAsSting.getBytes());

       //path.toFile().deleteOnExit();
    }
}
