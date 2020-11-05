package c.s.sample;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author chineshine
 * @since  2020年8月24日
 */
public class ServerApplication {
	
	private static final Logger logger = Logger.getLogger(ServerApplication.class.getName());

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RegistryServer registryServer = new RegistryServer();
		registryServer.register();
		registryServer.register2();
		
		logger.log(Level.INFO, "the rmi server has started ! ");
	}

}
