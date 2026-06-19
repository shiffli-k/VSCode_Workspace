package com.backtobasics.nxtlevel;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalTime;

public class LineLimitingFileWriter implements AutoCloseable{

    private final Path basePath;
    private final String baseName;
    private final long lineLimit;
    private final String fileHeaderText;
    
    public LineLimitingFileWriter(Path basePathForOutput, String baseNameOfFile, long lineLimitPerFile, String fileHeader) throws IOException {
        if(Files.notExists(basePathForOutput)) {
    		Files.createDirectories(basePathForOutput);
    		printLine("Directory created: " + basePathForOutput);
    	}
        this.basePath = basePathForOutput;
        this.baseName = baseNameOfFile;
        this.lineLimit = lineLimitPerFile;
        this.fileHeaderText = fileHeader;
    }

    private BufferedWriter currentWriter = null;
    private int currentFileCounter = 1;
    private long currentLineCounter = 0l;


    public void writeLine(String lineToWrite) throws IOException{
        if (currentWriter == null || Long.compare(currentLineCounter, lineLimit) >= 0) {
            rotateFile();            
        }

        currentWriter.write(lineToWrite);
        currentWriter.newLine();
        ++currentLineCounter;

    }


    private void rotateFile() throws IOException {
        if(currentWriter != null)
            currentWriter.close();
        
        Path newFilePath = basePath.resolve(baseName+"_"+currentFileCounter+".txt");
        printLine("Rotating file path: " + newFilePath);

        currentWriter = Files.newBufferedWriter(newFilePath, StandardCharsets.UTF_8);
        
        currentWriter.write(fileHeaderText);
        currentWriter.newLine();

        ++currentFileCounter;
        currentLineCounter=0;
        
    }


    private static void printLine(String messageToPrint){
        System.out.println(LocalTime.now() + " | LineLimitingFileWriter: " + messageToPrint);
    }


    @Override
    public void close() throws Exception {
        if (currentWriter != null) {
            currentWriter.close();
        }
    }
    

}
