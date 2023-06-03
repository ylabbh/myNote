package 工厂模式.简单实现;
/**
 * 商店里有点Pizza的方法，指定类型，创建相应的Pizza对象制作完成后return
 * @param
 * @return
 */
public class PizzaStore {

    SimplePizzaFactory factory;

    public PizzaStore(SimplePizzaFactory factory) {
        this.factory = factory;
    }

    public Pizza orderPizza(String type){
        Pizza pizza = factory.createPizza(type);
        if (pizza != null){
            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.box();
        }
        return pizza;

    }
}
