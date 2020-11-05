/**
 * 
 */
package c.s.sample.user;

/**
 * 
 * @author chineshine
 * @since 2020-9-15 
 */
public class User {
	
	{
		System.out.println("this is the user's structure");
	}
	
	static {
		System.out.println("this is the user's static structure");
	}
	
	public User() {
		System.out.println("this is user's construction");
	}

	
	public void getUsername() {
		System.out.println("this is username");
	}
}
