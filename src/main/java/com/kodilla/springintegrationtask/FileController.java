package com.kodilla.springintegrationtask;

import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@RestController
public class FileController {

    private static final String DIRECTORY = "data/input";

    @PostMapping(path = "create")
    public void createFile(@RequestBody UserFile userFile) throws IOException {
        Path file = Files.createFile(Path.of(DIRECTORY + "/" + userFile.getTitle()));
        Files.writeString(Paths.get(DIRECTORY + "/" + userFile.getTitle()), userFile.getContent());
    }

    @GetMapping(path = "read")
    public List<String> read() throws IOException {
        File directory = new File("data/output");
        File[] files = directory.listFiles();
        List<String> fileNames = new ArrayList<>();
        for (File file : files) {
            fileNames.add(file.getName());
        }
        return fileNames;
    }

}
