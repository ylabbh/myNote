package 迭代器与组合模式.一_原始场景;

/**
 * 组合模式与迭代器--良好的集合管理
 * 有时候，我们有一堆对象，分开管理太麻烦，我希望把它们集中起来，写个循环调用它们方法。
 * 但是不同对象存在差异（数据结构等）咋整？
 *
 */
public class Test {

    public static void main(String[] args) {
        Alice alice = new Alice();
        alice.printMenu();
    }
}
