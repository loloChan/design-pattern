package cjy.command.demo.design;

import cjy.command.demo.design.command.Command;

import java.util.ArrayList;
import java.util.List;

/**
 * 命令的接收者
 */
public final class CommandReceiver {

    private static List<Command> commandList = new ArrayList<>();

    /**
     * 添加命令
     * @param command
     */
    public static void addCommand(Command command) {
        commandList.add(command);
    }

    /**
     * 命令的执行
     */
    public static void commandExec() {
        for (Command command : commandList) {
            command.exec();
        }
    }


}
