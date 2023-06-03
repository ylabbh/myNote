package 工厂模式.原始场景;

public class PepperoniPizza extends Pizza {


    @Override
    public void prepare() {
        System.out.println("PepperoniPizza prepare...");
    }

    @Override
    public void bake() {
        System.out.println("PepperoniPizza bake...");
    }

    @Override
    public void cut() {
        System.out.println("PepperoniPizza cut...");
    }

    @Override
    public void box() {
        System.out.println("PepperoniPizza box...");
    }
}
