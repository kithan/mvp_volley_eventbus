package com.xiaobai.savor.volley;

import org.json.JSONObject;

public abstract class JsonParser {

	public int errCode = 1;
	public String errMsg;

	/**
	 * 解析json
	 * 
	 * @param jsonObject
	 */
	public abstract void parse(JSONObject jsonObject);

}
