package 命令模式.更为复杂的实现.命令对象;

import 命令模式.更为复杂的实现.各种设备.CeilingFan;

/**
 * CeilingFan风扇是比较复杂的设备，它有档位，还有撤销功能，所以抽象，实现Command，覆盖undo方法。
 */
public abstract class CeilingFanCommand implements Command {

    /*
    ！！！关于继承，其实就是减少代码量，继承这个类后，每个子类都会有一个ceilingFan的属性，这是属于子类自己的。相当于隐性地写。而不是借用的父类。如果非要借用父类，那就super()方法
     */
    CeilingFan ceilingFan;
    int prevSpeed;//用来跟踪吊扇的当前转速。

    public void undo() {
        if(prevSpeed == CeilingFan.HIGH){
            ceilingFan.setHigh();
        }
        if(prevSpeed == CeilingFan.MEDIUM){
            ceilingFan.setMedium();
        }
        if(prevSpeed == CeilingFan.LOW){
            ceilingFan.setLow();
        }if(prevSpeed == CeilingFan.OFF){
            ceilingFan.off();
        }
        System.out.println("CeilFan undo,speed:"+ceilingFan.getSpeed());
    }

}
