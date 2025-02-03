package com.software.design.patterns;

import java.time.LocalTime;

import com.software.design.patterns.builder.PersonalComputerConfig;
import com.software.design.patterns.factory.DrawStructureFactory;
import com.software.design.patterns.factory.definition.DrawStructure;
import com.software.design.patterns.observer.MessageFeed;
import com.software.design.patterns.observer.MessageFeedSubscriber;
import com.software.design.patterns.observer.interf.Observer;
import com.software.design.patterns.singleton.LoggerService;
import com.software.design.patterns.singleton.LoggerServiceThreadSafe;
import com.software.design.patterns.stratergy.context.Bird;
import com.software.design.patterns.stratergy.context.Ostrich;
import com.software.design.patterns.stratergy.context.Pigeon;
import com.software.design.patterns.stratergy.strats.BirdFlightStratergyForced;

public class TryingOutDesignPatterns {
    public static void main(String[] args) throws InterruptedException {
        // singleton_Pattern();
        // singleton_Pattern_ThreadSafe();
        // factory_Pattern();
        // factory_Pattern_Better();
        // builder_Pattern();
        // observerPattern();
        Stratergy_Pattern();

    }

    private static void Stratergy_Pattern() {
        Bird myPigeonBob = new Pigeon("BOB");
        Bird myOstrichJames = new Ostrich("James");

        myOstrichJames.whoAmI();
        myOstrichJames.doFly();
        System.out.println("----------------------");
        myPigeonBob.whoAmI();
        myPigeonBob.doFly();
        System.out.println("----------------------");
        myOstrichJames.setFlightStrat(new BirdFlightStratergyForced());        
        myOstrichJames.whoAmI();
        myOstrichJames.doFly();

    }

    private static void observerPattern() {
        System.out.println("---Phew, this was a rollercoaster and a half. The Observer Pattern---");

        // Creating Subjects
        MessageFeed javaMessageFeed = new MessageFeed(MessageFeed.contentType.Java);
        MessageFeed pythonMessageFeed = new MessageFeed(MessageFeed.contentType.Python);

        // Creating Subjects
        Observer user1 = new MessageFeedSubscriber("User1");
        Observer user2 = new MessageFeedSubscriber("User2");
        Observer user3 = new MessageFeedSubscriber("User3");
        Observer user4 = new MessageFeedSubscriber("User4");

        // Subbing Lads to my MessageFeed yall

        javaMessageFeed.subscribe(user1);
        javaMessageFeed.subscribe(user2);
        javaMessageFeed.subscribe(user3);

        pythonMessageFeed.subscribe(user1);
        pythonMessageFeed.subscribe(user2);
        pythonMessageFeed.subscribe(user4);

        // Pushing Updated to Subscribers
        System.out.println("-- Pushing updates to Java Subscribers --");
        javaMessageFeed.pushMessageToSubscribers("Java is..... its old man :( ");

        System.out.println("-- Pushing updates to Python Subscribers--");
        pythonMessageFeed.pushMessageToSubscribers("Python is kinda like C but you are not Cing the big picture!");

        pythonMessageFeed.unSubscribe(user1);

        System.out.println("-- Pushing updates to Python Subscribers--");
        pythonMessageFeed.pushMessageToSubscribers("Python slithers its way for MachineLearning");

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
