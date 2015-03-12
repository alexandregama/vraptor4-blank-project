package com.procurandoape.user;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;

public class UserTest {

	@Test
	public void shouldReturnAnUserAgeFromBirthday() throws Exception {
		User user = new User();
		user.setBirthday(new GregorianCalendar(1986, 06, 25));

		assertEquals(28, user.getAge());
	}

	@Test
	public void shouldReturnAFullName() throws Exception {
		User user = new User();
		user.setFirstName("Alexandre");
		user.setLastName("Gama");

		assertEquals("Alexandre Gama", user.getFullName());
	}

	@Test
	public void shouldConfirmAPassword() throws Exception {
		User user = new User();
		user.setPassword("123456");
		user.setPasswordConfirmation("123456");

		assertTrue(user.hasValidPasswordConfirmation());
	}

	@Test
	public void shouldNotConfirmAPassword() throws Exception {
		User user = new User();
		user.setPassword("654321");
		user.setPasswordConfirmation("123456");

		assertFalse(user.hasValidPasswordConfirmation());
	}

	@Test
	public void shouldCheckIfMaleGenderIsSelected() throws Exception {
		User user = new User();
		user.setGender(Gender.MALE);

		assertTrue(user.isMaleSelected());
	}

	@Test
	public void shouldCheckIfFemaleGenderIsSelected() throws Exception {
		User user = new User();
		user.setGender(Gender.FEMALE);

		assertTrue(user.isFemaleSelected());
	}

	@Test
	public void shouldCheckIfOtherGenderIsSelected() throws Exception {
		User user = new User();
		user.setGender(Gender.OTHER);

		assertTrue(user.isOtherSelected());
	}

	@Test
	public void shouldCheckIfUserSelectedThatHeHasAPlace() throws Exception {
		User user = new User();
		user.setPlaceType(PlaceType.HAS_PLACE);

		assertTrue(user.isHasPlaceSelected());
	}

	@Test
	public void shouldCheckIfUserSelectedThatHeNeedsAPlace() throws Exception {
		User user = new User();
		user.setPlaceType(PlaceType.NEEDS_PLACE);

		assertTrue(user.isNeedsPlaceSelected());
	}

	@Test
	public void shouldFormatABirthdayUser() throws Exception {
		Calendar birthday = new GregorianCalendar(1986, 05, 25);
		User user = new User();
		user.setBirthday(birthday);

		assertEquals("25/06/1986", user.getFormattedBirthday());
	}
}
