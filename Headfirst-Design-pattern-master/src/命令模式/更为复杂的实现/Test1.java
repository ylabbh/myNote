package 命令模式.更为复杂的实现;


import 命令模式.更为复杂的实现.各种设备.CeilingFan;
import 命令模式.更为复杂的实现.各种设备.Light;
import 命令模式.更为复杂的实现.各种设备.Stereo;
import 命令模式.更为复杂的实现.各种遥控器.RemoteControlWithBatchUndo;
import 命令模式.更为复杂的实现.各种遥控器.RemoteControlWithUndo;
import 命令模式.更为复杂的实现.命令对象.*;

/**
 * 一些疑问：
 * 1.为什么要这么复杂？接受者一定要存在吗？直接在命令对象Commend里实现execute()细节不好吗？
 *      一般来说，尽量设计“傻瓜”命令对象，它只懂得调用一个接受者的一个行为。这才能保证最大程度的解耦。
 * 2.这里的Test1已经用堆栈实现多步撤销功能
 *
 */
public class Test1 {

    public static void main(String[] args) {
        RemoteControlWithBatchUndo remoteControl = new RemoteControlWithBatchUndo();
        CeilingFan ceilingFan = new CeilingFan("Living room");
        CeilingFanOffCommand off = new CeilingFanOffCommand(ceilingFan);
        CeilingFanHighCommand high = new CeilingFanHighCommand(ceilingFan);
        CeilingFanLowCommand low = new CeilingFanLowCommand(ceilingFan);
        CeilingFanMediumCommand medium = new CeilingFanMediumCommand(ceilingFan);
        remoteControl.setCommand(0,low,off);
        remoteControl.setCommand(1,medium,off);
        remoteControl.setCommand(2,high,off);

        remoteControl.onButtonWasPushed(2);
        remoteControl.offButtonWasPushed(2);
        remoteControl.onButtonWasPushed(1);
        remoteControl.onButtonWasPushed(0);
        remoteControl.undoButtonWasPushed();
        remoteControl.undoButtonWasPushed();

        //编辑一个宏命令
        //1.
        Stereo stereo = new Stereo("Living room");
        Light light = new Light("Living room");

        StereoOnWithCDCommand onCd = new StereoOnWithCDCommand(stereo);
        StereoOffWithCDCommand offCd = new StereoOffWithCDCommand(stereo);
        LightOnCommand lighOn = new LightOnCommand(light);
        LightOffCommand lightOff = new LightOffCommand(light);
        //2.
        Command[] partyOn = {lighOn,onCd,high};
        Command[] partyOff = {lightOff,offCd,off};
        MacroComand partyOnMacro = new MacroComand(partyOn);
        MacroComand partyOffMacro = new MacroComand(partyOff);
        remoteControl.setCommand(3,partyOnMacro,partyOffMacro);//3号on按钮的作用是同时打开灯、CD、风扇hight档//3号off按钮的作用是同时关闭灯、CD、风扇hight档
        //3.
        System.out.println("----------------批量on------------------");
        remoteControl.onButtonWasPushed(3);
        System.out.println("----------------批量off------------------");
        remoteControl.offButtonWasPushed(3);
        System.out.println("----------------撤销按钮1------------------");
        remoteControl.undoButtonWasPushed();
        System.out.println("----------------撤销按钮2------------------");
        remoteControl.undoButtonWasPushed();


    }
}
