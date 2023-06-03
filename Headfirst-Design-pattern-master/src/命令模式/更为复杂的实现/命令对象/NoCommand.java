package 命令模式.更为复杂的实现.命令对象;

import 命令模式.更为复杂的实现.命令对象.Command;

/**
 * 无指令，用于初始化
 */
public class NoCommand implements Command {
    @Override
    public void execute() {
        System.out.println("NoCommand,Nothing.");
    }

    @Override
    public void undo() {

    }
}
