package 代理模式.一_演示RMI远程服务.客户端;

import 代理模式.一_演示RMI远程服务.服务端.MyRemote;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * 客户端，想象这里已经是另一台电脑，另一个服务器了
 *
 * 整个过程，注意三点：
 * 1.启动远程服务之前先启动rmiregistry
 * 2.让变量和返回值类型成为 可序列化 类型
 * 3.给客户端提供stub类
 */
public class Client {
    public static void main(String args[]) {
        try {

            //
            //客户调用stub的方法,就像stub就是真正的服务对象一样
            //填写服务器ip,Client到RMI registry中寻找。
            //registry返回Styb对象()---(作为方法的返回值)然后RMI会自动对stub反序列化。
            /**
             *
             * 如何取得stub类？？
             * 1.你在客户端必须有stub类(由rmic为你产生),否则stub就无法被反序列化。
             * 2.动态类下载(dynamic class downloading)----如果你不想再客户端添加服务端的类，那么可以使用这个技术
             *
             * 利用动态类下载,序列化的对象(像stub)可以被“贴”上一个URL,告诉客户的RMI系统去寻找对象的类文件。
             * 在反序列化对象的过程中,如果RMI没有在本地发现类,就会利用HTTP的GET从该URL取得类文件。
             * 所以你需要一个简单的Web服务器来提供这些类文件,也需要更改客户端的安全参数。关于动态类下载,还有一些值得注意的主题,但是我们这里只是简述一下。
             * 特别对于stub对象,客户还有另外一种方法可以取得类,但是只有Java5才支持。我们会在本章末尾说明
             *
             */
            MyRemote remote = (MyRemote) Naming.lookup("rmi://127.0.0.1:8888/RemoteHello");
            System.out.println(remote.sayHello());
        } catch (NotBoundException e) {

        } catch (MalformedURLException e) {
            e.printStackTrace();
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}