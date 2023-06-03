package 装饰者模式.简单实现.可选配料;

import 装饰者模式.简单实现.各种咖啡.Beverage;

/**
 * 摩卡(Mocha)是一种调料，因此继承CondimentDecorator没有疑问
 *
 * 虽然是继承CondimentDecorator，但两个方法getDescription/cost都已经被抽象
 * 装饰者首先必须保证和被装饰者行为保持一致。才能层层调用。
 *
 */
public class Mocha extends CondimentDecorator {

    private Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        String description = beverage.getDescription();
        return description + ",Mocha";
    }

    @Override
    public double cost() {
        double cost = beverage.cost();
        cost += 1.3;
        return cost;
    }

}
