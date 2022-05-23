package com.permission.config;

import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Killer for killing application
 */
@Component
@RequiredArgsConstructor
public class Killer {

    private final Logger logger = LogManager.getLogger(getClass());

    private final ApplicationContext appContext;

    public void kill(String messageLog) {
        logger.error(messageLog);
        int exitCode = SpringApplication.exit(appContext,  () -> 0);
        System.exit(exitCode);
    }
}
