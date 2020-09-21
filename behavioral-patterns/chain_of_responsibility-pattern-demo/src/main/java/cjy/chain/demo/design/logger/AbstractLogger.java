package cjy.chain.demo.design.logger;

/**
 * 日志抽象类
 */
public abstract class AbstractLogger {

    /**
     * debug日志级别
     */
    public static final int DEBUG = 1;

    /**
     * info日志级别
     */
    public static final int INFO = 2;

    /**
     * error日志级别
     */
    public static final int ERROR = 3;

    /**
     * 处理日志的级别
     */
    protected int level;

    /**
     * 责任链中的下一个元素
     */
    protected AbstractLogger nextLogger;

    public void setNextLogger(AbstractLogger nextLogger) {
        this.nextLogger = nextLogger;
    }

    /**
     * 日志打印
     * @param level
     * @param message
     */
    public void logMessage(int level, String message) {
        if (level >= this.level) {
            write(message);
        }
        if (null != nextLogger) {
            nextLogger.logMessage(level,message);
        }
    }

    /**
     * 日志输出
     * @param message
     */
    protected abstract void write(String message);

}
