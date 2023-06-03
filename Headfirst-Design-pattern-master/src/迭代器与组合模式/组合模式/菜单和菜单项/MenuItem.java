package 迭代器与组合模式.组合模式.菜单和菜单项;


import 迭代器与组合模式.组合模式.迭代器.CompositeIterator;

import java.util.Iterator;

/**
 * 这是  “叶节点”  因为Item处于树形结构最底层，没有更往下的分支了。所以是叶子。
 */
public class MenuItem extends MenuComponent {
    String name;
    String description;
    boolean vegetarian;
    double price;

    //----------构造函数
    public MenuItem(String name, String description, boolean vegetarian, double price) {
        this.name = name;
        this.description = description;
        this.vegetarian = vegetarian;
        this.price = price;
    }

    //-----------四个get方法
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public double getPrice() {
        return price;
    }
    public boolean isVegetarian() {
        return vegetarian;
    }



    //-----------打印方法，对于菜单项来说，此方法打印完整的条目。
    public void print() {
        System.out.print("  " + getName());
        if (isVegetarian()) {
            System.out.print("(v)");
        }
        System.out.println(", " + getPrice());
        System.out.println("     -- " + getDescription());
    }


    public Iterator createIterator(){
        return new CompositeIterator(new NullIterator());
    }
}