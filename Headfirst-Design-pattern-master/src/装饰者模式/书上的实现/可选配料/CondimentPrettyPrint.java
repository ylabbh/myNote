package 装饰者模式.书上的实现.可选配料;



import 装饰者模式.书上的实现.各种咖啡.Beverage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CondimentPrettyPrint extends CondimentDecorator {

    private Beverage beverage;

    public CondimentPrettyPrint(Beverage beverage) {
        this.beverage = beverage;
    }


    @Override
    public List<String> getDescription() {
        List<String> list = new ArrayList<>();
        list.add(getPrettyPrint());
        return list;
    }

    @Override
    public double cost() {
        return beverage.cost();
    }

    private String getPrettyPrint(){
        List<String> descriptions = beverage.getDescription();
        Map<String, Integer> map = new HashMap();
        for (int i = 1; i < descriptions.size(); i++) {
            String s = descriptions.get(i);
            if (map.get(s) == null) {
                map.put(s, 1);
            } else {
                map.put(s, map.get(s) + 1);
            }
        }
        StringBuffer sb = new StringBuffer();
        sb.append(descriptions.get(0));
        if (map.size() > 0) {
            map.forEach((k, v) -> {
                sb.append("," + "+" + k + "*" + v);
            });
        }
        return sb.toString();
    }


}
