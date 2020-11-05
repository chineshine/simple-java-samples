package c.s.sample;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Logger;

import org.apache.http.auth.MalformedChallengeException;
import org.apache.http.client.ClientProtocolException;
import org.junit.Test;

/**
 * @author chineshine
 * @since  2020年8月25日
 */
public class HttpClientTest {

	private static final Logger LOGGER = Logger.getLogger(HttpClientTest.class.getName());

	// host 不能加 scheme(http:https)
	private final String uri = "httpbin.org";

	@Test
	public void addressTest() throws UnknownHostException {
		InetAddress address = InetAddress.getByName(uri);
		LOGGER.info(address.getHostAddress());
		
	}
	
	@Test
	public void doGetTest() throws ClientProtocolException, IOException {
		HttpbinClient client = new HttpbinClient();
		client.doGetRequest();
	}
	
	@Test
	public void doAuthTest() throws MalformedChallengeException, IOException {
		HttpbinClient client = new HttpbinClient();
		client.doAuthRequest();
	}
}
