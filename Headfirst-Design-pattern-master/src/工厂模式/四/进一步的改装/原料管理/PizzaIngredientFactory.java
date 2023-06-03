package 工厂模式.四.进一步的改装.原料管理;


import 工厂模式.四.进一步的改装.原料管理.Cheese.Cheese;
import 工厂模式.四.进一步的改装.原料管理.Clams.Clams;
import 工厂模式.四.进一步的改装.原料管理.Dough.Dough;
import 工厂模式.四.进一步的改装.原料管理.Sauce.Sauce;
import 工厂模式.四.进一步的改装.原料管理.Veggies.Veggies;

/**
 * 原料工厂：
 *
 * 在每个pizzaStore的子类实现了pizza工厂方法后，现在我们来构造一个原料Ingredient工厂，管理原料的加工
 * 虽然每种pizza的配方是一样的，（CheesePizza = 面团+酱料+起司）,但是不同地区（加州、印尼等）的原料产地不同，因此风味可能也有所不同（
 *
 * 工厂方法和抽象工厂的区别--工厂方法返回一种对象，而抽象工厂可以返回一族对象，也就是说抽象工厂能够管理更大范围的对象。
 */
public interface PizzaIngredientFactory {

    public Dough createDough();//面团
    public Sauce createSauce();//酱料
    public Cheese createCheese();//起司
    public Veggies[] createVeggies();//蔬菜
    public Clams createClam();//蛤蚌

}
