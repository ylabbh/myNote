package 代理模式.三_另一种演示_虚拟代理.例二;

import java.util.LinkedList;
import java.util.List;
 
public class Boss implements Approvable {
    List<String> orders;
 
    {
        System.out.println("\nBoss类加载...\n");
 
    }


    /*构造函数*/
    public Boss() {
        System.out.println("老板来了....");
        this.orders = new LinkedList<>();
    }
    public Boss(List<String> orders) {
        System.out.println("老板来了....");
        if (orders != null) {
            this.orders = orders;
        } else {
            this.orders = new LinkedList<>();
        }
    }



    public void addOrder(String order) {
        this.orders.add(order);
    }
 
    @Override
    public void approve() {
        while(orders.size()>0){
            String order = orders.remove(0);
            System.out.println("Boss处理了任务<" + order + ">");
        }
        System.out.println();
    }
}