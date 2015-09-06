package com.xiaobai.savor.ui.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.xiaobai.savor.R;
import com.xiaobai.savor.ui.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 图片浮层(开眼)+绑定扫描动画
 */
public class ImgActivity extends BaseActivity {


    @Bind(R.id.pic)
    ImageView pic;
    @Bind(R.id.text)
    TextView text;
    @Bind(R.id.layout)
    RelativeLayout layout;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.title)
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_img);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        pic.setColorFilter(Color.argb(0x7f, 0x88, 0x88, 0x88));
        layout.setOnTouchListener(new OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    text.setVisibility(View.GONE);
                    pic.clearColorFilter();
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    text.setVisibility(View.VISIBLE);
                    pic.setColorFilter(Color.argb(0x7f, 0x88, 0x88, 0x88));
                }
                return false;
            }
        });
        layout.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "click",
                        Toast.LENGTH_SHORT).show();

            }
        });
        DisplayMetrics dm = getResources().getDisplayMetrics();
        TranslateAnimation anim = new TranslateAnimation(0, 0, 0,
                120 * dm.density);
        anim.setDuration(1000);
        anim.setRepeatCount(Animation.INFINITE);
        text.startAnimation(anim);
    }
}
