package 命令模式.更为复杂的实现.命令对象;

import 命令模式.更为复杂的实现.各种设备.CeilingFan;

/**
 * 将吊扇转速调到高速的命令对象
 */
public class CeilingFanHighCommand extends CeilingFanCommand{

    public CeilingFanHighCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void execute() {
        prevSpeed = ceilingFan.getSpeed();//换挡前先记录一下此时的转速,相当于每次执行的时候，都保留上一次的状态。那么我要撤销，直接将状态改成上一次的状态就可以了。
        ceilingFan.setHigh();
        System.out.println("ceilingFan to High:"+ceilingFan.getSpeed());
    }


}
