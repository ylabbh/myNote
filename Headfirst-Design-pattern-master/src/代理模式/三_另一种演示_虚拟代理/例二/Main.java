package 代理模式.三_另一种演示_虚拟代理.例二;

public class Main {
    public static void main(String[] args) {
        /**
         * Assistant类持有一个boss对象。
         * 我们真正调用的是这个Boss对象，但有时候它被销毁，或者还未创建，
         * 1.那么我添加命令的时候，如果有boss对象，就转给boss对象自己完成“添加任务”工作。         *
         * 2.执行命令时
         *
         */
        // 有很多人来找老板, 老板在忙, 助手先把所有事情安置好
        Assistant assistant = new Assistant();
        assistant.addOrder("我找Boss面试");
        assistant.addOrder("我找Boss借钱");
        assistant.addOrder("我找Boss聊天");

        // 收集好了, 助手的职责就完成了, 把Boss叫出来, 让Boss处理. 或者说approve这件事,助手是做不了的, 只能叫出Boss来做.
        assistant.approve();

        // Boss刚才就被邀请过来, 现在就在现场. 所以就不需要助手转告给Boss了. 大家告诉助手的事情, Boss也会听到
        assistant.addOrder("我找Boss吃饭");
        assistant.addOrder("我找Boss喝酒");
        assistant.approve();
    }


}