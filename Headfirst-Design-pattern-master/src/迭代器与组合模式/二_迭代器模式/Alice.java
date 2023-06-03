package 迭代器与组合模式.二_迭代器模式;

import 迭代器与组合模式.二_迭代器模式.两个不同的餐厅.各种菜单.Menu;
import 迭代器与组合模式.二_迭代器模式.两个不同的餐厅.各种菜单.菜单项.MenuItem;

//通过引入统一迭代器，我们做到了解耦，现在Alice在完成遍历各种集合的工作时，不再需要关心这些集合的结构究竟是怎样的。她也无法知道。
//因为解耦，这个类更加具有扩展性了。将来有新的菜单，我也不需要引入更多的类，不需要依赖更多东西，只需要取得相应的迭代器即可。
import java.util.ArrayList;
import java.util.Iterator;


/**
 * 一个女招待员，现在我们要整合DinerMenu和PancakeHouse两个餐饮店到一起。
 */
public class Alice {
    //----------------------------初始方式
    //----------------------------迭代器方式-----*-
    /*
    Menu pancakeHouseMenu;
    Menu dinerMenu;
    Menu cafeMenu;
    public Alice(Menu pancakeHouseMenu, Menu dinerMenu,Menu cafeMenu) {
        this.pancakeHouseMenu = pancakeHouseMenu;
        this.dinerMenu = dinerMenu;
        this.cafeMenu = cafeMenu;

    }

    public void printMenu() {
        //这里我们试着演示listIterator迭代器

        //可以看到，到这里这部分还没有优化，新添加集合，我都需要在这里添加代码，而且代码很重复。
        //那么我们继续进行优化---需要一种统一管理它们的方法
        ListIterator pancakeIterator = (ListIterator)pancakeHouseMenu.createIterator();
        Iterator dinerIterator = dinerMenu.createIterator();
        Iterator cafeMenuIterator = cafeMenu.createIterator();
        System.out.println("MENU\n----------- \nBREAKFAST");
        printMenu(pancakeIterator);
        System.out.println("\nLUNCH");
        printMenu(dinerIterator);
        System.out.println("\nCAFE");
        printMenu(cafeMenuIterator);

    }*/
    //----------------------------迭代器方式END-----*-
    /**
     * 优化后，使用一个集合管理所有menus。相当于又往上收束了一层
     */
    ArrayList<Menu> menus;

    public Alice(ArrayList<Menu> menus) {
        this.menus = menus;
    }

    public void printMenu(){
        Iterator menuIterator = menus.iterator();
        while (menuIterator.hasNext()){
            Menu next = (Menu)menuIterator.next();
            printMenu(next.createIterator());
        }
    }

    private void printMenu(Iterator iterator){
        while(iterator.hasNext()){
            MenuItem menuItem = (MenuItem) iterator.next();
            System.out.println(menuItem.getName() + " ,");
            System.out.println(menuItem.getDesription() + " -- ");
            System.out.println(menuItem.getPrice());
        }
    }


}
