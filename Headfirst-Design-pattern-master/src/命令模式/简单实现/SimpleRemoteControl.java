package 命令模式.简单实现;

import 命令模式.简单实现.命令对象.Command;

/**
 * 简单遥控器实现
 */
public class SimpleRemoteControl {
    //有一个插槽持有命令，这个命令控制着一个装置。
    Command solt;

    public void setSolt(Command solt) {
        System.out.println("插槽安装了："+solt.toString());
        this.solt = solt;
    }

    //遥控器按下按钮是触发，
    public void buttonWasPressed(){
        solt.execute();
    }
}
