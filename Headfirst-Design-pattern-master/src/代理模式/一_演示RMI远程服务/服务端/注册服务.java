package 代理模式.一_演示RMI远程服务.服务端;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class 注册服务 {
    /**
     * 三、产生Stub和Skeleton
     * rmic是JDK内的一个工具,用来为一个服务类产生tub和skeleton 。
     * 命名习惯是在远程实现的名字后面加上_Stub或_Skel。
     * rmic有一些选项可以调整,包括不要产生skeleton 、查看源代码,甚至使用IOP作为协议。
     * 我们这里使用rmic的方式是常用的方式,将类产生在当前目录下(就是你cd到的地方)。
     * 请注意,rmic必须看到你的实现类,所以你可能会从你的远程实现所在的目录执行rmic(为了简单起见,我们这里不用package 。但是在真实世界中,你必须注意package
     *
     * 四、执行remiregistry----开启一个终端，启动rmi registry
     * 先确定启动目录必须可以访问你的类。最简单的做法是从你的“classes 目录启动
     * 五、启动服务----开启另一个终端，启动服务
     *
     * 从哪里启动?可能是从你的远程实现类中的main 方法,也可能是从一个独立的启动类。在这个简单的例子中,我们是从实现类中的main方法启动的,先实例化一个服务对象,然后到RMI 中注册
     */
    public static void main(String[] args) {
        try {
            MyRemote service = new MyRemoteImpl();
            LocateRegistry.createRegistry(8888);

            //绑定到rmi registry。客户讲使用你所注册的名称在RMI registry中寻找它
            Naming.bind("rmi://localhost:8888/RemoteHello", service);
            System.out.println(">>>>>INFO:远程IHello对象绑定成功！");
        } catch (RemoteException e) {
            System.out.println("创建远程对象发生异常！");
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            System.out.println("发生重复绑定对象异常！");
            e.printStackTrace();
        } catch (MalformedURLException e) {
            System.out.println("发生URL畸形异常！");
            e.printStackTrace();
        }
    }
}
