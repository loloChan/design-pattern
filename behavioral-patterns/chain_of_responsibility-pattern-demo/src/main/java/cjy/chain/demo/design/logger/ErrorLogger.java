package cjy.chain.demo.design.logger;

public class ErrorLogger extends AbstractLogger {

    public ErrorLogger() {
        this.level = AbstractLogger.ERROR;
    }

    /**
     * 日志输出
     *
     * @param message
     */
    protected void write(String message) {
        System.out.println("ERROR::Logger: " + message);
    }
}
