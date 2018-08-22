package com.identityE2E.util;

import com.google.gson.Gson;

public class JSONUtil {

	private Gson gson;

	public JSONUtil() {
		this.gson = new Gson();
	}

	public String convertObjectToJson(Object obj) {
		return gson.toJson(obj);
	}

	public <T> T convertJsonToObject(String jsonStr, Class<T> clazz) {
		return gson.fromJson(jsonStr, clazz);
	}

}