package com.binnz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * DATE 2020-08-14.
 *
 * @author binnz
 */
public class Application {

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(Object.class);
        logger.error("123");
    }
}
