package cjy.command.demo.design.command;

import cjy.command.demo.design.annimal.Dog;

/**
 * 具体命令的实现
 */
public class SitCommand implements Command {

    private Dog dog;

    public SitCommand(Dog dog) {
        this.dog = dog;
    }

    public void exec() {
        dog.sit();
    }
}
