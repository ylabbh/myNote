package 工厂模式.简单实现;

public class Test {

    public static void main(String[] args) {
        PizzaStore store = new PizzaStore(new SimplePizzaFactory());
        Pizza pizza = store.orderPizza("cheese");
        Pizza pizza1 = store.orderPizza("greek");

    }
}
