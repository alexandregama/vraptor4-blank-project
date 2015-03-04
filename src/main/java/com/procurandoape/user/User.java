package com.procurandoape.user;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotBlank;
import org.joda.time.DateTime;
import org.joda.time.Years;

@Entity
@Table(name = "user")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "first_name", length = 50, nullable = false)
	@NotBlank
	private String firstName;

	@Column(name = "last_name", length = 50, nullable = false)
	@NotBlank
	private String lastName;

	@Temporal(TemporalType.DATE)
	@Column(name = "birthday")
	@NotBlank
	private Calendar birthday;

	@Column(name = "photo", length = 100)
	private String photo;

	@OneToOne
	@JoinColumn(name = "city_id")
	private City city;

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public City getCity() {
		return city;
	}

	public void setBirthday(Calendar birthday) {
		this.birthday = birthday;
	}

	public int getAge() {
		DateTime birthdayDate = new DateTime(this.birthday);
		DateTime today = new DateTime();
		Years yearsBetween = Years.yearsBetween(birthdayDate, today);

		return yearsBetween.getYears();
	}

	public String getPhoto() {
		return "https://s3.amazonaws.com/user-picture/" + photo;
	}

}
