package 工厂模式.简单实现;

/**
 * 这并不是真正的是工厂模式
 */
public class SimplePizzaFactory {

    /*
     * 可能有许多地方都需要使用这个方法，因此从主流程中抽取出来。
     *
     * 可以定义成静态的，但是这就不能通过继承来修改这个方法了。
     *
     */
    public Pizza createPizza(String type){
        Pizza pizza = null;
        switch (type){
            case "cheese":pizza = new CheesePizza(); break;
            case "greek":pizza = new GreekPizza(); break;
            case "pepperoni":pizza = new PepperoniPizza(); break;
        }
        return pizza;
    }

}
