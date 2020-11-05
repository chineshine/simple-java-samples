package c.s.sample;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

import c.s.sample.remoteobject.Greeting;

/**
 * @author chineshine
 * @since  2020年8月24日
 */
public class RegistryClient {

	private static final Logger logger = Logger.getLogger(RegistryClient.class.getName());

	private final String remoteRmi = "rmi://localhost:" + Registry.REGISTRY_PORT;

	public void get() {
		try {
//			1. 获取注册中心
			Registry registry = LocateRegistry.getRegistry();
//			2. 寻找绑定的远程对象
			Greeting greeting = (Greeting) registry.lookup("zhangsan");
//			3. 调用远程对象的方法
			String response = greeting.sayHello();
			logger.log(Level.INFO, response);
		} catch (RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
	}

	public void get2() {
		try {
			Greeting greeting = (Greeting) Naming.lookup(remoteRmi + "/lisi");
			String response = greeting.sayHello();
			logger.log(Level.INFO, response);
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
	}
}
