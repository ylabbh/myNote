package 装饰者模式.书上的实现;

import 装饰者模式.书上的实现.可选配料.CondimentPrettyPrint;
import 装饰者模式.书上的实现.可选配料.Mocha;
import 装饰者模式.书上的实现.可选配料.Whip;
import 装饰者模式.书上的实现.各种咖啡.Beverage;
import 装饰者模式.书上的实现.各种咖啡.Espresso;

public class Test {
    /**
     *   重要经验教训：不要妄图理解整个结构，你不够聪明，代码达不到预想效果的时候，老老实实debug就好了。
     *
     *   Mocha 1.3
     *   Whip: 3.0
     *   Soy: 3.5
     * Espresso: ￥20.0
     * Espresso Mocha Mocha Whip: ￥25.6
     * @param args
     */
    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        beverage.setSize(BeverageCondimentSize.grand);
        System.out.println(beverage.getDescription() + ": ￥" + beverage.cost());
        beverage = new Mocha(beverage);
        beverage = new Mocha(beverage);
        beverage = new Whip(beverage);
        beverage = new Whip(beverage);
        //注意Beverage里的代码变化，由于这里变成了list形式，有些东西改变了。因为如果只是String，层层往外调，只是反复重新拼接，但是如果是list，由于list属于Beverage对象。因此一旦创建就存在
        // 每次调用beverage.getDescription();，都会重新add，而之前的add的继续存在，相当于修饰了两次。
        beverage.getDescription();
        beverage.getDescription();
        beverage.getDescription();
        beverage = new CondimentPrettyPrint(beverage);
        System.out.println(beverage.getDescription() + ": ￥" + beverage.cost());

    }

}
