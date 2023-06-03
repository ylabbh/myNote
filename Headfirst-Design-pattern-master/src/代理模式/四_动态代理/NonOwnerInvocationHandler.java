package 代理模式.四_动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 为什么命名为   方法名+InvocationHandler？这个不是代理类吗？
 * NO，代理对象是运行时创建，这只是 帮助类。负责将person转发给InvocationHandler
 *
 * Proxy本身是在运行时动态创建。
 * isProxyClass()可以知道这是否是个动态代理。
 *
 */
public class NonOwnerInvocationHandler implements InvocationHandler {
	PersonBean person;
 
	public NonOwnerInvocationHandler(PersonBean person) {
		this.person = person;
	}
 
	public Object invoke(Object proxy, Method method, Object[] args)
			throws IllegalAccessException {
  
		try {
			if (method.getName().startsWith("get")) {
				return method.invoke(person, args);
   			} else if (method.getName().equals("setHotOrNotRating")) {
				return method.invoke(person, args);
			} else if (method.getName().startsWith("set")) {
				throw new IllegalAccessException();
			} 
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } 
		return null;
	}
}