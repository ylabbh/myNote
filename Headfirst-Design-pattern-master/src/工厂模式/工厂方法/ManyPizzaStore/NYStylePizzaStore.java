package 工厂模式.工厂方法.ManyPizzaStore;


import 工厂模式.工厂方法.ManyPizza.*;

public class NYStylePizzaStore extends PizzaStore {

    //new对象的方式统一管理
    /*
     * 确实，从直观上看，只是把代码挪了个位置。但这就是设计模式干的事情
     * 控制边界。“把经常要用的东西放在一块，就更好找。房间也更整齐了。”
     *
     */
    @Override
    public Pizza pizzaFactory(String type) {
        Pizza pizza = null;
        switch (type){
            case "cheese":pizza = new NYStyleCheesePizza();
            case "pepperoni":pizza = new NYStylePepperoniPizza();
            case "greek":pizza = new NYStyleGreekPizza();
        }
        return pizza;
    }
}
