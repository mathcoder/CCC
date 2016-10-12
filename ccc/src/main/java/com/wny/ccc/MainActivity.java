package com.wny.ccc;


import android.app.Activity;
import android.os.Bundle;
import android.preference.Preference;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {
    private ImageView ivChuizhi;
    private ImageView ivShitou;
    private NumberView numberView;
    private ProgressView progressView;
    private RotateAnimation anim1;
    private RotateAnimation anim2;
    int count = 0;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏
        setContentView(R.layout.activity_main);
        count = PrefersHelper.getIntValue("data","click_count",0);

        init();
        animInit();
        numberView.setValue(count);
    }
    private void init()
    {
        ivChuizhi = (ImageView) findViewById(R.id.iv_chuizhi);
        ivShitou = (ImageView) findViewById(R.id.iv_shitou);
        numberView = (NumberView) findViewById(R.id.click_count);
        progressView = (ProgressView) findViewById(R.id.progress_view);
        numberView.setValue(1);
        ivShitou.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch(motionEvent.getAction())
                {
                    case MotionEvent.ACTION_UP:
//                        Toast.makeText(MainActivity.this,"up",Toast.LENGTH_SHORT).show();
                        ivChuizhi.startAnimation(anim2);
                        break;
                    case MotionEvent.ACTION_DOWN:
//                        Toast.makeText(MainActivity.this,"down",Toast.LENGTH_SHORT).show();
                        ivChuizhi.startAnimation(anim1);
                        count++;
                        numberView.setValue(count);
                        progressView.setProgress(count/10000.0f);
                        PrefersHelper.setValue("data","click_count",count);
//                        tvClickCount.setText(count);
                        break;
                    case MotionEvent.ACTION_MOVE:
//                        Toast.makeText(MainActivity.this,"move",Toast.LENGTH_SHORT).show();

                        break;
                }
                return true;
            }
        });
    }
    float relative_x = 0.7f;
    float relative_y = 0.7f;
    float angle = -30.0f;
    private void animInit()
    {
        anim1 = new RotateAnimation(0, angle, Animation.RELATIVE_TO_SELF, relative_x, Animation.RELATIVE_TO_SELF, relative_y);
        anim1.setInterpolator(new LinearInterpolator());
//        anim1.setRepeatCount(Animation.INFINITE);
        anim1.setDuration(70);
        anim1.setFillAfter(true);
        anim2 = new RotateAnimation(angle, 0,Animation.RELATIVE_TO_SELF, relative_x, Animation.RELATIVE_TO_SELF, relative_y);
        anim2.setInterpolator(new LinearInterpolator());
        //anim2.setRepeatCount(Animation.INFINITE);
        anim2.setDuration(100);
        anim2.setFillAfter(true);

        anim1.setAnimationListener(new Animation.AnimationListener(){

            public void onAnimationEnd(Animation animation) {
                // TODO Auto-generated method stub
//                splash.startAnimation(anim2);
            }

            public void onAnimationRepeat(Animation animation) {
                // TODO Auto-generated method stub

            }

            public void onAnimationStart(Animation animation) {
                // TODO Auto-generated method stub
                SoundHelper.getInstance(MainActivity.this).chuida();

            }});
        anim2.setAnimationListener(new Animation.AnimationListener(){

            public void onAnimationEnd(Animation animation) {
                // TODO Auto-generated method stub
//                splash.startAnimation(anim1);
            }

            public void onAnimationRepeat(Animation animation) {
                // TODO Auto-generated method stub

            }

            public void onAnimationStart(Animation animation) {
                // TODO Auto-generated method stub

            }});

    }

}
