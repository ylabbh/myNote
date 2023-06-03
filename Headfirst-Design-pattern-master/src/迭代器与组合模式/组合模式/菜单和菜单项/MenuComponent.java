package 迭代器与组合模式.组合模式.菜单和菜单项;


import java.util.Iterator;

/**
 * Menu和MenuItem都实现了这个接口，注意，我们实际关心的并不是菜单，而是菜单项Item，这才是组合模式中最核心的工作原子。
 * Menu只是辅助功能，负责管理一堆Item的族群。
 * Menu是枝，Item是叶。
 */
public abstract class MenuComponent {

    public void add(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }

    public void remove(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }

    public MenuComponent getChild(int i) {
        throw new UnsupportedOperationException();
    }

    public String getName() {
        throw new UnsupportedOperationException();
    }

    public String getDescription() {
        throw new UnsupportedOperationException();
    }

    public double getPrice() {
        throw new UnsupportedOperationException();
    }

    public boolean isVegetarian() {
        throw new UnsupportedOperationException();
    }

    public void print() {
        throw new UnsupportedOperationException();
    }

    public Iterator createIterator() {
        throw new UnsupportedOperationException();
    }

}