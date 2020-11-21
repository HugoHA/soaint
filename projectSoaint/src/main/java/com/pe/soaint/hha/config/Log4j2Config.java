package com.pe.soaint.hha.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4j2Config {

    private static Logger logger = LogManager.getLogger();
    public void performSomeTask(){
        logger.debug("Este es un mensaje de Debug");
        logger.info("Este es un mensaje de Info");
        logger.warn("Este es un mensaje de Warn");
        logger.error("Este es un mensaje de Error");
        logger.fatal("Este es un mensaje de Fatal");
    }
    
}
