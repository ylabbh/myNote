package 工厂模式.工厂方法.ManyPizza;

public class ChicagoStyleGreekPizza extends Pizza {


    @Override
    public void prepare() {
        System.out.println("ChicagoStyleGreekPizza prepare...");
    }

    @Override
    public void bake() {
        System.out.println("ChicagoStyleGreekPizza bake...");
    }

    @Override
    public void cut() {
        System.out.println("ChicagoStyleGreekPizza cut...");
    }

    @Override
    public void box() {
        System.out.println("ChicagoStyleGreekPizza box...");
    }
}
