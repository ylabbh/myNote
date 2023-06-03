package 工厂模式.原始场景;

import java.util.ArrayList;
import java.util.List;

/**
 * 披萨，每种披萨都有原料material，他们的制作过程是一样的
 */
public abstract class Pizza {

    public List<String> materials;

    //准备原料
    public abstract void prepare();

    public abstract void bake();//烘烤

    public abstract void cut();//切

    public abstract void box();//装盒

}
