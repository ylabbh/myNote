package 适配器模式与外观模式.以JDK版本不同来演示适配器;

import java.util.Enumeration;
import java.util.Iterator;

/**
 * 老版本JAVA有elements()方法，返回Enumeration枚举。无需知道在集合内如何管理
 * 新版本JAVA使用Iterator接口，还提供了删除元素的能力。
 *
 * 如何适配？
 *
 */
public class EnumerationIterator implements Iterator {

    Enumeration enumration;

    public EnumerationIterator(Enumeration enumration) {
        this.enumration = enumration;
    }

    @Override
    public boolean hasNext() {
        return enumration.hasMoreElements();
    }

    @Override
    public Object next() {
        return enumration.nextElement();
    }

    /**
     * 注意，我们不能支持迭代器的remove()方法，因为旧版本接口并没有这样的实现，因此无论怎么适配，都没办法兼容“不存在”的东西。
     * 必须放弃。因此这里抛异常。
     */
    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }


}
