package 迭代器与组合模式.二_迭代器模式.两个不同的餐厅.各种菜单;

import 迭代器与组合模式.二_迭代器模式.两个不同的餐厅.对应的迭代器.DinerMenuIterator;
import 迭代器与组合模式.二_迭代器模式.两个不同的餐厅.各种菜单.菜单项.MenuItem;

import java.util.Iterator;


/**
 * 这里有两个菜单类，实现方式不尽相同，现在，我们要进行整合。
 */
public class DinerMenu implements Menu{

    static final int MAX_ITEMS = 6;

    int numberOfItems = 0;

    MenuItem[] menuItems;

    public DinerMenu(){
        menuItems = new MenuItem[MAX_ITEMS];
        addItem("Vegetarian BLT","(Fakin') Bacon with lettuce & tomato on whole wheat",true,2.99);
        addItem("BLT","Bacon with lettuce & tomato on whole wheat",false,2.99);
        addItem("Soup of the day","Soup of the day, hith a side of potato salad",false,3.29);
        addItem("Hotdog","A hot dog, with saurkraut, relish, onions, topped with cheese",false,3.05);

    }

    public void addItem(String name,String description,boolean vegetarian,double price){
        MenuItem menuItem = new MenuItem(name,description,vegetarian,price);
        if (numberOfItems >= MAX_ITEMS){
            System.out.println("菜单已经满了，不能添加新的选项。");
        }else{
            menuItems[numberOfItems] = menuItem;
            numberOfItems = numberOfItems + 1;
        }

    }

    /**
     * 使用迭代器改写后，这里返回一个迭代器，迭代器内已经带着这个菜单数组了
     * @return
     */
    /*public MenuItem[] getMenuItems(){
        return menuItems;
    }*/
    public Iterator createIterator(){
        return new DinerMenuIterator(menuItems);
    }

}
