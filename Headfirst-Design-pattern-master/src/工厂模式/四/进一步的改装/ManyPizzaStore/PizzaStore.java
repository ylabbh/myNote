package 工厂模式.四.进一步的改装.ManyPizzaStore;

import 工厂模式.四.进一步的改装.ManyPizza.Pizza;

public abstract class PizzaStore {

    /**
     * 必胜客有很多的加盟店，我希望这些加盟店都使用我那些“经过时间考验的代码”，同时又保留他们自己的区域差异，一定的自由度。
     * 在简单实现中，我们将createPizza方法抽取出来有工厂管理。那么使用这个工厂的商店，都只能制作统一一套Pizza
     * 现在我希望的是“Pizza的种类我不管，但是每个加盟店都必须按照我的加工流程，prepare,bake,cut,box。”
     * 那么我们做改造，抽象这个PizzaStore，抽象createPizza，让各自的加盟店自己实现，但是orderPizza的其余流程统一控制。PizzaStore抽象后，并不知道将来子类会如何实现createPizza方法。这就达到了“解耦”的目的。
     *
     * 设计原则：
     * ----依赖倒置原则--依赖抽象，而不要依赖具体类（依赖：在一个类中引入另一个类。）
     * 解释：
     * ----“不要让高层组件依赖底层组件--一个方法中引入太多其它类是一个比较失败的设计”
     * ----“高低层组件都应该依赖于抽象类”
     * 几个指导方针：
     * 1.变量不可以持有具体类的引用（不应该直接new）
     * 2.不要让类派生自具体类
     * 3.不要覆盖积累中已实现的方法（如果要覆盖，那方法可能并不适合被继承。父类已经实现的东西，应该让所有子类都能通用。）
     *
     * @param type
     * @return
     */
    public Pizza orderPizza(String type){
        Pizza pizza = null;
        pizza = pizzaFactory(type);
        //这就是一种更抽象的编程方式，我并不知道这里执行的是哪个具体示例。我是在对一堆子类进行编程。--多态
        ////解耦，是谁和谁解耦。在这个案例中，有两个东西，Pizza和Store(父类)。有各种pizza，也有各种store。我不希望在store代码中，有一堆的pizza。我甚至希望在store中，可以不关心pizza究竟具体有哪些。但同时我依旧可以使用一切pizza。
        // ！！因此如何理解？首先我需要明白一个场景中有哪些主体。然后才有办法设计更抽象、更解耦的代码。
        if (pizza != null){
            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.box();
        }
        return pizza;

    }

    /**
     * 创建对象的流程进行抽象，子类自己实现各自的工厂。
     * @param type
     * @return
     */
    public abstract Pizza pizzaFactory(String type);
}
