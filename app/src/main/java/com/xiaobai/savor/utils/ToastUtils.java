package com.xiaobai.savor.utils;

import android.content.Context;
import android.widget.Toast;

public class ToastUtils {
	/**
	 * 弹出Toast
	 * 
	 * @param msg
	 */
	public static void showMsg(Context cont, String msg) {
		Toast.makeText(cont, msg, Toast.LENGTH_LONG).show();
	}

	public static void showMsg(Context cont, int msg) {
		Toast.makeText(cont, msg, Toast.LENGTH_LONG).show();
	}
}
