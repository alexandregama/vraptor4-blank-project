package com.procurandoape.user;

import static org.junit.Assert.*;

import java.util.GregorianCalendar;

import org.junit.Test;

public class UserTest {

	@Test
	public void shouldReturnAnUserAgeFromBirthday() throws Exception {
		User user = new User();
		user.setBirthday(new GregorianCalendar(1986, 06, 25));

		assertEquals(28, user.getAge());
	}

}
