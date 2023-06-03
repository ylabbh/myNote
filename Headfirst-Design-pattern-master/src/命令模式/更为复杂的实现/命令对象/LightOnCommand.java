package 命令模式.更为复杂的实现.命令对象;


import 命令模式.更为复杂的实现.各种设备.Light;

/**
 * 开灯的命令对象
 */
public class LightOnCommand implements Command {

    Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        System.out.println("撤销开灯命令。");
        light.off();
    }
}
