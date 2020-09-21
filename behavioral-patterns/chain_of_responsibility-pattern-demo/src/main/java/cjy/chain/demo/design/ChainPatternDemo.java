package cjy.chain.demo.design;

import cjy.chain.demo.design.logger.AbstractLogger;
import cjy.chain.demo.design.logger.DebugLogger;
import cjy.chain.demo.design.logger.ErrorLogger;
import cjy.chain.demo.design.logger.InfoLogger;

public class ChainPatternDemo {

    /**
     * 获取日志对象
     * @return
     */
    public static AbstractLogger getLogger() {

        AbstractLogger errorLogger = new ErrorLogger();
        AbstractLogger infoLogger = new InfoLogger();
        AbstractLogger debugLogger = new DebugLogger();

        errorLogger.setNextLogger(infoLogger);
        infoLogger.setNextLogger(debugLogger);

        return errorLogger;
    }

    public static void main(String[] args) {

        AbstractLogger logger = getLogger();

        logger.logMessage(AbstractLogger.DEBUG, "this is a debug log message!");

        logger.logMessage(AbstractLogger.INFO, "this is an info log message");

        logger.logMessage(AbstractLogger.ERROR,"this is an error log message");

    }

}
