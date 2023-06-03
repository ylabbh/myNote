package 命令模式.更为复杂的实现.命令对象;


import 命令模式.更为复杂的实现.各种设备.GarageDoor;

/**
 * 打开车库门的命令对象
 */
public class GarageDoorCloseCommand implements Command {

    GarageDoor garageDoor;

    public GarageDoorCloseCommand(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }

    @Override
    public void execute() {
        garageDoor.off();
    }

    //对于这个“关车库门”的命令对象。撤销就是开车库门
    @Override
    public void undo() {
        System.out.println("撤销关车库门。");
        garageDoor.on();
    }
}
