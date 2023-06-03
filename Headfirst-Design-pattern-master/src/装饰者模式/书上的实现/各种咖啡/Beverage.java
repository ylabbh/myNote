package 装饰者模式.书上的实现.各种咖啡;

import 装饰者模式.书上的实现.BeverageCondimentSize;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 饮料(Beverage)，被装饰对象的基类
 */
public abstract class Beverage {

    //如果它将被装饰，且我需要知晓装饰链，可以用list，将装饰的内容存起来，装饰玩再处理
    //我可能有mocha，soy，Whip，等等许多配料，如何存？
    // 方式一：定义个规则好了，下标散列，计数。index：0.咖啡名称, 1.Mocha，2.soy，3.Whip--考虑拓展性的话，这种方式可扩展，强耦合
    // 方式二：耦合性太强，还是正常存好了。
    public List<String> descriptions = new ArrayList<>();

    public Double[] pricese;

    public Integer size = BeverageCondimentSize.grand;

    //这是被装饰的要素之一，因为每个被装饰对象都有一个自己初始的量，因此没有定义为abstract。
    /*
    }*/
    public List<String> getDescription() {
        if (descriptions.size() > 1){
            String s = descriptions.get(0);
            descriptions = new ArrayList<>();
            descriptions.add(s);
        }
        return descriptions;
    }

    //这同样也是被装饰的要素。为什么
    public abstract double cost();

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        String s = descriptions.get(0);
        s = size+s.substring(1);
        descriptions.remove(0);
        descriptions.add(0,s);
        this.size = size;
    }

    public Double[] getPricese() {
        return pricese;
    }

    public void setPricese(Double[] pricese) {
        this.pricese = pricese;
    }

}
