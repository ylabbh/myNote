package 策略模式.原始的场景;

public class Test {

    public static void main(String[] args) {
        MallardDuck duck1 = new MallardDuck();
        RedHeadDuck duck2 = new RedHeadDuck();

        duck1.quack();
        duck1.swim();
        duck1.display();

        duck2.quack();
        duck2.swim();
        duck2.display();
    }
}
