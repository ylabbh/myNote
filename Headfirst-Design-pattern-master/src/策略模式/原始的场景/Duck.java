package 策略模式.原始的场景;

/**
 * 鸭子父类
 */
public abstract class Duck {

    /**
     * 鸭子叫的方法
     */
    public void quack(){
        System.out.println("呱呱呱~~");
    }

    /**
     * 游泳
     */
    public void swim(){
        System.out.println("Duck游泳");
    }


    /**
     * “展示外观”,因为每种鸭子外观不同，所以这个方法为抽象,让子类自己实现。
     */
    public abstract void display();


    //-------------添加行为------------------------
    public void fly(){
        System.out.println("Duck飞了起来");
    }

    public void eating(){
        System.out.println("Duck吃饭中....");
    }
    //-------------------------------------

}

/**
 * 野鸭
 */
class MallardDuck extends Duck{

    @Override
    public void display() {
        System.out.println("我是野鸭：毛很乱。");
    }
}

/**
 * 红头鸭
 */
class RedHeadDuck extends Duck{

    @Override
    public void display() {
        System.out.println("我是红头鸦：头是红色的");
    }

}


/**
 * 橡皮鸭
 * 橡皮鸭不会呱呱叫(quack), 而是吱吱叫(squeak)
 */
class RubberDuck extends Duck {

    @Override
    public void display() {
        System.out.println("可爱的黄色橡皮鸭");
    }

    //橡皮鸭不会呱呱叫(quack), 而是吱吱叫(squeak)
    @Override
    public void quack() {
        System.out.println("橡皮鸭吱吱叫");
    }

    //橡皮鸭不会飞所以什么都不做
    @Override
    public void fly() {

    }


}

/**
 * 诱饵鸭, 不会飞也不会叫
 */
class DecoyDuck extends Duck {

    @Override
    public void display() {
        System.out.println("诱饵鸭");
    }

    @Override
    public void quack() {
    }

    @Override
    public void fly() {
    }
}