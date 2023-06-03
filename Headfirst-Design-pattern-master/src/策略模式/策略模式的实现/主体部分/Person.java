package 策略模式.策略模式的实现.主体部分;

import 策略模式.策略模式的实现.算法族.KongFu;

public abstract class Person {

    public KongFu kongFu;

    /**
     * 将无参构造私有，子类初始化的时候必须指定一门武功
     */
    private Person(){

    }

    public Person(KongFu kongFu) {
        this.kongFu = kongFu;
    }


    /**
     * 人物介绍
     */
    public abstract void display();

    /**
     * 展示自己的功夫
     */
    public void performKongFu(){
        kongFu.displayKongFu();
    }

    /**
     * 动态地改变功夫
     * @param kongFu
     */
    public void setKongFu(KongFu kongFu) {
        this.kongFu = kongFu;
    }


}
