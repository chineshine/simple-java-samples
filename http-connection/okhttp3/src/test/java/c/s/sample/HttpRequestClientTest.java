/**
 * 
 */
package c.s.sample;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author chineshine
 * @since 2020-8-27 
 */
public class HttpRequestClientTest {
	
	private HttpRequestClient client;
	
	@Before
	public void before() {
		client =  new HttpRequestClient();
	}
	
	
	@Test
	public void doGetTest() throws IOException {
		client.doGet();
	}

}
