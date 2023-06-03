package 策略模式.策略模式的实现.主体部分;

import 策略模式.策略模式的实现.算法族.KongFu;

public class PersonXiaoFeng extends Person {

    public PersonXiaoFeng(KongFu kongFu) {
        super(kongFu);
    }

    @Override
    public void display() {
        System.out.println("萧峰，丐帮帮主，容貌英伟。");
    }

}
