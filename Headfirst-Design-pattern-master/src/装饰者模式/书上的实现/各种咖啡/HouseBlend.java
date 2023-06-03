package 装饰者模式.书上的实现.各种咖啡;

public class HouseBlend extends Beverage{


    public HouseBlend() {
        Double[] pricese = {25.00,30.00,35.00};
        setPricese(pricese);
        descriptions.add(getSize()+"House Blend Coffe");
    }

    @Override
    public double cost() {

        return this.pricese[getSize()];
    }

}
