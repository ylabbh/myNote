package 命令模式.更为复杂的实现.各种遥控器;

import 命令模式.更为复杂的实现.命令对象.Command;
import 命令模式.更为复杂的实现.命令对象.NoCommand;

import java.util.Stack;

/**
 * 带有多步撤销的功能，使用了一个堆栈结构。撤销功能的遥控器
 */
public class RemoteControlWithBatchUndo {

    Command[] onCommands;
    Command[] offCommands;
    //保存上一个执行的命令对象，用于撤销功能，因为我能知道上一次执行的是哪个命令对象，那么撤销时调用这个命令对象的undo方法就可以执行相应的撤销了。
    Stack<Command> undoCommandStack = new Stack();



    public RemoteControlWithBatchUndo(){
        onCommands = new Command[7];
        offCommands = new Command[7];
        //构造时初始化这两个数组保证不为空，构造一堆空对象，这样就在实际使用时就不需要担心Command[i]是否为空。
        Command noCommand = new NoCommand();
        for (int i = 0; i < 7; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
        undoCommandStack.push(noCommand);

    }

    public void setCommand(int slot, Command onCommand,Command offCommand){
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void onButtonWasPushed(int slot){
        undoCommandStack.push(onCommands[slot]);
        onCommands[slot].execute();
    }

    public void offButtonWasPushed(int slot){
        undoCommandStack.push(offCommands[slot]);
        offCommands[slot].execute();
    }

    public void undoButtonWasPushed(){
        Command undoCommand = undoCommandStack.pop();
        if (undoCommand != null){
            undoCommand.undo();
        }
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("\n--------Remote Control -------\n");
        for (int i = 0; i < onCommands.length; i++) {
            stringBuffer.append("slot " + i + "] " + onCommands[i].getClass().getName() +
                    "    " + offCommands[i].getClass().getName() + "\n");
        }
        return stringBuffer.toString();

    }
}
