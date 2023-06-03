package 命令模式.简单实现.各种设备;

/**
 * 具体设备：灯，灯可以被打开，也可以被关闭。
 */
public class Light {

    public void on(){
        System.out.println("light on,房间变亮了");
    }

    public void off(){
        System.out.println("light off,房间变暗了");
    }
}
