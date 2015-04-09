package com.procurandoape.room;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.procurandoape.converters.BooleanToStringConverterJPA;
import com.procurandoape.converters.GenderEnumToGenderJPAConverter;
import com.procurandoape.user.Gender;
import com.procurandoape.user.GenderOrientation;
import com.procurandoape.user.Occupation;
import com.procurandoape.user.User;
import com.procurandoape.util.RoomConfig;

@Entity
@Table(name = "place_to_rental")
public class PlaceToRental implements Serializable {

	private static final long serialVersionUID = -771024054969107906L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne(optional = false)
	@JoinColumn(name = "user_id")
	private User user;

	@Column(name = "short_description", nullable = false, length = 255)
	@NotBlank(message = "{placetorental.shortdescription.empty}")
	private String shortDescription;

	@Column(name = "description", nullable = false)
	@NotBlank(message = "{placetorental.description.empty}")
	@Lob
	private String description;

	@Column(name = "price")
	private BigDecimal price;

	@Column(name = "price_expenses")
	private BigDecimal priceExpenses;

	@Column(name = "available_places_amount")
	private Integer availablePlacesAmount;

	@Column(name = "room_type_amount")
	private Integer roomTypeAmount;

	@Column(name = "minimum_stay")
	private Integer minimumStay;

	@Enumerated(value = EnumType.STRING)
	@Column(name = "price_type", length = 15)
	private PriceType priceType;

	@Column(name = "available_date")
	@Temporal(TemporalType.DATE)
	private Calendar availableDate;

	@Column(name = "zipcode", length = 9)
	private String zipcode;

	@Column(name = "address", length = 100)
	private String address;

	@Column(name = "complete_google_address", length = 250)
	private String completeGoogleAddress;

	@Column(name = "neighborhood", length = 100)
	private String neighborhood;

	@Column(name = "address_number", length = 10)
	private String addressNumber;

	@Column(name = "state", length = 50)
	private String state;

	@Column(name = "main_picture")
	private String mainPicture;

	@Enumerated(value = EnumType.STRING)
	@Column(name = "property_type", length = 20)
	@ValidPropertyType
	private PropertyType propertyType;

	@Column(name = "room_quantity")
	@Min(value = 1, message = "{placetorental.roomquantity.minimum}")
	private Integer roomQuantity;

	@Column(name = "bathroom_quantity")
	@Min(value = 1, message = "{placetorental.bathroomquantity.minimum}")
	private Integer bathroomQuantity;

	@Column(name = "advertise_situation")
	@NotNull(message = "{placetorental.adversitesituation.empty}")
	private AdvertiseSituation advertiseSituation;

	@Column(name = "accepts_smoker")
	@Convert(converter = BooleanToStringConverterJPA.class)
	private Boolean acceptsSmoker;

	@Column(name = "accepts_animal")
	@Convert(converter = BooleanToStringConverterJPA.class)
	private Boolean acceptsAnimal;

	@Column(name = "accepts_couple")
	@Convert(converter = BooleanToStringConverterJPA.class)
	private Boolean acceptsCouple;

	@Column(name = "accepts_children")
	@Convert(converter = BooleanToStringConverterJPA.class)
	private Boolean acceptsChildren;

	@Column(name = "minimum_age", length = 2, columnDefinition="char(2)")
	@Min(value = 10, message = "{placetorental.minimumage.minvalue}")
	private String minimumAge;

	@Column(name = "maximum_age", length = 2, columnDefinition="char(2)")
	@Max(value = 99, message = "{placetorental.maximumage.maxvalue}")
	private String maximumAge;

	@Column(name = "gender_preference")
	@NotNull(message = "{placetorental.gender.preference.notempty}")
	@Convert(converter = GenderEnumToGenderJPAConverter.class)
	private Gender genderPreference;

	@Column(name = "user_gender_orientation")
	@NotNull(message = "{placetorental.gender.preference.notempty}")
	@Convert(converter = GenderOrientationEnumToGenderOrientationJPAConverter.class)
	private GenderOrientation userGenderOrientation;

