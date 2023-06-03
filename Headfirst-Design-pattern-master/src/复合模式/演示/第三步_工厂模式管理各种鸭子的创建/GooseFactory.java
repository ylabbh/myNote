package 复合模式.演示.第三步_工厂模式管理各种鸭子的创建;

import 复合模式.演示.各种鸭子.Quackable;
import 复合模式.演示.第二步_引入鹅演示适配器.Goose;
import 复合模式.演示.第二步_引入鹅演示适配器.GooseAdapter;

/**
 * 鹅的工厂，因为鹅引入了适配器模式，这里演示二者如何结合
 * 这里使用静态工厂
 */
public class GooseFactory {

    //普通鹅
    public static Goose createGoose(){
        return new Goose();
    }

    //适配器鹅(外鹅内鸭)
    public static Quackable createGooseAdapter(){
        return new GooseAdapter(new Goose());
    }

}
