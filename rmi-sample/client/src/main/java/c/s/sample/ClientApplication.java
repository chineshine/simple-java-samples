package c.s.sample;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author chineshine
 * @since  2020年8月24日
 */
public class ClientApplication {
	
	private static final Logger logger = Logger.getLogger(ClientApplication.class.getName()); 

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		logger.log(Level.INFO, "this is the rmi client ");
		RegistryClient registryClient = new RegistryClient();
		registryClient.get();
		registryClient.get2();
	}

}
