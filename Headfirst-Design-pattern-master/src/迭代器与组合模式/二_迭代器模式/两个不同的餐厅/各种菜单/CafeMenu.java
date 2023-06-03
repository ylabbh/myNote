package 迭代器与组合模式.二_迭代器模式.两个不同的餐厅.各种菜单;

import 迭代器与组合模式.二_迭代器模式.两个不同的餐厅.各种菜单.菜单项.MenuItem;

import java.util.Hashtable;
import java.util.Iterator;

public class CafeMenu implements Menu{

    Hashtable menuItems = new Hashtable();

    public CafeMenu(){
        addItem("咖啡1","特浓咖啡",true,3.99);
        addItem("咖啡2","苦咖啡",false,3.99);
        addItem("咖啡3","加奶加糖",true,3.911);
        addItem("咖啡4","不好喝的猫屎咖啡",true,3.91);
    }

    public void addItem(String name,String description,boolean vegetarian,double price){
        MenuItem menuItem = new MenuItem(name,description,vegetarian,price);
        menuItems.put(menuItem.getName(),menuItem);

    }

    @Override
    /**
     * 这里取得的是value的迭代器
     */
    public Iterator createIterator() {
        return menuItems.values().iterator();
    }
}
