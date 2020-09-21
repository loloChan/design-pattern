package cjy.command.demo.design.command;

import cjy.command.demo.design.annimal.Dog;

/**
 * 具体命令实现
 */
public class RunCommand implements Command {

    /**
     * 命令接收者
     */
    private Dog dog;

    public RunCommand(Dog dog) {
        this.dog = dog;
    }

    /**
     * 命令的执行
     */
    public void exec() {
        dog.run();
    }
}
