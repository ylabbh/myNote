package 工厂模式.四.进一步的改装.原料管理;


import 工厂模式.四.进一步的改装.原料管理.Cheese.Cheese;
import 工厂模式.四.进一步的改装.原料管理.Cheese.ReggianoCheese;
import 工厂模式.四.进一步的改装.原料管理.Clams.Clams;
import 工厂模式.四.进一步的改装.原料管理.Clams.FreshClams;
import 工厂模式.四.进一步的改装.原料管理.Dough.Dough;
import 工厂模式.四.进一步的改装.原料管理.Dough.ThinCrustDough;
import 工厂模式.四.进一步的改装.原料管理.Sauce.MarinaraSauce;
import 工厂模式.四.进一步的改装.原料管理.Sauce.Sauce;
import 工厂模式.四.进一步的改装.原料管理.Veggies.*;

/**
 * 纽约的原料工厂生产自己区域特色的原料ThinCrustDough，MarinaraSauce。。。
 */
public class NYPizzaIngredientFactory implements PizzaIngredientFactory {


    @Override
    public Dough createDough() {
        return new ThinCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new MarinaraSauce();
    }

    @Override
    public Cheese createCheese() {
        return new ReggianoCheese();
    }

    @Override
    public Veggies[] createVeggies() {
        Veggies veggies[] = {new Garlic(),new Onion(),new Mushroom(),new RedPepper()};
        return veggies;
    }

    @Override
    public Clams createClam() {
        return new FreshClams();
    }
}
