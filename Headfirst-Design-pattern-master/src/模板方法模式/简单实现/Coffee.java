package 模板方法模式.简单实现;

public class Coffee extends CaffeineBeverage {
    @Override
    void brew() {
        System.out.println("冲泡咖啡...");
    }

    @Override
    void addCondiments() {
        System.out.println("加点牛奶.....");
    }
}
