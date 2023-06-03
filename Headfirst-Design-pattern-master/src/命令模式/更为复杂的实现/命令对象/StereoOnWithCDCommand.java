package 命令模式.更为复杂的实现.命令对象;

import 命令模式.更为复杂的实现.各种设备.Stereo;

/**
 * 打开音响的命令对象
 */
public class StereoOnWithCDCommand implements Command {

    Stereo stereo;

    public StereoOnWithCDCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    //命令对象统一都有execute方法。
    @Override
    public void execute() {
        stereo.on();
        stereo.setCD();
        stereo.setVolume(11);
    }

    @Override
    public void undo() {
        System.out.println("撤销打开音响命令。");
        stereo.off();
    }
}
