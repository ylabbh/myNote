package 命令模式.更为复杂的实现.命令对象;

/**
 * 宏命令对象：具有执行一次执行一堆命令的功能。
 * 比如我希望遥控器Controller有一个“让我舒适”的按钮，按下按钮后，同时打开卧室灯、卧室风扇、卧室音响。那么就编辑一个宏命令（Command Party）
 *
 *
 */
public class MacroComand implements Command{

    //可以看到，在其它implements Command的类中，这里持有的是具体的设备，但是如果我们持有命令对象，就可以对一堆命令进行控制了。
    Command[] commands;

    public MacroComand(Command[] commands) {
        this.commands = commands;
    }

    @Override
    public void execute() {
        System.out.println("批量执行开始。");
        for (int i = 0; i < commands.length; i++) {
            commands[i].execute();
        }
    }

    @Override
    public void undo() {
        for (int i = 0; i < commands.length; i++) {
            commands[i].undo();
        }
    }
}
