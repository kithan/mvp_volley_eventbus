package com.xiaobai.savor.volley;

import org.json.JSONObject;

import com.android.volley.Response.Listener;

public abstract class ParseListener implements Listener<JSONObject> {
    JsonParser parser;


    public ParseListener(JsonParser parser) {
        this.parser = parser;
    }

    @Override
    public void onResponse(JSONObject arg0) {
        parser.parse(arg0);
        onParse(parser);

    }

    public abstract void onParse(JsonParser parser);
}
