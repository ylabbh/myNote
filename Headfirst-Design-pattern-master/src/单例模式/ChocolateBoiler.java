package 单例模式;

/**
 * 巧克力锅炉
 *
 * 单例模式注意事项：两个类加载器可能有机会各自创建自己的单例。
 * 每个类加载器都定义了一个命名空间，如果有两个以上的类加载器，不同的类加载器可能会加载同一个类，从从整个程序看，同一个类会被加载多次
 * 如果再加上单例，就会生成多个单例。-----自行指定类加载器，并指定同一个类加载器。
 *
 */
public class ChocolateBoiler {

    private boolean empty;

    private boolean boiled;

    //volatile关键字确变量被初始化的时候，多个线程正确处理这个变量。？？
    private volatile static ChocolateBoiler chocolateBoiler;

    private ChocolateBoiler(){
        empty = true;
        boiled = false;
    }

    /*
    线程安全问题：
        if (chocolateBoiler == null){
            //有可能在第一次执行时，多个线程同时完成判断进入这里。那么还是new了多次，单例失败。
            chocolateBoiler = new ChocolateBoiler();
        }
        1.同步方法：可以直接在方法级别打上synchronized，让getInstance()变成同步方法，保证线程安全。但是多线程下，如果需要频繁使用，那么性能会下降100倍。
        2.双重检查锁：事实上，只有在第一次执行的时候，才会有这种问题，因此希望只有在第一次执行的时候同步。
    */
    public static ChocolateBoiler getInstance(){
        if (chocolateBoiler == null){//这样，只有当单例还未创建的时候，才需要进行同步，否则不需要同步。保证getInstance的畅通。
            synchronized (ChocolateBoiler.class){
                if (chocolateBoiler == null){
                    chocolateBoiler = new ChocolateBoiler();
                }
            }
        }
        return chocolateBoiler;
    }

    //放入原料的时候，锅炉必须是空的，一旦放入原料，就吧empty和boiled设置好
    public void fill(){
        if (isEmpty()){
            empty = false;
            boiled = false;
            //放入原料
        }
    }

    //排除原料，不能是空的，排除后设置empty
    public void drain(){
        if (!isEmpty() && isBoiled()){
            //排除煮沸的巧克力和牛奶
            empty = true;
        }
    }

    public void boil(){
        if (!isEmpty() && !isBoiled()){
            //将锅炉内物煮沸
            boiled = true;
        }
    }

    private boolean isBoiled() {

        return boiled;
    }

    private boolean isEmpty() {
        return empty;
    }

}
