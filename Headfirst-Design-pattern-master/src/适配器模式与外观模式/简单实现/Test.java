package 适配器模式与外观模式.简单实现;

import 适配器模式与外观模式.简单实现.一些火鸡.WildTurkey;
import 适配器模式与外观模式.简单实现.一些鸭子.Duck;
import 适配器模式与外观模式.简单实现.一些鸭子.MallardDuck;

/**
 * 区别于装饰者模式，现在要让接口看起来不像自己，将类的接口转换成想要的别的接口。
 *
 * 场景，我们需要鸭子，但是现在只有火鸡，我希望火鸡能够“冒充鸭子”
 *
 * 适配器模式/外观模式：
 *      定义：将一个类的接口，转换成另一个接口。让原本接口不兼容的类能够兼容。
 *      1.当你的系统需要兼容别人的类库的，又不能动别人的类库又不想 改自己的系统，那就需要适配器
 *      2.适配器和外观模式的区别：当一个适配器包装多个被适配者时，就是外观模式
 *
 */
public class Test {

    /**
     * 1.这里演示对象适配器模式。因为JAVA单继承，因此无法使用类适配器模式
     * @param args
     *
     */
    public static void main(String[] args) {
        MallardDuck duck = new MallardDuck();

        WildTurkey turkey = new WildTurkey();
        //看，通过适配器，就把火鸡turkey伪装成了Dcuk
        Duck turkeyAdapter = new TurkeyAdapter(turkey);
        System.out.println("----先看看火鸡turkey的行为");
        turkey.gobble();
        turkey.fly();
        System.out.println("----真实鸭子的行为");
        testDuck(duck);
        System.out.println("----再看看伪装后鸭子Duck的行为");
        testDuck(turkeyAdapter);

    }

    //这个方法需要Duck，但是我只有火鸡，通过适配器模式伪装成Duck。
    static void testDuck(Duck duck){
        duck.quack();
        duck.fly();
    }


}
