package 工厂模式.原始场景;

public class CheesePizza extends Pizza {


    @Override
    public void prepare() {
        System.out.println("CheesePizza prepare...");
    }

    @Override
    public void bake() {
        System.out.println("CheesePizza bake...");
    }

    @Override
    public void cut() {
        System.out.println("CheesePizza cut...");
    }

    @Override
    public void box() {
        System.out.println("CheesePizza box...");
    }
}
