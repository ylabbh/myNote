package 工厂模式.工厂方法.ManyPizza;

public class NYStyleCheesePizza extends Pizza {


    @Override
    public void prepare() {
        System.out.println("NYStyleCheesePizza prepare...");
    }

    @Override
    public void bake() {
        System.out.println("NYStyleCheesePizza bake...");
    }

    @Override
    public void cut() {
        System.out.println("NYStyleCheesePizza cut...");
    }

    @Override
    public void box() {
        System.out.println("NYStyleCheesePizza box...");
    }
}
