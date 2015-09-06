package com.xiaobai.savor.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.xiaobai.savor.R;
import com.xiaobai.savor.widget.AnimateFirstDisplayListener;

/**
 * Created by hpb on 2015/8/20.
 */
public class BaseActivity extends AppCompatActivity {
    protected ImageLoadingListener animateFirstListener = new
            AnimateFirstDisplayListener();
    protected DisplayImageOptions option;
    protected ImageLoader imageLoader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        imageLoader = ImageLoader.getInstance();
        option = new DisplayImageOptions.Builder().cacheInMemory(true).cacheOnDisk(true)
                .showImageForEmptyUri(R.mipmap.ic_launcher)
                .showImageOnFail(R.mipmap.ic_launcher)
                .showImageOnLoading(R.mipmap.ic_launcher)
                .considerExifParams(true).build();

    }

    protected void displayImage(String url, ImageView img) {
        imageLoader.displayImage(url, img, option, animateFirstListener);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
