package com.software.design.patterns;

import java.time.LocalTime;

import com.software.design.patterns.builder.PersonalComputerConfig;
import com.software.design.patterns.factory.DrawStructureFactory;
import com.software.design.patterns.factory.definition.DrawStructure;
import com.software.design.patterns.singleton.LoggerService;
import com.software.design.patterns.singleton.LoggerServiceThreadSafe;

public class TryingOutDesignPatterns {
    public static void main(String[] args) throws InterruptedException {
        // singleton_Pattern();
        // singleton_Pattern_ThreadSafe();
        // factory_Pattern();
        // factory_Pattern_Better();
        builder_Pattern();
        
    }
    
    private static void factory_Pattern_Better() {
        System.out.println("----BEHOLD! My Modern Factory----");
        DrawStructure lineStrt = DrawStructureFactory.getStructure(DrawStructureFactory.useStructure.Line);
        DrawStructure sqrStrt = DrawStructureFactory.getStructure(DrawStructureFactory.useStructure.Square);
        DrawStructure rectStrt = DrawStructureFactory.getStructure(DrawStructureFactory.useStructure.Rectange);
        
        System.out.println("Drawing Line");
        lineStrt.drawStruct();
        System.out.println("Drawing Line | Compelete\n");
        System.out.println("Drawing Square");
        sqrStrt.drawStruct();
        System.out.println("Drawing Square | Compelete\n");
        System.out.println("Drawing Rectange");
        rectStrt.drawStruct();
        System.out.println("Drawing Rectange | Compelete\n");
        
        return;
    }

    private static void singleton_Pattern_ThreadSafe() {
        System.out.println("A Singleton Logger, now Supporting Thread Safety!");
        System.out.println("Time is " + LocalTime.now());
        LoggerServiceThreadSafe tLogger = LoggerServiceThreadSafe.getLoggingInstance();
        tLogger.traceLog("Yup I found a trace");
        tLogger.errorLog("Oh no, there is an error!");
    }

    private static void builder_Pattern() {
        PersonalComputerConfig basicConfig = new PersonalComputerConfig.PcBuilder("H400", "ASUS ROG STRIX", "Ryzen 7",
                "Corsair Vengence 1x32", "1000w", "1TB NV.ME SSD").build();
        PersonalComputerConfig betterConfig = new PersonalComputerConfig.PcBuilder("H400", "ASUS ROG STRIX", "Ryzen 7",
                "Corsair Vengence 1x32", "1000w", "1TB NV.ME SSD").addGpu("RTX5090").build();

        System.out.println("Base config has GPU: " + basicConfig.getGpu());
        System.out.println("Better config has GPU: " + betterConfig.getGpu());
    }

    private static void factory_Pattern() {
        System.out.println("----BEHOLD! My Factory----");
        DrawStructure lineStrt = DrawStructureFactory.getStructure(DrawStructureFactory.LINE_STRUCTURE);
        DrawStructure sqrStrt = DrawStructureFactory.getStructure(DrawStructureFactory.SQUARE_STRUCTURE);
        DrawStructure rectStrt = DrawStructureFactory.getStructure(DrawStructureFactory.RECTANGLE_STRUCTURE);

        System.out.println("Drawing Line");
        lineStrt.drawStruct();
        System.out.println("Drawing Line | Compelete\n");
        System.out.println("Drawing Square");
        sqrStrt.drawStruct();
        System.out.println("Drawing Square | Compelete\n");
        System.out.println("Drawing Rectange");
        rectStrt.drawStruct();
        System.out.println("Drawing Rectange | Compelete\n");

        DrawStructureFactory.getStructure("BLAAAH");

        return;
    }

    private static void singleton_Pattern() throws InterruptedException {
        System.out.println("Program is running!");
        Thread.sleep(1000);
        System.out.println("Good nap of 1 seco");
        LoggerService logger = LoggerService.getLoggingService();
        logger.traceLog("Yup I found a trace");
        logger.errorLog("Oh no, there is an error!");
        return;
    }

}
