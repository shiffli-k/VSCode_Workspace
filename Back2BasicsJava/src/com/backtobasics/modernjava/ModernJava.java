package com.backtobasics.modernjava;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublisher;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandler;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class ModernJava {

    public static void main(String[] args) throws Exception {
        // basicThreads(task1);
        // virtualThreads(task1);
        // textBlocks();
        // switchCaseWithPatternMatch("AString");
        // sequencedCollections();
        // httpClient();
        // stringAPIs();
        fileAPIs();

    }


    private static void fileAPIs() throws IOException {

        Path filePath = Path.of("workingWithFiles/APreExistingFile.txt");

        Files.writeString(filePath,
             System.lineSeparator() + "This is written with new FileAPI: " + LocalDateTime.now().toString(),
             StandardCharsets.UTF_8,
         StandardOpenOption.APPEND
        );

        IO.println(
            Files.readString(filePath)
        );
    }


    private static void stringAPIs() {

        " ".trim().isEmpty();
        " ".isBlank();

        IO.println("-".repeat(20));
        
        "This is a Sentence \n with multiple lines \n BLAAAA"
        .lines()
        .peek(eachString -> IO.println(eachString))
        .count();
        
        IO.println("-".repeat(20));
        
        String stringBlock = """
                This is a String
                        With LeadingIndent
                Some Trailing Indentation               
            """;

        IO.println(stringBlock.trim());
        IO.println(stringBlock.strip());
        IO.println(stringBlock.stripIndent());
        IO.println(stringBlock.stripLeading());
        IO.println(stringBlock.stripTrailing());
        
    }


    private static void httpClient() throws IOException, InterruptedException {
        HttpClient apiClient = HttpClient.newHttpClient();
        HttpRequest apiRequest = 
            HttpRequest.newBuilder(URI.create("http://pie.dev/get"))
            .GET()
            .build();
        HttpResponse<String> apiResponse = apiClient.send(apiRequest, BodyHandlers.ofString());

        // IO.println(apiResponse.headers());
        IO.println(apiResponse.statusCode());
        IO.println(apiResponse.body());

        
        IO.println("------");
        
        BodyPublisher apiBody = BodyPublishers.ofString("""
            {
                "nameParam": "Value"
                }
            """);
            HttpRequest postReq = HttpRequest.newBuilder(URI.create("http://pie.dev/post"))
            .POST(apiBody)
            .build();

        apiResponse = apiClient.send(postReq, BodyHandlers.ofString());

        IO.println(apiResponse.statusCode());
        IO.println(apiResponse.body());
            
        

    }


    private static void sequencedCollections() {
        List<Integer> listOfNum = List.of(1,2,3,4,5,6,7);
        
        // Since Java 21
        listOfNum.getFirst();
        listOfNum.getLast();
        /// Throws Exception since the source List is immutable
        listOfNum.removeFirst();
        listOfNum.removeLast();

        // Mutates List to reverse!
        Collections.reverse(listOfNum);

        // Immutable | Returns a reverseList
        listOfNum.reversed();

        IO.println(listOfNum.reversed().toString());
    }


    private static <T> void switchCaseWithPatternMatch(T anyType) {

        String result = switch(anyType){
            case Integer integer -> integer.toString();
            case String a when a.startsWith("A") -> a.toUpperCase();
            case String a -> a.toLowerCase();
            default -> "Unknown";
        };

        System.out.println("Result: " + result);

    }


    private static void textBlocks() {
        var textBlocks = """
                Here we can basically write anything like " or '' " " "

                woah JSON
                {
                "name": "value"
                }











                Hello from down here


                """;
        System.out.println(textBlocks);
    }


    private static void basicThreads(Runnable taskToRun) {
        IntStream.rangeClosed(0, Integer.MAX_VALUE)
                .forEach(currentVal -> new Thread(taskToRun, "Thread"+currentVal).start());
    }

    private static void virtualThreads(Runnable taskToRun){
        try (
            var exec = Executors.newVirtualThreadPerTaskExecutor();
        ) {
            IntStream.rangeClosed(0, Integer.MAX_VALUE)
                .forEach(eachInt -> {
                    exec.submit(taskToRun);
                });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static final Runnable task1 = () -> {
        try {
            IO.println(Thread.currentThread().toString() + " Started");
            Thread.sleep(Duration.ofSeconds(30).toMillis());
            IO.println(Thread.currentThread().toString() + " Completed");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    };
}
