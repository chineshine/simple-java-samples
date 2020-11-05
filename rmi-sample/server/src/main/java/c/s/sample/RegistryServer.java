package c.s.sample;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import c.s.sample.remoteobject.Greeting;
import c.s.sample.remoteobject.impl.User;

/**
 * @author chineshine
 * @since  2020年8月24日
 */
public class RegistryServer {

	private Registry registry;

	private final String remoteRmi = "rmi://localhost:" + Registry.REGISTRY_PORT;

	{
		try {
//			1. 创建一个注册中心
			registry = LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public void register() {
		try {
//			2.1
//			(1) 创建一个远程对象
			Greeting zhangsan = new User("张三");
//			(2) 在注册中心绑定一个远程对象 
			registry.rebind("zhangsan", zhangsan);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public void register2() {
		try {
//			2.2
//			(1) 创建一个远程对象
			Greeting lisi = new User("lisi");
//			2(2): 使用 naming 绑定一个远程对象
			Naming.bind(remoteRmi + "/lisi", lisi);
		} catch (RemoteException | MalformedURLException | AlreadyBoundException e) {
			e.printStackTrace();
		}
	}
}
