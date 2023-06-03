package 装饰者模式.简单实现.各种咖啡;

/**
 * 浓缩咖啡(Espresso)，实际被装饰对象
 * 实现自己的cost方法，并在构造函数内定义description变量
 */
public class Espresso extends Beverage {

    public Espresso() {
        description="Espresso";
    }

    @Override
    public double cost() {
        return 20.00;
    }


}
