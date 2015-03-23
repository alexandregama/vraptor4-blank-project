package com.procurandoape.place;

import com.google.common.base.Optional;

public interface Zipcodes  {

	Optional<Zipcode> findByZipcodeNumber(String zipcodeValue);

}
