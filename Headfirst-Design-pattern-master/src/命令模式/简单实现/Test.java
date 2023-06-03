package 命令模式.简单实现;

import 命令模式.简单实现.SimpleRemoteControl;
import 命令模式.简单实现.各种设备.GarageDoor;
import 命令模式.简单实现.各种设备.Light;
import 命令模式.简单实现.命令对象.GarageDoorOpenCommand;
import 命令模式.简单实现.命令对象.LightOnCommand;

/**
 * 场景：有一个遥控器，它支持各种设备插槽，设备安装上插槽后，按“执行”按钮就可以控制这些设备。
 *
 * 命令模式：
 * ----将“动作的请求者”从“动作执行者”对象中解耦。---想想我需要一个能够控制各种设备执行的遥控器。即使我还不知道将来要控制哪些设备，依旧有办法动态添加。
 * ----正式定义：将“请求”封装成对象，以便使用不同的请求、队列或者日志来参数化其他对象。命令模式也支持可撤销操作？
 * 实现思路：把请求封装成一个特定对象，由“动作的请求者”-->“动作执行者”变成“动作的请求者”-->“请求对象”-->“动作执行者”，遥控器不需要知道工作内容是什么，
 *
 * 注意：在命令模式中，最内部的核心是什么？是“命令执行者”，也就是真正工作的内容，才是我们所关注的。在这里的场景中，真正核心的是那些设备--风扇、音响、车库门等。
 * 我们做的，只是将“命令请求者”和“命令执行者”进行了解耦。这样，有助于我们更好地控制一堆设备。也能够更容易地对“请求者”和“执行者”进行扩展。
 * 在更复杂的实现中，我们就这样做了：
 * 1.我们扩展了一个更复杂的设备--风扇。可以调档位、可以撤销、可以开关。 *
 * 2.一个更复杂的“请求者”--用堆栈结构实现的一个可以多次撤销的遥控器。
 *
 *
 * ！！命令模式的更多用途？为什么要封装命令？
 * 1.队列请求--类似于消息中间件。
 *     既然我们已经将一个一个命令封装成命令对象，那么我们就可以管理这些命令对象：创建很久后依然可以被调用，甚至可以放到不同线程中取使用
 *     日程安排Scheduler、线程池、工作队列等等。安排一个命令堆栈。一个线程反复取出命令对象并execute()，然后丢弃。
 * 2.日志请求
 *     1.记录所有动作，新增store(),load()方法，使用序列化Serialization可以将每步动作记录在磁盘，如果死机，重启后可以直接读取，恢复之前的操作。
 *     2.在大型数据结构中很有用。我们肯定要做备份，但是数据量太大的话，我不可能每步操作都备份整个数据。那么只要记录每一步的操作就可以了。
 *     3.既然我们能保留住每一步的操作。那么事务功能也是可以实现的。
 */
public class Test {

    public static void main(String[] args) {
        //遥控器--即命令请求者
        SimpleRemoteControl remote = new SimpleRemoteControl();
        //封装命令的对象
        LightOnCommand lightOnCommand = new LightOnCommand(new Light());
        remote.setSolt(lightOnCommand);//命令的请求者持有命令对象。要请求命令时，调用Command。
        remote.buttonWasPressed();

        GarageDoorOpenCommand garageDoorOpenCommand = new GarageDoorOpenCommand(new GarageDoor());
        System.out.println("remote遥控器插槽上换另外一个命令--打开车库门");
        remote.setSolt(garageDoorOpenCommand);
        remote.buttonWasPressed();

    }

}
