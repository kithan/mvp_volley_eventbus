package com.xiaobai.savor.volley;

import org.json.JSONObject;

import android.text.TextUtils;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response.ErrorListener;
import com.android.volley.RetryPolicy;
import com.android.volley.toolbox.JsonObjectRequest;
import com.xiaobai.savor.model.ApiConstants;

public class VolleyRequest {
	private static final int SOCKET_TIMEOUT = 10000;

	public static void post(JSONObject request, ParseListener listener,
			ErrorListener errListener) {
		RetryPolicy retryPolicy = new DefaultRetryPolicy(SOCKET_TIMEOUT,
				DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
				DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
		JsonObjectRequest jsonRequest = new JsonObjectRequest(ApiConstants.host,
				request, listener, errListener);
		if (request != null && !TextUtils.isEmpty(request.optString("method"))) {
			jsonRequest.setTag(request.optString("method"));
		}
		jsonRequest.setRetryPolicy(retryPolicy);
		VolleyQueue.getRequestQueue().add(jsonRequest);
	}



	public static void cancelRequest(final String tag) {
		VolleyQueue.getRequestQueue().cancelAll(
				new RequestQueue.RequestFilter() {
					@Override
					public boolean apply(Request<?> request) {
						boolean result = false;
						Object cancelTag = request.getTag();
						if (cancelTag instanceof String) {
							result = ((String) cancelTag).equals(tag);
						}
						return result;
					}
				});
	}
}
