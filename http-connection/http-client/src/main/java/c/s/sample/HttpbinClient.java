package c.s.sample;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.URI;
import java.util.logging.Logger;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AUTH;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.MalformedChallengeException;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.BasicAuthCache;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;

/**
 * @author chineshine
 * @since  2020年8月25日
 */
public class HttpbinClient {

	private static final Logger LOGGER = Logger.getLogger(HttpbinClient.class.getName());

	private final String uri = "httpbin.org";

	public void doGetRequest() throws ClientProtocolException, IOException {
		HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
		CloseableHttpClient closeableHttpClient = httpClientBuilder.build();

		InetAddress address = InetAddress.getByName(uri);
		HttpHost target = new HttpHost(address);

		HttpUriRequest request = new HttpGet(URI.create("/get"));

		HttpClientContext context = HttpClientContext.create();
		CloseableHttpResponse response = closeableHttpClient.execute(target, request, context);

		consoleResponse(response);
	}
	
	public void doAuthRequest() throws IOException, MalformedChallengeException {
		HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
		CloseableHttpClient closeableHttpClient = httpClientBuilder.build();

		InetAddress address = InetAddress.getByName(uri);
		HttpHost target = new HttpHost(address);

		HttpUriRequest request = new HttpGet(URI.create("/basic-auth/user/passwd"));
		
		
		BasicScheme basicScheme = new BasicScheme();
		BasicHeader header = new BasicHeader(AUTH.WWW_AUTH, "BASIC realm=default");
		basicScheme.processChallenge(header);
		BasicAuthCache authCache = new BasicAuthCache();
		authCache.put(target, basicScheme);
		
		HttpClientContext context = HttpClientContext.create();
		context.setAuthCache(authCache);
		AuthScope authscope = new AuthScope(target, null, null);
		UsernamePasswordCredentials credentials = new UsernamePasswordCredentials("user", "passwd");

		CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
		credentialsProvider.setCredentials(authscope, credentials);
		context.setCredentialsProvider(credentialsProvider);
		
		CloseableHttpResponse response = closeableHttpClient.execute(target, request, context);

		consoleResponse(response);
	}

	private void consoleResponse(HttpResponse response) throws IOException {
		
		StringBuilder header = new StringBuilder("{\n");
		Header responseHeader[] = response.getAllHeaders();
		for (Header h : responseHeader) {
			header.append(h.getName() + ":" + h.getValue() + "\n");
		}
		header.append("}");
		LOGGER.info(header.toString());
		HttpEntity entity = response.getEntity();
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		entity.writeTo(out);
		LOGGER.info(out.toString("utf-8"));
	}
}
