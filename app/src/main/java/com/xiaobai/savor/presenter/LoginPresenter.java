package com.xiaobai.savor.presenter;

import com.xiaobai.savor.event.ErrorEvent;
import com.xiaobai.savor.event.LoginEvent;
import com.xiaobai.savor.volley.JsonParser;
import com.xiaobai.savor.volley.VolleyRequest;
import com.xiaobai.savor.volley.json.LoginParser;
import com.xiaobai.savor.volley.json.LoginRequest;

import de.greenrobot.event.EventBus;

/**
 * Created by hpb on 2015/8/20.
 */
public class LoginPresenter extends BasePresenter {

    LoginParser parser;

    public LoginPresenter(LoginParser parser) {
        super(parser);
        this.parser = parser;
    }

    public void login(String name, String pwd) {
        VolleyRequest.post(new LoginRequest().make(), this, this);
    }

    @Override
    public Object getSucceedEvent() {
        LoginEvent event = new LoginEvent();
        event.userId = parser.userId;
        return event;
    }

    //    @Override
//    public void onSucceedHandler() {
//        EventBus.getDefault().post(new LoginEvent());
//
//    }
//
//    @Override
//    public void onFailedHandler(String errmsg) {
//        EventBus.getDefault().post(new ErrorEvent(errmsg));
//    }

}
