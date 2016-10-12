package com.wny.ccc;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

/**
 * Created by mathcoder23 on 10/11/16.
 */
public class SurfaceActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏
        setContentView(new MainSurface(this));
    }
}
