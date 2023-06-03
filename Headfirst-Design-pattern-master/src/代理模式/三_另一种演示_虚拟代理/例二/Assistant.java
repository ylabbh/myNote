package 代理模式.三_另一种演示_虚拟代理.例二;

import java.util.LinkedList;
import java.util.List;

/**
 * 职员，BOSS的代理Proxy。
 */
public class Assistant implements Approvable {
    List<String> orders;
    volatile Boss boss;
 
    public Assistant() {
        orders = new LinkedList<>();
    }

    /**
     * 作为虚拟代理，就是在对象可能不存在的时候，能够先帮对象做一些事情。
     * @param order
     */
    public void addOrder(String order) {
        if (boss != null) {
            System.out.println("Boss亲自将<" + order + ">任务添加到列表");
            boss.addOrder(order);
        } else {
            System.out.println("助手将<" + order + ">任务添加到列表");
            this.orders.add(order);
        }
    }
 
    @Override
    public void approve() {
        inviteBoss();
        boss.approve();
    }

    private void inviteBoss() {
        if (boss == null) {
            synchronized (this) {
                /**
                 * 如果被代理的对象不存在，那么就重新new一个
                 *
                 */
                if (boss == null) {
                    boss = new Boss(orders);
                }
            }
        }
    }
}