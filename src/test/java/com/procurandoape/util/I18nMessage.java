package com.procurandoape.util;

import java.util.Locale;
import java.util.ResourceBundle;

public class I18nMessage {

	public static String getKey(String key) {
		ResourceBundle bundle = ResourceBundle.getBundle("messages", new Locale("pt", "BR"));
		return bundle.getString(key);
	}

}
