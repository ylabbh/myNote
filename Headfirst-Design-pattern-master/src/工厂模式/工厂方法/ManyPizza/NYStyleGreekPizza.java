package 工厂模式.工厂方法.ManyPizza;

public class NYStyleGreekPizza extends Pizza {


    @Override
    public void prepare() {
        System.out.println("NYStyleGreekPizza prepare...");
    }

    @Override
    public void bake() {
        System.out.println("NYStyleGreekPizza bake...");
    }

    @Override
    public void cut() {
        System.out.println("NYStyleGreekPizza cut...");
    }

    @Override
    public void box() {
        System.out.println("NYStyleGreekPizza box...");
    }
}
