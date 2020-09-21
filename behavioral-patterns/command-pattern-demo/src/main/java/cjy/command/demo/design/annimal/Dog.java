package cjy.command.demo.design.annimal;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 命令的执行者(接收者)
 */
@Data
public class Dog {

    private static Logger logger = LoggerFactory.getLogger(Dog.class);

    private String name;

    public Dog(String name) {
        this.name = name;
    }

    /**
     * 跑
     */
    public void run() {
        logger.info("{} execute run command!",name);
    }

    /**
     * 坐
     */
    public void sit() {
        logger.info("{} execute sit command!",name);
    }

}
