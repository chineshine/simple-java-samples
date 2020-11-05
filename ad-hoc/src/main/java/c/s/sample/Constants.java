/**
 * 
 */
package c.s.sample;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author chineshine
 * @since 2020-9-15
 */
public class Constants {

	private static Map<String, String> color = new HashMap<>();

	static {

		color.put("red", "red");
		color.put("blue", "blue");
	}

	public static Map<String, String> getColors() {
		return Collections.unmodifiableMap(color);
	}

	public static String getColor(String name) {
		return getColors().get(name);
	}

}
