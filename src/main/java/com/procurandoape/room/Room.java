package com.procurandoape.room;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

import com.procurandoape.user.City;
import com.procurandoape.user.User;
import com.procurandoape.util.RoomConfig;

@Entity
@Table(name = "room")
public class Room implements Serializable {

	private static final long serialVersionUID = -771024054969107906L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;

	@Column(name = "short_description", nullable = false, length = 255)
	@NotBlank
	private String shortDescription;

	@Column(name = "description", nullable = false)
	@NotBlank
	@Lob
	private String description;

	@Column(name = "price")
	private BigDecimal price;

	@Enumerated(value = EnumType.STRING)
	@Column(name = "price_type", length = 15)
	private PriceType priceType;

	@OneToOne
	@JoinColumn(name = "city_id")
	private City city;

	@Column(name = "main_picture")
	private String mainPicture;

	@Override
	public String toString() {
		return "Room [id=" + id + ", user=" + user + ", shortDescription="
				+ shortDescription + ", description=" + description
				+ ", price=" + price + ", priceType=" + priceType + ", city="
				+ city + "]";
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

}
