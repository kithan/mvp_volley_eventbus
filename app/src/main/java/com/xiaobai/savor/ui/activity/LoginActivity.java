package com.xiaobai.savor.ui.activity;

import android.os.Bundle;

import com.xiaobai.savor.event.ErrorEvent;
import com.xiaobai.savor.event.LoginEvent;
import com.xiaobai.savor.presenter.LoginPresenter;
import com.xiaobai.savor.ui.BaseActivity;
import com.xiaobai.savor.utils.ToastUtils;
import com.xiaobai.savor.volley.json.LoginParser;

import de.greenrobot.event.EventBus;

/**
 * Created by hpb on 2015/8/20.
 */
public class LoginActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EventBus.getDefault().register(this);

        LoginPresenter loginPresenter = new LoginPresenter(new LoginParser());
        loginPresenter.login("", "");


    }


    public void onEvent(ErrorEvent event) {

    }

    public void onEvent(LoginEvent event) {
        ToastUtils.showMsg(this, "userId:" + event.userId);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
