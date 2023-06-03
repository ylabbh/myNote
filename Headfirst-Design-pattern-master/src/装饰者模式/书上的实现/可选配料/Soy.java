package 装饰者模式.书上的实现.可选配料;

import 装饰者模式.书上的实现.各种咖啡.Beverage;

import java.util.List;

public class Soy extends CondimentDecorator {

    private Beverage beverage;



    public Soy(Beverage beverage) {
        size = beverage.getSize();
        Double[] prices = {0.5,1.0,2.0};
        setPricese(prices);
        this.beverage = beverage;
    }

    @Override
    public List<String> getDescription() {
        List<String> descriptions = beverage.getDescription();
        descriptions.add("Soy");
        return descriptions;
    }

    @Override
    public double cost() {
        double cost = this.beverage.cost();
        return cost + pricese[beverage.getSize()];
    }

}
