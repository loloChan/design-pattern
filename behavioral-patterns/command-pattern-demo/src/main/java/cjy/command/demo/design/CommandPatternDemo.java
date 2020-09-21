package cjy.command.demo.design;

import cjy.command.demo.design.annimal.Dog;
import cjy.command.demo.design.command.Command;
import cjy.command.demo.design.command.RunCommand;
import cjy.command.demo.design.command.SitCommand;

public class CommandPatternDemo {

    public static void main(String[] args) {

        Dog dog = new Dog("xiaojiji");

        Command runCommand = new RunCommand(dog);
        Command sitCommand = new SitCommand(dog);

        CommandReceiver.addCommand(runCommand);
        CommandReceiver.addCommand(sitCommand);

        CommandReceiver.commandExec();
    }

}