	@Column(name = "user_smokes")
	@Convert(converter = BooleanToStringConverterJPA.class)
	private Boolean userSmokes;

	@Column(name = "user_has_animal")
	@Convert(converter = BooleanToStringConverterJPA.class)
	private Boolean userHasAnimal;

	@Column(name = "user_looking_alone")
	@Convert(converter = BooleanToStringConverterJPA.class)
	private Boolean userLookingAlone;

	@Column(name = "user_has_kid")
	@Convert(converter = BooleanToStringConverterJPA.class)
	private Boolean userHasKid;

	@Column(name = "user_occupation")
	@NotNull(message = "{placetorental.user.occupation.notempty}")
	private Occupation userOccupation;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar createdAt = Calendar.getInstance();

	@Override
	public String toString() {
		return "PlaceToRental [id=" + id + ", shortDescription="
				+ shortDescription + ", description=" + description
				+ ", price=" + price + ", priceExpenses=" + priceExpenses
				+ ", availablePlacesAmount=" + availablePlacesAmount
				+ ", roomTypeAmount=" + roomTypeAmount + ", minimumStay="
				+ minimumStay + ", priceType=" + priceType
				+ ", zipcode=" + zipcode + ", address="
				+ address + ", completeGoogleAddress=" + completeGoogleAddress
				+ ", neighborhood=" + neighborhood + ", addressNumber="
				+ addressNumber + ", state=" + state + ", mainPicture="
				+ mainPicture + ", propertyType=" + propertyType
				+ ", roomQuantity=" + roomQuantity + ", bathroomQuantity="
				+ bathroomQuantity + ", advertiseSituation="
				+ advertiseSituation + ", acceptsSmoker=" + acceptsSmoker
				+ ", acceptsAnimal=" + acceptsAnimal + ", acceptsCouple="
				+ acceptsCouple + ", acceptsChildren=" + acceptsChildren
				+ ", minimumAge=" + minimumAge + ", maximumAge=" + maximumAge
				+ ", genderPreference=" + genderPreference
				+ ", userGenderOrientation=" + userGenderOrientation
				+ ", userSmokes=" + userSmokes + ", userHasAnimal="
				+ userHasAnimal + ", userLookingAlone=" + userLookingAlone
				+ ", userHasKid=" + userHasKid + ", userOccupation="
				+ userOccupation + "]";
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public String getFormattedPrice() {
		NumberFormat formatter = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
		return formatter.format(price);
	}

	public String getFormattedPriceWithoutSymbol() {
		NumberFormat formatter = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
		return formatter.format(price).replaceAll("R$", "");
	}

	public Long getId() {
		return id;
	}

	public User getUser() {
		return user;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public String getDescription() {
		return description;
	}

	public PriceType getPriceType() {
		return priceType;
	}

	public String getMainPicture() {
		return RoomConfig.getProperty("amazon.s3.picutures.path") + this.mainPicture;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPriceType(PriceType priceType) {
		this.priceType = priceType;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public void setMainPicture(String mainPicture) {
		this.mainPicture = mainPicture;
	}

	public BigDecimal getPriceExpenses() {
		return priceExpenses;
	}

	public void setPriceExpenses(BigDecimal priceExpenses) {
		this.priceExpenses = priceExpenses;
	}

	public Integer getAvailablePlacesAmount() {
		return availablePlacesAmount;
	}

	public void setAvailablePlacesAmount(Integer availablePlacesAmount) {
		this.availablePlacesAmount = availablePlacesAmount;
	}

	public Integer getRoomTypeAmount() {
		return roomTypeAmount;
	}

	public void setRoomTypeAmount(Integer roomTypeAmount) {
		this.roomTypeAmount = roomTypeAmount;
	}

	public Integer getMinimumStay() {
		return minimumStay;
	}

	public void setMinimumStay(Integer minimumStay) {
		this.minimumStay = minimumStay;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getAddressNumber() {
		return addressNumber;
	}

	public void setAddressNumber(String addressNumber) {
		this.addressNumber = addressNumber;
	}

	public PropertyType getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(PropertyType propertyType) {
		this.propertyType = propertyType;
	}

	public Integer getRoomQuantity() {
		return roomQuantity;
	}

	public void setRoomQuantity(Integer roomQuantity) {
		this.roomQuantity = roomQuantity;
	}

	public Integer getBathroomQuantity() {
		return bathroomQuantity;
	}

	public void setBathroomQuantity(int bathroomQuantity) {
		this.bathroomQuantity = bathroomQuantity;
	}

	public Boolean getAcceptsSmoker() {
		return acceptsSmoker;
	}

	public void setAcceptsSmoker(Boolean acceptsSmoker) {
		this.acceptsSmoker = acceptsSmoker;
	}

	public Boolean getAcceptsAnimal() {
		return acceptsAnimal;
	}

	public void setAcceptsAnimal(Boolean acceptsAnimal) {
		this.acceptsAnimal = acceptsAnimal;
	}

	public Boolean getAcceptsCouple() {
		return acceptsCouple;
	}

	public void setAcceptsCouple(Boolean acceptsCouple) {
		this.acceptsCouple = acceptsCouple;
	}

	public Boolean getAcceptsChildren() {
		return acceptsChildren;
	}

	public void setAcceptsChildren(Boolean acceptsChildren) {
		this.acceptsChildren = acceptsChildren;
	}

	public String getMinimumAge() {
		return minimumAge;
	}

	public void setMinimumAge(String minimumAge) {
		this.minimumAge = minimumAge;
	}

	public String getMaximumAge() {
		return maximumAge;
	}

	public void setMaximumAge(String maximumAge) {
		this.maximumAge = maximumAge;
	}

	public Gender getGenderPreference() {
		return genderPreference;
	}

	public void setGenderPreference(Gender genderPreference) {
		this.genderPreference = genderPreference;
	}

	public Boolean getUserSmokes() {
		return userSmokes;
	}

	public void setUserSmokes(Boolean userSmokes) {
		this.userSmokes = userSmokes;
	}

	public Boolean getUserHasAnimal() {
		return userHasAnimal;
	}

	public void setUserHasAnimal(Boolean userHasAnimal) {
		this.userHasAnimal = userHasAnimal;
	}

	public Boolean getUserLookingAlone() {
		return userLookingAlone;
	}

	public void setUserLookingAlone(Boolean userLookingAlone) {
		this.userLookingAlone = userLookingAlone;
	}

	public Boolean getUserHasKid() {
		return userHasKid;
	}

	public void setUserHasKid(Boolean userHasKid) {
		this.userHasKid = userHasKid;
	}

	public Occupation getUserOccupation() {
		return userOccupation;
	}

	public void setUserOccupation(Occupation userOccupation) {
		this.userOccupation = userOccupation;
	}

	public GenderOrientation getUserGenderOrientation() {
		return userGenderOrientation;
	}

	public void setUserGenderOrientation(GenderOrientation userGenderOrientation) {
		this.userGenderOrientation = userGenderOrientation;
	}

	public AdvertiseSituation getAdvertiseSituation() {
		return advertiseSituation;
	}

	public void setAdvertiseSituation(AdvertiseSituation advertiseSituation) {
		this.advertiseSituation = advertiseSituation;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Calendar getAvailableDate() {
		return availableDate;
	}

	public void setAvailableDate(Calendar availableDate) {
		this.availableDate = availableDate;
	}

	public String getAvailableDateFormatted() {
		return new SimpleDateFormat("dd/MM/yyyy").format(this.availableDate.getTime());
	}

	public String getCompleteGoogleAddress() {
		return completeGoogleAddress;
	}

	public void setCompleteGoogleAddress(String completeGoogleAddress) {
		this.completeGoogleAddress = completeGoogleAddress;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}
