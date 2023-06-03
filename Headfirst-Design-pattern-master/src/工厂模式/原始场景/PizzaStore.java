package 工厂模式.原始场景;

public class PizzaStore {

    /**
     * 商店里有点Pizza的方法，指定类型，创建相应的Pizza对象制作完成后return
     *
     *
     * @param type
     * @return
     */
    public Pizza orderPizza(String type){
        Pizza pizza = null;
        //这种情况下，未来我们可能需要反复修改下面的代码来调整售卖策略，不符合“对修改关闭”的原则，要将会变得和不变的分离开。
        //什么是耦合性太高？什么是强依赖？这就是。---在PizzaStore这个类中，我们需要引入一堆Pizza类。
        switch (type){
            case "cheese":pizza = new CheesePizza(); break;
            case "greek":pizza = new GreekPizza(); break;
            case "pepperoni":pizza = new PepperoniPizza(); break;
        }
        if (pizza != null){
            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.box();
        }
        return pizza;

    }
}
