package com.xiaobai.savor.volley;

import org.json.JSONException;
import org.json.JSONObject;

public abstract class JsonRequest {
	public abstract JSONObject make();

	public void addCommonKey(JSONObject jsonObject, String version) {
		try {
			jsonObject.put("client", 1);
			jsonObject.put("version", "1.0.0");
		} catch (JSONException e) {
			e.printStackTrace();
		}

	}

}
