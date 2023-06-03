package 适配器模式与外观模式.简单实现;

import 适配器模式与外观模式.简单实现.一些火鸡.Turkey;
import 适配器模式与外观模式.简单实现.一些鸭子.Duck;

/**
 * 实现Turkey适配Duck。实现目标接口，持有被伪装的对象。
 */
public class TurkeyAdapter implements Duck {
    //被适配的对象，如果有多个，那么就是外观模式
    Turkey turkey;

    public TurkeyAdapter(Turkey turkey) {
        this.turkey = turkey;
    }

    @Override
    public void quack() {
        turkey.gobble();
    }

    @Override
    public void fly() {
        //因为火鸡飞不远，所以要“冒充”鸭子得飞5次
        for (int i = 0; i < 5; i++) {
            turkey.fly();
        }
    }
}
