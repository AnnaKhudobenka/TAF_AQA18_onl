package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;


public class LoggerTest {
    Logger logger = LogManager.getLogger(LoggerTest.class);
    Logger loggerFile = LogManager.getLogger("File");

    @Test
    public void loggerTest() {
        logger.trace("trace massage: ...");
        logger.debug("debug massage: ...");
        logger.info("info massage: ...");
        logger.warn("warn massage: ...");

        loggerFile.error("error massage: ...");
        loggerFile.fatal("fatal massage: ...");
    }
}
