package 命令模式.简单实现.命令对象;

import 命令模式.简单实现.各种设备.Light;

public class LightOnCommand implements Command {

    Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }
}
