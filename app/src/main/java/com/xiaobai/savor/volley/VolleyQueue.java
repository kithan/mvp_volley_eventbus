package com.xiaobai.savor.volley;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class VolleyQueue {
	private static RequestQueue mRequestQueue;

	private VolleyQueue() {
	}

	public static void init(Context context) {
		mRequestQueue = Volley.newRequestQueue(context);
	}

	public static RequestQueue getRequestQueue() {
		if (mRequestQueue != null) {
			return mRequestQueue;
		} else {
			throw new IllegalStateException("RequestQueue未初始化");
		}
	}

}
