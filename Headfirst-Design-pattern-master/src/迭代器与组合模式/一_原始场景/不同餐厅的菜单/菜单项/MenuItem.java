package 迭代器与组合模式.一_原始场景.不同餐厅的菜单.菜单项;

/**
 * 菜单项类，不管是什么形式的菜单，单项是长得一样的
 */
public class MenuItem {

    String name;//名称
    String desription;//描述
    boolean vegetarian;//是否是素食
    double price;//价格

    /**
     * 构造函数
     * @param name
     * @param desription
     * @param vegetarian
     * @param price
     */
    public MenuItem(String name, String desription, boolean vegetarian, double price) {
        this.name = name;
        this.desription = desription;
        this.vegetarian = vegetarian;
        this.price = price;
    }


    /**
     * get方法
     * @return
     */
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
