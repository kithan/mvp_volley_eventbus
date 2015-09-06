package com.xiaobai.savor.presenter;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.xiaobai.savor.event.ErrorEvent;
import com.xiaobai.savor.volley.JsonParser;
import com.xiaobai.savor.volley.ParseListener;

import de.greenrobot.event.EventBus;

/**
 * Created by hpb on 2015/8/20.
 */
public abstract class BasePresenter extends ParseListener implements Response.ErrorListener {


    public BasePresenter(JsonParser parser) {
        super(parser);
    }

    @Override
    public void onErrorResponse(VolleyError error) {
//        onFailedHandler(error.getMessage());
        EventBus.getDefault().post(new ErrorEvent(error.getMessage()));

    }

    @Override
    public void onParse(JsonParser parser) {
        if (parser.errCode == 0) {
            EventBus.getDefault().post(getSucceedEvent());
        } else {
            EventBus.getDefault().post(new ErrorEvent(parser.errMsg));
        }

    }


    public abstract Object getSucceedEvent();
//    public abstract void onSucceedHandler();

//    public abstract void onFailedHandler(String errmsg);
}
