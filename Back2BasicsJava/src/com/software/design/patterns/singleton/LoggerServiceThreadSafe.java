package com.software.design.patterns.singleton;

import java.time.LocalTime;
import java.util.logging.Logger;

public class LoggerServiceThreadSafe {

    private Logger logServ;

    private LoggerServiceThreadSafe() {
        System.out.println("Initializing now!" + LocalTime.now());
        this.logServ = Logger.getLogger("LoggerServiceThreadSafe.class");
    }

    private static class singletonHelper {
        private static final LoggerServiceThreadSafe threadSafeLogger = new LoggerServiceThreadSafe();
    }

    public static LoggerServiceThreadSafe getLoggingInstance() {
        return singletonHelper.threadSafeLogger;
    }

    public void traceLog(String messageToLog) {
        this.logServ.info(messageToLog);
    }

    public void errorLog(String messageToLog) {
        this.logServ.warning(messageToLog);
        ;
    }
}
