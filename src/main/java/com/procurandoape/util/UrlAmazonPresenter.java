package com.procurandoape.util;

import javax.inject.Named;

@Named
public class UrlAmazonPresenter {

	private String s3AssetsUrl;

	public String getS3AssetsUrl() {
		this.s3AssetsUrl = RoomConfig.getProperty("s3.assets.url");
		return s3AssetsUrl;
	}

}
