package com.wny.ccc;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by mathcoder23 on 10/12/16.
 */
public class ProgressView extends FrameLayout {
    private ImageView ivProgressBg;
    private ImageView ivProgress;
    private Context context;
    public ProgressView(Context context) {
        super(context);
        this.context = context;
        initView();
    }

    public ProgressView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initView();
    }

    public ProgressView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        initView();
    }
    public void setProgress(float progress)
    {
        ivProgress = (ImageView) findViewById(R.id.iv_progress);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        ViewGroup.LayoutParams progressLayoutParams = ivProgress.getLayoutParams();
        progressLayoutParams.height = (int)(layoutParams.height * progress);
        ivProgress.setLayoutParams(progressLayoutParams);
    }
    private void initView()
    {

    }
}
