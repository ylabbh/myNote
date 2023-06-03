package 装饰者模式.简单实现.可选配料;

import 装饰者模式.简单实现.各种咖啡.Beverage;

/**
 * 调料装饰着（CondimentDecorator）
 *
 *
 */
public abstract class CondimentDecorator extends Beverage {//装饰者和被装饰者分明是两种东西，为什么要有继承关系呢？

    //所有的装饰者都必须实现自己的getDescription方法
    public abstract String getDescription();
}
