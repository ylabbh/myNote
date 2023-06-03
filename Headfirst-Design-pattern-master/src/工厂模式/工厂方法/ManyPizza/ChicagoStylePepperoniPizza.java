package 工厂模式.工厂方法.ManyPizza;

public class ChicagoStylePepperoniPizza extends Pizza {


    @Override
    public void prepare() {
        System.out.println("ChicagoStylePepperoniPizza prepare...");
    }

    @Override
    public void bake() {
        System.out.println("ChicagoStylePepperoniPizza bake...");
    }

    @Override
    public void cut() {
        System.out.println("ChicagoStylePepperoniPizza cut...");
    }

    @Override
    public void box() {
        System.out.println("ChicagoStylePepperoniPizza box...");
    }
}
