package cjy.chain.demo.design.logger;

public class InfoLogger extends AbstractLogger{

    public InfoLogger() {
        this.level = AbstractLogger.INFO;
    }

    /**
     * 日志输出
     *
     * @param message
     */
    @Override
    protected void write(String message) {
        System.out.println("INFO::Logger: " + message);
    }
}
