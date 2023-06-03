package 命令模式.简单实现.命令对象;

import 命令模式.简单实现.各种设备.GarageDoor;

/**
 * 打开车库门的命令对象
 */
public class GarageDoorOpenCommand implements Command {

    GarageDoor garageDoor;

    public GarageDoorOpenCommand(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }

    @Override
    public void execute() {
        garageDoor.on();
    }
}
