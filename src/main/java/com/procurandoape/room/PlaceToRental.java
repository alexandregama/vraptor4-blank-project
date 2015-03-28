package com.procurandoape.room;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.NumberFormat;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.procurandoape.converters.BooleanToStringConverterJPA;
import com.procurandoape.user.City;
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

	@OneToOne
	@JoinColumn(name = "city_id")
	private City city;

	@Column(name = "zipcode", length = 8)
	private String zipcode;

	@Column(name = "address", length = 100)
	private String address;

	@Column(name = "neighborhood", length = 100)
	private String neighborhood;

	@Column(name = "address_number", length = 10)
	private String addressNumber;

	@Column(name = "main_picture")
	private String mainPicture;

	@Enumerated(value = EnumType.STRING)
	@Column(name = "property_type", length = 20)
	@ValidPropertyType
	private PropertyType propertyType;

	@Column(name = "room_quantity")
	@Min(value = 1, message = "{placetorental.roomquantity.minimum}")
	private Integer roomQuantity = 0;

	@Column(name = "bathroom_quantity")
	@Min(value = 1, message = "{placetorental.bathroomquantity.minimum}")
	private Integer bathroomQuantity = 0;

	@Column(name = "advertise_situation")
	@NotNull(message = "{placetorental.adversitesituation.empty}")
	private AdvertiseSituation advertiseSituation;

	@Column(name = "accepts_smoker")
	@Convert(converter = BooleanToStringConverterJPA.class)
	private Boolean acceptsSmoker;

	@Override
	public String toString() {
		return "PlaceToRental [id=" + id + ", shortDescription="
				+ shortDescription + ", description=" + description
				+ ", price=" + price + ", priceExpenses=" + priceExpenses
				+ ", availablePlacesAmount=" + availablePlacesAmount
				+ ", roomTypeAmount=" + roomTypeAmount + ", minimumStay="
				+ minimumStay + ", priceType=" + priceType + ", city=" + city
				+ ", neighborhood=" + neighborhood + ", mainPicture="
				+ mainPicture + ", propertyType=" + propertyType + ", advertiseSituation="
				+ advertiseSituation + ", acceptsSmoker= " + acceptsSmoker + "]";
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

	public City getCity() {
		return city;
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

	public int getRoomQuantity() {
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
}
