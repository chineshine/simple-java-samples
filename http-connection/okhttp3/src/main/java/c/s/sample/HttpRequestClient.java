/**
 * 
 */
package c.s.sample;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 
 * @author chineshine
 * @since 2020-8-27
 */
public class HttpRequestClient {

	private final String url = "http://httpbin.org";

	public void doGet() throws IOException {
		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder().url(url + "/get").get().build();
		Call call = client.newCall(request);
		Response response = call.execute();

		System.out.println(response.toString());
	}
}
