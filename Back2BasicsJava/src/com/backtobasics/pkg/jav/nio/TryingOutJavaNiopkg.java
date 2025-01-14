package com.backtobasics.pkg.jav.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class TryingOutJavaNiopkg {
    public static void main(String[] args) throws IOException {
        usingModernFile_NIO();

    }

    private static void usingModernFile_NIO() throws IOException {
        Path filePath = Paths.get("workingWithFilesNio/aFile.txt");
        
        if(Files.exists(filePath)) {
            System.out.println("File exists");
        } else {
            Files.createFile(filePath);
            System.out.println("File didnt existed, so created a new one");
        }

        Files.lines(filePath).forEach(System.out::println);
        
        Files.write(filePath, "Hello NonBlocing World".getBytes(), StandardOpenOption.APPEND);
        
        Files.lines(filePath).forEach(System.out::println);
    }
}
