package 装饰者模式.简单实现.可选配料;

import 装饰者模式.简单实现.各种咖啡.Beverage;

public class Soy extends CondimentDecorator {

    private Beverage beverage;

    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        String description = beverage.getDescription();
        return description + ", Soy";
    }

    @Override
    public double cost() {
        double cost = this.beverage.cost();
        return cost + 3.50;
    }
}
