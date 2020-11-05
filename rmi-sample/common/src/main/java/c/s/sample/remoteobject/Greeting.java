package c.s.sample.remoteobject;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author chineshine
 * @since  2020年8月24日
 */
public interface Greeting extends Remote{

	String getName() throws RemoteException;;

	default String sayHello() throws RemoteException {
		return "hello, " + getName();
	}
}
