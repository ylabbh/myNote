package 代理模式.四_动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class OwnerInvocationHandler implements InvocationHandler {
	PersonBean person;
 
	public OwnerInvocationHandler(PersonBean person) {
		this.person = person;
	}
 
	public Object invoke(Object proxy, Method method, Object[] args) throws IllegalAccessException {
		try {
			if (method.getName().startsWith("get")) {
				return method.invoke(person, args);//这里代理person，如果外部调用的是person的“get”类方法，代理允许你调用person
   			} else if (method.getName().equals("setHotOrNotRating")) {//如果是setHotOrNotRating，不允许你调用，抛异常
				throw new IllegalAccessException();
			} else if (method.getName().startsWith("set")) {
				return method.invoke(person, args);//允许调用
			}
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
		return null;
	}
}