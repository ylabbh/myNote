package 装饰者模式.书上的实现.可选配料;

import 装饰者模式.书上的实现.各种咖啡.Beverage;

import java.util.List;

public class Whip extends CondimentDecorator {

    private Beverage beverage;

    public Whip(Beverage beverage) {
        size = beverage.getSize();
        Double[] prices = {0.7,1.0,1.3};
        setPricese(prices);
        this.beverage = beverage;
    }

    @Override
    public List<String> getDescription() {
        List<String> descriptions = beverage.getDescription();
        descriptions.add("Whip");
        return descriptions;
    }

    @Override
    public double cost() {
        double cost = this.beverage.cost();
        return cost + pricese[beverage.getSize()];
    }

}
