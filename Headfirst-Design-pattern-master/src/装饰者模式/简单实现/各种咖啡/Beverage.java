package 装饰者模式.简单实现.各种咖啡;

/**
 * 饮料(Beverage)，被装饰对象的基类
 */
public abstract class Beverage {

    String description = "Unknown Bevetage";

    public String getDescription() {
        return description;
    }

    //这同样也是被装饰的要素。为什么
    public abstract double cost();

}
