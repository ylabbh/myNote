package 工厂模式.原始场景;
/**
 * 工厂模式：
 *      解决new对象的问题，面向接口编程下，利用多态使代码具有弹性，实际运行时我们可能需要根据实际new各种不同对象。
 *      还是一样的目的----“找出会变化的方面，把他们从不变的部分中分离出来。”
 *场景：披萨商店PizzaStore出售各种Pizza，调用orderPizza(name)就可以得到对应的pizza对象
 */
public class Test {

    public static void main(String[] args) {
        PizzaStore store = new PizzaStore();
        Pizza pizza = store.orderPizza("cheese");
        Pizza pizza1 = store.orderPizza("greek");

    }
}
