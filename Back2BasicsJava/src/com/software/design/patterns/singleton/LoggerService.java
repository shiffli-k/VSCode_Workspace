package com.software.design.patterns.singleton;

import java.util.logging.Logger;

public class LoggerService {
    private static LoggerService loggerSerObj = null;
    private Logger loggerServ;

    private LoggerService() {
        System.out.println("Logger Instance Initialized");
        this.loggerServ = Logger.getLogger("LoggerService.class");
    }

    public static LoggerService getLoggingService() {
        if (loggerSerObj == null) {
            loggerSerObj = new LoggerService();
        }
        return loggerSerObj;
    }

    public void traceLog(String messageToLog){
        this.loggerServ.info(messageToLog);
    }
    public void errorLog(String messageToLog){
        this.loggerServ.warning(messageToLog);;
    }
}
