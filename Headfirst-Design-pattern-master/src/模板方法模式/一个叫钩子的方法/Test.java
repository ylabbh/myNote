package 模板方法模式.一个叫钩子的方法;

/**
 * 通过钩子，我们实现动态地决定是否执行“加调料”的方法addCondiments
 *
 * 何时用？子类必须提供算法中某个方法或步骤的实现时。就抽象这些步骤方法。
 * 如果这些步骤同时还是可选的，执不执行得看子类自己定。那就加钩子。
 *
 * 钩子用法：
 * 1.让算法中某些步骤变成可选项。
 * 2.让子类有机会对模板方法中的某些即将发生或已发生的步骤做反应。----因为钩子方法时写在模板方法的步骤中的。且在基类中通常定义成什么都不做。因此如果子类不覆盖，那么其实是可以无视的。如果子类覆盖，那就可以了解运行中模板方法的执行状态。
 */
public class Test {

    public static void main(String[] args) {
        CoffeeWithHook coffee = new CoffeeWithHook();
        coffee.prepareRecipe();
    }
}
