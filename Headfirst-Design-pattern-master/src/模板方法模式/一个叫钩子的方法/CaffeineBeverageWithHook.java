package 模板方法模式.一个叫钩子的方法;

public abstract class CaffeineBeverageWithHook {

    final void prepareRecipe(){
        boilWater();//烧水
        brew();//冲泡
        pourInCup();//倒入杯中
        if (customerWantsCondiments()){
            addCondiments();//添加配料
        }
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

    /**
     * 模板方法模式中有“钩子”的概念，具体是什么？
     * 这就是一个钩子，子类可以覆盖，也可以不覆盖。
     * 钩子通常什么都不定做。那么钩子有什么用？
     *
     * 子类通过调整“钩子”，虽然还是不能改变算法的步骤，但是可以控制自己是否要执行其中的某一步。通过钩子，能够给子类带来更多的灵活度。
     *
     *
     * @return
     */
    boolean customerWantsCondiments(){
        return true;
    }
}
