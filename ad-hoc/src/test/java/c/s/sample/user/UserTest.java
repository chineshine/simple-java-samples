/**
 * 
 */
package c.s.sample.user;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

/**
 * 
 * @author chineshine
 * @since 2020-9-15 
 */
public class UserTest {

	
	@Test
	public void test1() {
		User u1 = new User();
		u1.getUsername();
		u1.getUsername();
		
		System.out.println("----------------------------------------------------");
		User u2 = new User();
		u2.getUsername();
	}


	@Test
	public void test2() {
		
		List<User2> users = Collections.nCopies(4, new User2("zhangsan"));
		
		String names = users.stream().map(User2::getName).collect(Collectors.joining(","));
		
		System.out.println(names);
	}

}


