package com.procurandoape.login;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class Password {

	@NotBlank(message = "{user.password.empty}")
	@Size(min = 6, max = 10, message = "{user.password.length}")
	private String value;

	@NotBlank(message = "{user.password.confirmation.empty}")
	@Size(min = 6, max = 10, message = "{user.password.length}")
	private String confirmation;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getConfirmation() {
		return confirmation;
	}

	public void setConfirmation(String confirmation) {
		this.confirmation = confirmation;
	}

}
