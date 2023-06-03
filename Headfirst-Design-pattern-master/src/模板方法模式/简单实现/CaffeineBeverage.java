package 模板方法模式.简单实现;

/**
 * 咖啡因饮料。咖啡和茶的超类。
 *
 * 咖啡和茶的冲泡方法是类似的，只是实现细节有点差异。那么为了进一步抽象，我们泛化这些方法。加柠檬和加牛奶都是“加调料”。具体怎么加，让子类去实现。
 */
public abstract class CaffeineBeverage {

    /**
     * 这就是个模板方法。用作一个算法的模板。
     * ！在模板中，算法内的每个步骤都被一个方法代表
     * 某些通用方法有基类自行定义。有些则需要子类处理。
     *
     * 模板方法
     * --专注在算法本身，由子类提供完整实现；
     * --提供了一个框架，可以让新的咖啡因饮料插入进来。
     *
     * final:为什么？是为了避免子类改变这个算法的顺序。我们只在这里管理并保护这个算法的基本结构。
     */
    final void prepareRecipe(){
        boilWater();//烧水
        brew();//冲泡
        pourInCup();//倒入杯中
        addCondiments();//添加配料
    }

    //不同的子类饮料实现上有点差异，让将来的子类自行实现，这里我们只控制它们的执行顺序。
    abstract void brew();
    abstract void addCondiments();

    void boilWater(){
        System.out.println("烧水中....");
    }

    void pourInCup(){
        System.out.println("倒入杯中.....");
    }


}
