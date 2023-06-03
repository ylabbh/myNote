package 适配器模式与外观模式.简单实现.一些火鸡;

public class WildTurkey implements Turkey {
    @Override
    public void gobble() {
        System.out.println("Turkey:Gobble gobble!!");//火鸡叫
    }

    @Override
    public void fly() {
        System.out.println("Turkey:flying a short distance!");
    }
}
