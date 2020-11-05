package c.s.sample.remoteobject.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import c.s.sample.remoteobject.Greeting;

/**
 * @author chineshine
 * @since  2020年8月24日
 */
public class User extends UnicastRemoteObject implements Greeting {

	private static final long serialVersionUID = 242133669018945298L;

	public User() throws RemoteException {
		super();
	}

	public User(String name) throws RemoteException {
		this.name = name;
	}

	private String name;

	@Override
	public String getName() {
		return name;
	}

}
