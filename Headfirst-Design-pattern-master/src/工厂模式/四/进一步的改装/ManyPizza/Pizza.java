package 工厂模式.四.进一步的改装.ManyPizza;

import 工厂模式.四.进一步的改装.原料管理.Cheese.Cheese;
import 工厂模式.四.进一步的改装.原料管理.Clams.Clams;
import 工厂模式.四.进一步的改装.原料管理.Dough.Dough;
import 工厂模式.四.进一步的改装.原料管理.Sauce.Sauce;
import 工厂模式.四.进一步的改装.原料管理.Veggies.Veggies;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 披萨，不管什么披萨，都是面团+酱料+起司+各种蔬菜+一套佐料，
 * 他们的制作过程是一样的烘烤bake，切cut，装盒box
 * prepare准备原料的过程不同，抽象。
 */
public abstract class Pizza {

    String name;//名称

    Dough dough;//面团类型

    Sauce sauce;//酱料类型

    Cheese cheese;//起司

    Veggies veggies[];//各种蔬菜

    List<String> toppings = new ArrayList<>();//一套佐料

    Clams clams;

    //准备原料
    public abstract void prepare();

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

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "name='" + name + '\'' +
                ", dough=" + dough +
                ", sauce=" + sauce +
                ", cheese=" + cheese +
                ", veggies=" + Arrays.toString(veggies) +
                ", toppings=" + toppings +
                ", clams=" + clams +
                '}';
    }
}
