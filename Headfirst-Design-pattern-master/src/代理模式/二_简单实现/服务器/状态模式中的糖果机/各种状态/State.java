package 代理模式.二_简单实现.服务器.状态模式中的糖果机.各种状态;

import java.io.Serializable;

/**
 * 只要这里扩展了Serializable接口，所有子类中的State就可以在网络上传送了。
 */
public interface State extends Serializable {
 
	public void insertQuarter();
	public void ejectQuarter();
	public void turnCrank();
	public void dispense();
}
