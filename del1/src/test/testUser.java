package test;

import modelPakke.User;
import junit.framework.TestCase;

public class testUser extends TestCase {
	
	public void testUser() throws Exception {
		User user;
		user = new User();
		assertTrue(user.getName().equals(""));
		user.setName("Gregor");
		assertTrue(user.getName().equals("Gregor"));
		System.out.println(user.getDateOfBirth());
		System.out.println(user.toString());
		assertTrue(user.toString().equals("Name: Gregor; Email: ; Date of birth: " + user.getDateOfBirth()));
	}

}
