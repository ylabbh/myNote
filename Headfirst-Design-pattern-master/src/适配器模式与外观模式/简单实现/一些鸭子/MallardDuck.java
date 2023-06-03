package 适配器模式与外观模式.简单实现.一些鸭子;

/**
 * 绿头鸭类
 */
public class MallardDuck implements Duck {
    @Override
    public void quack() {
        System.out.println("MallardDuck:Quack!!");
    }

    @Override
    public void fly() {
        System.out.println("MallardDuck:flying!!");
    }

}
