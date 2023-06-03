package 代理模式.三_另一种演示_虚拟代理;


/**
 * 虚拟代理：应对开销大的对象。代理将请求直接委托给对象。
 * 说人话：例如，当我们加载一个很大的对象，可能需要很长的时间，那么可以先产生一个虚拟代理做一些前置动作、准备工作等。等对象创建好了再将请求委派给对象
 *
 * 虚拟代理模式(Virtual PRoxy)会推迟真正所需对象实例化时间. 在需要真正的对象工作之前, 如果代理对象能够处理, 那么暂时不需要真正对象来出手.
 * 优点: 这种方法的优点是,在应用程序启动时,由于不需要创建和装载所有的对象,因此加速了应用程序的启动。
 * 缺点: 因为不能保证特定的应用程序对象被创建,在访问这个对象的任何地方,都需要检测确认它不是空(null)。性能的降低上不仅仅是多了一句代码这么简单, ` if ` 这种跳转类语句的很有可能会阻塞CPU的指令流水, 虽然有分值预测技术, 但是分支预测也是有命中率的....
 *
 *
 *
 */
public class Test {
}
