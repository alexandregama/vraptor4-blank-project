package com.procurandoape.user;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.joda.time.DateTime;
import org.joda.time.Years;

import com.procurandoape.converters.BooleanToStringConverterJPA;
import com.procurandoape.converters.GenderEnumToGenderJPAConverter;
import com.procurandoape.converters.PlaceTypeEnumToPlaceTypeJpaConverter;
import com.procurandoape.jpavalidators.ValidCity;
import com.procurandoape.place.PlaceToLive;
import com.procurandoape.room.PlaceToRental;
import com.procurandoape.util.RoomConfig;

@Entity
@Table(name = "user")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "first_name", length = 50, nullable = false)
	@NotBlank(message = "{user.firstname.empty}")
	private String firstName;

	@Column(name = "last_name", length = 50, nullable = false)
	@NotBlank(message = "{user.lastname.empty}")
	private String lastName;

	@Column(name = "email", length = 100, nullable = false)
	@Email(message = "{user.email.invalid}")
	@NotBlank(message = "{user.email.empty}")
	private String email;

	@Column(name = "phone", length = 15)
	private String phone;

	@Column(name = "phone_ddd", length = 3)
	private String phoneDDD;

	@Column(name = "password", length = 10, nullable = false)
	@NotBlank(message = "{user.password.empty}")
	@Size(min = 6, max = 10, message = "{user.password.length}")
	private String password;

	@Transient
	private String passwordConfirmation;

	@Temporal(TemporalType.DATE)
	@Column(name = "birthday")
	@NotNull(message = "{user.birthday.empty}")
	private Calendar birthday;

	@Column(name = "photo", length = 100)
	private String photo;

	@Convert(converter = GenderEnumToGenderJPAConverter.class)
	@Column(name = "gender", columnDefinition = "char(1)")
	@ValidGender
	private Gender gender;

	@OneToOne
	@JoinColumn(name = "city_id")
	@ValidCity
	private City city;

	@Convert(converter = BooleanToStringConverterJPA.class)
	@Column(name = "smoker", columnDefinition="char(1)")
	private Boolean smoker;

	@Convert(converter = BooleanToStringConverterJPA.class)
	@Column(name = "has_animal", columnDefinition="char(1)")
	private Boolean hasAnimal;

	@Convert(converter = BooleanToStringConverterJPA.class)
	@Column(name = "has_kids", columnDefinition="char(1)")
	private Boolean hasKids;

	@OneToOne
	private PlaceToLive placeToLive;

	@Column(name = "description", length = 250, nullable = false)
	@NotBlank
	private String description;

	@OneToMany(mappedBy = "user")
	private List<PlaceToRental> placesToRental;

	@Convert(converter = BooleanToStringConverterJPA.class)
	@Column(name = "accepts_perfil_suggestion", columnDefinition = "char(1)")
	private Boolean acceptsPerfilSuggestion;

	@Convert(converter = PlaceTypeEnumToPlaceTypeJpaConverter.class)
	@Column(name = "place_type", columnDefinition = "char(11)")
	@ValidPlaceType
	private PlaceType placeType;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar createdAt;

	@Column(name = "budget_estimate")
	private BigDecimal budgetEstimate;

	@Embedded
	private HousingPreferences housingPreferences;

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email + ", password=" + password
				+ ", passwordConfirmation=" + passwordConfirmation
				+ ", photo=" + photo + ", gender="
				+ gender + ", city=" + city + ", smoker=" + smoker
				+ ", acceptsPerfilSuggestion=" + acceptsPerfilSuggestion + ", placeType=" + placeType + "]";
	}

	public Long getId() {
		return this.id;
	}

	public String getFirstName() {
		return firstName;
	}

	public int getAge() {
		DateTime birthdayDate = new DateTime(this.getBirthday());
		DateTime today = new DateTime();
		Years yearsBetween = Years.yearsBetween(birthdayDate, today);

		return yearsBetween.getYears();
	}

	public String getPhoto() {
		return RoomConfig.getProperty("amazon.s3.picutures.path") + this.photo;
	}

	public String getFullName() {
		return this.getFirstName() + " " + this.getLastName();
	}

	public Boolean isSmoker() {
		return smoker;
	}

	public void setSmoker(Boolean smoker) {
		this.smoker = smoker;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Calendar getBirthday() {
		return birthday;
	}

	public void setBirthday(Calendar birthday) {
		this.birthday = birthday;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Boolean isAcceptsPerfilSuggestion() {
		return acceptsPerfilSuggestion;
	}

	public void setAcceptsPerfilSuggestion(Boolean acceptsPerfilSuggestion) {
		this.acceptsPerfilSuggestion = acceptsPerfilSuggestion;
	}

	public PlaceType getPlaceType() {
		return placeType;
	}

	public void setPlaceType(PlaceType placeType) {
		this.placeType = placeType;
	}

	public boolean hasValidPasswordConfirmation() {
		return this.password != null && this.passwordConfirmation != null
				&& this.password.equals(this.passwordConfirmation);
	}

	public boolean isMaleSelected() {
		return this.gender != null && this.gender.equals(Gender.MALE);
	}

	public boolean isFemaleSelected() {
		return this.gender != null && this.gender.equals(Gender.FEMALE);
	}

	public boolean isOtherSelected() {
		return this.gender != null && this.gender.equals(Gender.OTHER);
	}

	public boolean isHasPlaceSelected() {
		return this.placeType != null && this.placeType.equals(PlaceType.HAS_PLACE);
	}

	public boolean isNeedsPlaceSelected() {
		return this.placeType != null && this.placeType.equals(PlaceType.NEEDS_PLACE);
	}

	public String getFormattedBirthday() {
		if (this.birthday == null) {
			return null;
		}
		return new SimpleDateFormat("dd/MM/yyyy").format(this.birthday.getTime());
	}

	public boolean hasEmptyCredentialsSignin() {
		return this.email == null || this.email.isEmpty() || this.password == null || this.password.isEmpty();
	}

	public String getFirstNameWithGender() {
		if (this.gender.equals(Gender.MALE)) {
			return "o " + this.firstName;
		} else {
			return "a " + this.firstName;
		}
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhoneDDD() {
		return phoneDDD;
	}

	public void setPhoneDDD(String phoneDDD) {
		this.phoneDDD = phoneDDD;
	}

	public String getFormattedPhone() {
		return "(" + this.phoneDDD + ") " + this.phone;
	}

	public String getFormattedPhoneWithoutParenteses() {
		return this.phoneDDD + this.phone;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public PlaceToLive getPlaceToLive() {
		return placeToLive;
	}

	public String getSmokerDescription() {
		if (smoker != null && smoker) {
			return "Sou fumante";
		}
		return "Não fumo";
	}

	public String getAnimalDescription() {
		if (hasAnimal != null && hasAnimal) {
			return "Tenho animal";
		}
		return "Não tenho animal(is)";
	}

	public String getKidsDescription() {
		if (hasKids != null && hasKids) {
			return "Tenho crianças";
		}
		return "Não tenho criança(s)";
	}

	public Boolean getHasAnimal() {
		return hasAnimal;
	}

	public void setHasAnimal(Boolean hasAnimal) {
		this.hasAnimal = hasAnimal;
	}

	public Boolean getHasKids() {
		return hasKids;
	}

	public void setHasKids(Boolean hasKids) {
		this.hasKids = hasKids;
	}

	public BigDecimal getBudgetEstimate() {
		return budgetEstimate;
	}

	public void setBudgetEstimate(BigDecimal budgetEstimate) {
		this.budgetEstimate = budgetEstimate;
	}

	public String getBudgetEstimateFormatted() {
		if (this.budgetEstimate != null) {
			NumberFormat formatter = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
			return formatter.format(this.budgetEstimate).replaceAll("R\\$", "");
		}
		return "";
	}

	public HousingPreferences getHousingPreferences() {
		return housingPreferences;
	}

	public void setHousingPreferences(HousingPreferences housingPreferences) {
		this.housingPreferences = housingPreferences;
	}
}
