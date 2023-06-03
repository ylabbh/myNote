package 命令模式.更为复杂的实现.命令对象;

import 命令模式.更为复杂的实现.各种设备.Light;

/**
 * 关灯的命令对象
 */
public class LightOffCommand implements Command {
    Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }

    @Override
    public void undo() {
        System.out.println("撤销关灯命令。");
        light.on();
    }
}
