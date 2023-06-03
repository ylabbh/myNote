package 装饰者模式.书上的实现.可选配料;

import 装饰者模式.书上的实现.各种咖啡.Beverage;

import java.util.List;

/**
 * 摩卡(Mocha)是一种调料，因此继承CondimentDecorator没有疑问
 *
 *
 */
public class Mocha extends CondimentDecorator {

    private Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
        size = beverage.getSize();
        Double[] prices = {1.0,2.0,3.0};
        setPricese(prices);
    }

    @Override
    public List<String> getDescription() {
        List<String> descriptions = beverage.getDescription();
        descriptions.add("Mocha");
        return descriptions;
    }


    @Override
    public double cost() {
        double cost = this.beverage.cost();
        return cost + pricese[beverage.getSize()];
    }

}
