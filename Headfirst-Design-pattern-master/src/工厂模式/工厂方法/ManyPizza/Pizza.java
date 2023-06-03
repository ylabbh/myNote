package 工厂模式.工厂方法.ManyPizza;

import java.util.ArrayList;
import java.util.List;

/**
 * 披萨，每种披萨都有原料material，他们的制作过程是一样的
 *
 */
public abstract class Pizza {

    String name;//名称

    String dough;//面团类型

    String sauce;//酱料类型



    List<String> toppings = new ArrayList<>();//一套佐料

    //准备原料
    public  void prepare(){
        System.out.println("Preparing " + name);
        System.out.println("Tossing dough..");
        System.out.println("Adding sauce..");
        System.out.println("Adding toppings: ");
        for (int i = 0; i < toppings.size(); i++){
            System.out.println("   " + toppings.get(i));
        }
    };

    //烘烤
    public void bake(){
        System.out.println("Bake for 25 minutes at 350");
    };

    public void cut(){
        System.out.println("Cutting the pizza into diagonal slices");
    };//切

    public void box(){
        System.out.println("Place pizza in offical PizzaStore box");
    };//装盒


    public String getName() {
        return name;
    }
}
