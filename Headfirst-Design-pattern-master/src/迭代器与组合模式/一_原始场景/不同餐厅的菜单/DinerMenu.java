package 迭代器与组合模式.一_原始场景.不同餐厅的菜单;

import 迭代器与组合模式.二_迭代器模式.两个不同的餐厅.各种菜单.菜单项.MenuItem;


/**
 * 这里有两个菜单类，实现方式不尽相同，现在，我们要进行整合。
 */
public class DinerMenu{

    static final int MAX_ITEMS = 6;

    int numberOfItems = 0;


    /**
     * 注意这里就好，两种餐厅的菜单项的数据结构不同
     */
    MenuItem[] menuItems;

    public DinerMenu(){
        menuItems = new MenuItem[MAX_ITEMS];
        addItem("(中餐厅)蔬菜套餐","(Fakin') Bacon with lettuce & tomato on whole wheat",true,2.99);
        addItem("(中餐厅)米饭","Bacon with lettuce & tomato on whole wheat",false,2.99);
        addItem("(中餐厅)例汤","Soup of the day, hith a side of potato salad",false,3.29);
        addItem("(中餐厅)热狗1","A hot dog, with saurkraut, relish, onions, topped with cheese",false,3.05);
        addItem("(中餐厅)热狗2","A hot dog, with saurkraut, relish, onions, topped with cheese",false,3.05);
        addItem("(中餐厅)热狗3","A hot dog, with saurkraut, relish, onions, topped with cheese",false,3.05);

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


    public MenuItem[] getMenuItems(){
        return menuItems;
    }

}
