package 命令模式.更为复杂的实现.命令对象;

/**
 * 命令接口，管理所有命令
 */
public interface Command {
    //执行方法
    public void execute();

    //撤销命令，因为这里所有设备都只有开关两种状态，那么撤销意味着倒置一下就可以了。
    public void undo();

}
