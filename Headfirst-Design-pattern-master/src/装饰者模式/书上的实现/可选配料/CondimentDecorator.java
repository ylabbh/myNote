package 装饰者模式.书上的实现.可选配料;

import 装饰者模式.书上的实现.各种咖啡.Beverage;

import java.util.List;

/**
 * 调料装饰着（CondimentDecorator）
 *
 *
 */
public abstract class CondimentDecorator extends Beverage {//装饰者和被装饰者分明是两种东西，为什么要有继承关系呢？

    //每个配料都有一个定价
    public Double[] pricese;

    public Integer size;

    public void setPricese(Double[] pricese) {
        this.pricese = pricese;
    }

    //所有的装饰者都必须实现自己的getDescription方法
    public abstract List<String> getDescription();


}
