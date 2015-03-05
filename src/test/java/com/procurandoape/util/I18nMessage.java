package com.procurandoape.util;

import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class I18nMessage {

	public static String getKey(String key) {
		ResourceBundle bundle = PropertyResourceBundle.getBundle("messages", new Locale("pt", "BR"));
		String originalValue = bundle.getString(key);
		try {
			byte[] valueToBytesISO = originalValue.getBytes("ISO-8859-1");
	        String valueToUTF8 = new String(valueToBytesISO, "UTF-8");
			return valueToUTF8;
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("Error while convert Latin1 to UTF-8 for key: " + key, e);
		}
	}

}
