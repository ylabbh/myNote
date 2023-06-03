package 命令模式.更为复杂的实现.各种设备;

/**
 * 具体设备：车库门--车库门可以打开，也可以关闭
 */
public class GarageDoor {

    String name;

    public GarageDoor(String name) {
        this.name = name;
    }

    public void on(){
        System.out.println("GarageDoor(name:"+name+")  open!车库门打开了。");
    }

    public void off(){
        System.out.println("GarageDoor(name:"+name+")  off!车库门关上了。");
    }
}
