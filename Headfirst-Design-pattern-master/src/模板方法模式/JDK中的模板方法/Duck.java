package 模板方法模式.JDK中的模板方法;

/**
 * 演示java中的排序。我们知道，要实现对象的排序，只要实现Comparable，重写compareTo方法就可以了。
 * 可是为什么要这样？
 * 其一，什么对象要排前面，什么要排后面，即排序的规则需要用户自己定义。
 * 其二，sort()的设计者希望这个方法能用于所有数组，所以它是静态的模板方法。它实现了排序算法--比较大小后按序排列。但是细节上：如何比较大小，需要用户自己定义规则。这符合模板方法的思想--整体控制算法的实现，某些细节交给子类(这里并没有用继承，而是接口的方式来进行统一。)
 *
 * 类似的，java.id的InputStream类有read()方法，由子类实现，这个方法又会被read(byte b[],int off,int len)模板方法使用。
 * 吐槽：这本书作者对鸭子有蜜汁执念......
 */
public class Duck implements Comparable{

    String name;
    int weight;

    public Duck(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    //自定义排序规则--根据鸭子体重进行排序。
    @Override
    public int compareTo(Object o) {
        Duck otherDuck = (Duck)o;
        if (this.weight < otherDuck.weight){
            return -1;
        }else if (this.weight == otherDuck.weight){
            return 0;
        }else{
            return 1;
        }
    }

    @Override
    public String toString() {
        return name + " weights " + weight;
    }



}
