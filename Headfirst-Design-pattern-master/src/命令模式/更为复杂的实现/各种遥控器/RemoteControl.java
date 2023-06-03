package 命令模式.更为复杂的实现.各种遥控器;

import 命令模式.更为复杂的实现.命令对象.Command;
import 命令模式.更为复杂的实现.命令对象.NoCommand;

public class RemoteControl {

    Command[] onCommands;
    Command[] offCommands;

    public RemoteControl(){
        onCommands = new Command[7];
        offCommands = new Command[7];
        //构造时初始化这两个数组保证不为空，构造一堆空对象，这样就在实际使用时就不需要担心Command[i]是否为空。这在命令模式中式常用的方式
        Command noCommand = new NoCommand();
        for (int i = 0; i < 7; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }

    }

    public void setCommand(int slot, Command onCommand,Command offCommand){
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void onButtonWasPushed(int slot){
        onCommands[slot].execute();
    }

    public void offButtonWasPushed(int slot){
        offCommands[slot].execute();
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
