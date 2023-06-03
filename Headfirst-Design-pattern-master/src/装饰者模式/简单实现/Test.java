package 装饰者模式.简单实现;

import 装饰者模式.简单实现.可选配料.Mocha;
import 装饰者模式.简单实现.可选配料.Whip;
import 装饰者模式.简单实现.各种咖啡.Beverage;
import 装饰者模式.简单实现.各种咖啡.Espresso;

/**
 *
 * 装饰者模式的要素：每一个装饰者都保留有上一层的包装对象，这样通过层层调用，先调用最内部的被装饰者，然后一次一次往外调。这样就达到了装饰的目的。
 * 关于“被代理”和“被装饰”：
 * ---A“被装饰”：A对象本身的属性（description）和方法(codt())已经改变了。但是最终得到的，使用的还是A。只是它被“装饰”了，而我们可以在系统完成之后任意地添加新的装饰规则，保证它的扩展性且不必修改原来已经写好的代码。
 * ---A“被代理”：A对象本身的属性（description）和方法(codt())没有变。但是最终得到的已经是一个B，它包含这原来的那个A。
 *
 * 一些注意事项;
 * 1.使用装饰者模式可以灵活地构造各种属性不同的对象，但也意味着我可能需要管理一堆对象。这难以避免，但是加上“工厂模式”，同样可以将这些对象圈起来封装，统一管理。
 * 2.装饰者模式关注的是添加行为到目标对象，装饰者之间并不互相关心，但是也有办法管理“装饰链”。
 * 比如让“咖啡”的description变成一个list<String>，传递的时候往list里面加东西，就可以实现。
 * 3.装饰者模式的缺点：
 *   需要大量额外的装饰类。使结构变得难以理解。可读性降低。增加代码复杂度，需要各种包装。
 *
 *
 *
 */
public class Test {
    /**
     * 场景：星巴克咖啡
     * 提供各种各样的咖啡Beverage，比如Espresso，HouseBlend等。价格固定
     * 客户可以指定添加各种调料，豆浆啦，奶泡啦，糖啦。加调料要加钱。
     *
     * 在这样的场景下，事先并不知道客户会加什么调料。要能保证在“运行时”能够动态地使用
     *  * Mocha 1.3
     *  * Whip: 3.0
     *  * Soy: 3.5
     * Espresso: ￥20.0
     * Espresso Mocha Mocha Whip: ￥25.6
     * @param args
     */
    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription() + ": ￥" + beverage.cost());
        beverage = new Mocha(beverage);
        beverage = new Mocha(beverage);
        beverage = new Whip(beverage);
        beverage.getDescription();
        System.out.println(beverage.getDescription() + ": ￥" + beverage.cost());

    }

}
