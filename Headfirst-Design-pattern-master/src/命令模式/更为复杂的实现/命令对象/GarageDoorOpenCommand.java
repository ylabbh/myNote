package 命令模式.更为复杂的实现.命令对象;


import 命令模式.更为复杂的实现.各种设备.GarageDoor;

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

    //对于这个“开车库门”的命令对象。撤销就是关车库门
    @Override
    public void undo() {
        System.out.println("撤销开车库门命令。");
        garageDoor.on();
    }
}
