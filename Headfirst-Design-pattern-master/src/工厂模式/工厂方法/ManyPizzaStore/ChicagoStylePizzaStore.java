package 工厂模式.工厂方法.ManyPizzaStore;

import 工厂模式.工厂方法.ManyPizza.*;
import 工厂模式.工厂方法.ManyPizza.Pizza;

public class ChicagoStylePizzaStore extends PizzaStore {

    @Override
    public Pizza pizzaFactory(String type) {
        Pizza pizza = null;
        switch (type){
            case "cheese":pizza = new ChicagoStyleCheesePizza();break;
            case "pepperoni":pizza = new ChicagoStylePepperoniPizza();break;
            case "greek":pizza = new ChicagoStyleGreekPizza();break;
        }
        return pizza;
    }

}
