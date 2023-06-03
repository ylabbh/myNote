package 命令模式.更为复杂的实现;

import 命令模式.更为复杂的实现.各种设备.GarageDoor;
import 命令模式.更为复杂的实现.各种设备.Light;
import 命令模式.更为复杂的实现.各种设备.Stereo;
import 命令模式.更为复杂的实现.各种遥控器.RemoteControl;
import 命令模式.更为复杂的实现.命令对象.*;

public class Test {

    public static void main(String[] args) {
        RemoteControl remoteControl = new RemoteControl();
        //引入各种要使用的设备
        Light livingRoomLight = new Light("卧室灯");
        Light kitchenLight = new Light("厨房灯");
        Stereo stereo = new Stereo("卧室音响");
        GarageDoor garageDoor = new GarageDoor("车库门");

        //相应的创建所有设备对应的命令对象。
        LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
        LightOnCommand kitchenLightOn = new LightOnCommand(kitchenLight);
        LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight);
        LightOffCommand kitchenLightOff = new LightOffCommand(kitchenLight);
        GarageDoorOpenCommand garageDoorOpen = new GarageDoorOpenCommand(garageDoor);
        GarageDoorCloseCommand garageDoorClose = new GarageDoorCloseCommand(garageDoor);
        StereoOnWithCDCommand stereoOnWithCD = new StereoOnWithCDCommand(stereo);
        StereoOffWithCDCommand stereoOffWithCD = new StereoOffWithCDCommand(stereo);

        //遥控器安装所有插槽
        remoteControl.setCommand(0,livingRoomLightOn,livingRoomLightOff);//控制灯
        remoteControl.setCommand(1,kitchenLightOn,kitchenLightOff);//控制。。
        remoteControl.setCommand(2,garageDoorOpen,garageDoorClose);
        remoteControl.setCommand(3,stereoOnWithCD,stereoOffWithCD);

        //可以开始尝试按按钮测试了。
        remoteControl.onButtonWasPushed(0);
        remoteControl.onButtonWasPushed(1);
        remoteControl.onButtonWasPushed(2);
        remoteControl.onButtonWasPushed(3);
        remoteControl.offButtonWasPushed(0);
        remoteControl.offButtonWasPushed(1);
        remoteControl.offButtonWasPushed(2);
        remoteControl.offButtonWasPushed(3);

    }



}
