package 观察者模式.自己的一些升级;

public class Test {

    /**
     * 类似于监听，可以理解为对象之间的交流。一个对象发生改变，我希望另一个对象立刻做出相应的变化时。
     * @param args
     */
    public static void main(String[] args) {
        Person p1 = new Person("定华");
        Person p2 = new Person("鸿辉");
        Person p3 = new Person("晓辉");
        Paper s1 = new Paper("南都周刊");
        Paper s2 = new Paper("三联生活周刊");
        Paper s3 = new Paper("bilibili周报");
        p1.registSubject(s1);
        p1.registSubject(s2);
        p2.registSubject(s2);
        p2.registSubject(s3);
        p3.registSubject(s3);
        s1.removeObserver(p1);
        s1.getMessage("今天又有一个人到海南上班了");
        s2.getMessage("明天周六，可以出去玩");
        s3.getMessage("木鱼水心又更新了");

    }

}
