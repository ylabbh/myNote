package 迭代器与组合模式.二_迭代器模式.两个不同的餐厅.各种菜单.菜单项;

/**
 * 菜单项类，不管是什么形式的菜单，单项是长得一样的
 */
public class MenuItem {

    String name;//名称
    String desription;//描述
    boolean vegetarian;//是否是素食
    double price;//价格

    public MenuItem(String name, String desription, boolean vegetarian, double price) {
        this.name = name;
        this.desription = desription;
        this.vegetarian = vegetarian;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getDesription() {
        return desription;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public double getPrice() {
        return price;
    }
}
