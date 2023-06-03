package 命令模式.更为复杂的实现.各种设备;

/**
 * 具体设备：灯，灯可以被打开，也可以被关闭。
 */
public class Light {

    String name;

    public Light(String name) {
        this.name = name;
    }

    public void on(){
        System.out.println("light(name:"+name+") on,房间变亮了");
    }

    public void off(){
        System.out.println("light(name:"+name+") off,房间变暗了");
    }

}
