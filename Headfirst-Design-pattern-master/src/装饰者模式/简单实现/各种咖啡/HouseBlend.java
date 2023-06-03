package 装饰者模式.简单实现.各种咖啡;

public class HouseBlend extends Beverage {

    public HouseBlend() {
        description="House Blend Coffe";
    }

    @Override
    public double cost() {
        return 30.00;
    }
}
