package 模板方法模式.简单实现;

/**
 * 场景：有茶和咖啡。它们的冲泡方法其实是很像的，烧水，放原料，泡一会，加点配料。那么我们抽取出CaffeineBeverage。冲泡方法prepareRecipe（）每个步骤顺序是相同的，只是子类的具体实现不同。
 *
 * 模板方法：
 * ---在一个方法中定义一个算法的骨架，而将一些步骤延迟到子类中。模板方法使得子类可以再不改变算法结构的情况下，重新定义算法的某些步骤。
 * ---定义了一个算法的步骤，允许子类为一个或多个步骤提供实现。
 * ---有一个“钩子”的概念， 看演示。
 *
 * 相关设计原则：好莱坞原则------别打电话（调用）给我们，我们会打给你（调用你）。
 *       好莱坞原则下，我们允许低层组件将自己挂钩到系统上，但是高层组件会决定什么时候怎样使用这些低层组件。换句话说。整体控制在于高层组件，具体细节由高层组件调用低层组件。Debug一下就知道，首先运行父类的模板方法，具体实现时，访问对应的子类。
 *       依赖倒置：“尽量避免使用具体类，多使用抽象。”
 *       好莱坞原则：用在创建框架或组件上的一种技巧，好让低层组件能够被挂钩到计算中，又不会让高层组件依赖低层组件。
 */
public class Test {

    public static void main(String[] args) {
        CaffeineBeverage tea = new Tea();
        CaffeineBeverage coffee = new Coffee();
        System.out.println("----------泡一杯茶");
        tea.prepareRecipe();
        System.out.println("----------泡一杯咖啡");
        coffee.prepareRecipe();
    }
}
