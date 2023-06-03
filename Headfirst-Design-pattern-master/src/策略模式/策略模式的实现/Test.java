package 策略模式.策略模式的实现;

import 策略模式.策略模式的实现.主体部分.Person;
import 策略模式.策略模式的实现.主体部分.PersonXiaoFeng;
import 策略模式.策略模式的实现.算法族.独孤九剑;
import 策略模式.策略模式的实现.算法族.降龙十八掌;

/**
 * 策略模式：每个人都会武功，但是每个人的武功都不一样。
 * 这时候使用继承无意义，因为不能复用。使用实现接口的方式的话，运行时每个人只能使用一种武功，不能动态地转换。
 * 必须将可能变动的东西隔离出来，单独管理，而不是嵌套在系统的主要场景中。
 *
 * 设计模式使用了多态。
 * 设计原则：多用组合，少用继承---继承意味着耦合，用组合能够减少组件之间的关联性。
 */

public class Test {

    public static void main(String[] args) {
        Person person = new PersonXiaoFeng(new 降龙十八掌());
        person.display();
        person.performKongFu();
        person.setKongFu(new 独孤九剑());
        person.performKongFu();

    }

}































