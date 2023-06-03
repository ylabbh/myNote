package 模板方法模式.简单实现;

public class Tea extends CaffeineBeverage {
    @Override
    void brew() {
        System.out.println("冲泡茶叶...");
    }

    @Override
    void addCondiments() {
        System.out.println("加点柠檬....");
    }
}
