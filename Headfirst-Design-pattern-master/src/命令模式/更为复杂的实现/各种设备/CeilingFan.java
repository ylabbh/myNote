package 命令模式.更为复杂的实现.各种设备;


/**
 * 吊扇设备--演示更复杂的操作
 * 吊扇风速有多个档位，可以开，关，换挡，撤销换挡，撤销开关等等。
 */
public class CeilingFan {
    //档位对应的转速常量
    public static final int HIGH = 3;
    public static final int MEDIUM = 2;
    public static final int LOW = 1;
    public static final int OFF = 0;

    //两个变量
    String location;
    int speed;//转速

    public CeilingFan(String location) {
        this.location = location;
        speed = OFF;//初始时实关闭状态，转速0。
    }

    public void setHigh(){
        speed = HIGH;
    }

    public void setMedium(){
        speed = MEDIUM;
    }

    public void setLow(){
        speed = LOW;
    }

    public void off(){
        speed = OFF;
    }

    public int getSpeed() {
        return speed;
    }
}
