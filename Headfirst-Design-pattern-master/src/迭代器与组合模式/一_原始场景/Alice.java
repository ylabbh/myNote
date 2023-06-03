package 迭代器与组合模式.一_原始场景;

import 迭代器与组合模式.一_原始场景.不同餐厅的菜单.DinerMenu;
import 迭代器与组合模式.一_原始场景.不同餐厅的菜单.PancakeHouseMenu;
import 迭代器与组合模式.二_迭代器模式.两个不同的餐厅.各种菜单.菜单项.MenuItem;

import java.util.ArrayList;

//通过引入统一迭代器，我们做到了解耦，现在Alice在完成遍历各种集合的工作时，不再需要关心这些集合的结构究竟是怎样的。她也无法知道。
//因为解耦，这个类更加具有扩展性了。将来有新的菜单，我也不需要引入更多的类，不需要依赖更多东西，只需要取得相应的迭代器即可。


/**
 * 一个女招待员，现在我们要整合DinerMenu和PancakeHouse两个餐饮店到一起。
 * 两种菜单数据结构不同 MenuItem[] menuItems;  ArrayList menuItems;
 *
 * 那么遍历方式也不同。
 */
public class Alice {
    //----------------------------初始方式
    public void printMenu(){
        PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
        ArrayList breakfastItems = pancakeHouseMenu.getMenuItems();
        DinerMenu dinerMenu = new DinerMenu();
        MenuItem[] lunckItems = dinerMenu.getMenuItems();

        /**
         * //由于两个餐厅的菜单结构不同，一个是数组一个是ArrayList，因此我只能用不同的循环来遍历。
         *         //问题1--难以维护：但是，如果以后有100家餐厅需要对接呢？----显然，这一部分是我们需要封装的（分离并封装变化）
         *         //问题2--信息渗透。这种实现，Alice类需要知道所有的数据结构，不符合“最少知识原则”（一个类不应该关心太多其它类的细节，它应只关心自己的本职工作。---Alice的工作只是打印所有菜单，至于菜单怎么设置，并不关心。）
         */
        for (int i = 0; i < breakfastItems.size(); i++) {
            MenuItem menuItem = (MenuItem)breakfastItems.get(i);
            System.out.print(menuItem.getName() + "  ");
            System.out.println(menuItem.getPrice() + "   ");
            System.out.println(menuItem.getDesription());
        }

        for (int i = 0; i < lunckItems.length; i++) {
            MenuItem lunckItem = lunckItems[i];
            System.out.print(lunckItem.getName() + "   ");
            System.out.println(lunckItem.getPrice()+"   ");
            System.out.println(lunckItem.getDesription());
        }
    }
    //----------------------------初始方式END--------------------------------------



}
