package cjy.chain.demo.design.logger;

public class DebugLogger extends AbstractLogger {

    public DebugLogger() {
        this.level = AbstractLogger.DEBUG;
    }

    /**
     * 日志输出
     *
     * @param message
     */
    @Override
    protected void write(String message) {
        System.out.println("DEBUG::Logger: " + message);
    }
}
