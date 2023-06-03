package 工厂模式.四.进一步的改装;

import 工厂模式.四.进一步的改装.ManyPizza.Pizza;
import 工厂模式.四.进一步的改装.ManyPizzaStore.NYStylePizzaStore;
import 工厂模式.四.进一步的改装.ManyPizzaStore.PizzaStore;

/**
 * 必胜客有很多的加盟店，我希望这些加盟店都使用我那些“经过时间考验的代码”，同时又保留他们自己的区域差异，一定的自由度。
 *
 * 工厂方法模式：定义了一个创建对象的接口，但由于这类决定要实例化的类是哪一个，工厂方法让类吧实例化推迟到子类。
 *
 */
public class Test {

    public static void main(String[] args) {
        PizzaStore pizzaStore = new NYStylePizzaStore();
        Pizza cheese = pizzaStore.orderPizza("cheese");
        System.out.println(cheese);
    }


}
