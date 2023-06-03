package 迭代器与组合模式.一_原始场景.不同餐厅的菜单;

import 迭代器与组合模式.二_迭代器模式.两个不同的餐厅.各种菜单.菜单项.MenuItem;

import java.util.ArrayList;

/**
 * 煎饼屋菜单
 */
public class PancakeHouseMenu {

    ArrayList menuItems;

    public PancakeHouseMenu(){
        menuItems = new ArrayList();
        addItem("煎饼早餐A", "有蛋，有肉。$#@$@#$@#$", true, 2.99);
        addItem("煎饼早餐B", "煎饼早餐B%$$#%$#^$@", false, 2.99);
        addItem("煎饼早餐C","Pancakes made with fresh blueberries",true,3.49);
        addItem("煎饼早餐D","Waffles, with your choice of blueberries or strawberries",true,3.59);
    }


    public void addItem(String name,String description,boolean vegetarian,double price){
        MenuItem menuItem = new MenuItem(name,description,vegetarian,price);
        menuItems.add(menuItem);
    }

    public ArrayList getMenuItems() {
        return menuItems;
    }

}
