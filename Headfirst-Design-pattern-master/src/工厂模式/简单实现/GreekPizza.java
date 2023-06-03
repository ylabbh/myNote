package 工厂模式.简单实现;

public class GreekPizza extends Pizza {


    @Override
    public void prepare() {
        System.out.println("GreekPizza prepare...");
    }

    @Override
    public void bake() {
        System.out.println("GreekPizza bake...");
    }

    @Override
    public void cut() {
        System.out.println("GreekPizza cut...");
    }

    @Override
    public void box() {
        System.out.println("GreekPizza box...");
    }
}
