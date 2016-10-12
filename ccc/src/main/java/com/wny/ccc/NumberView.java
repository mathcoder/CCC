package com.wny.ccc;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mathcoder23 on 10/11/16.
 */
public class NumberView extends LinearLayout {
    private List<ImageView> numbers = new ArrayList<>();
    private int number;
    private Context context;

    private void initView()
    {
        this.setOrientation(HORIZONTAL);
        for(int i = 0;i <= 5;i++)
        {
            ImageView imageView = new ImageView(context);
            imageView.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            numbers.add(imageView);
            this.addView(imageView);
        }

    }
    public NumberView(Context context) {
        super(context);
        this.context = context;
        initView();
    }

    public NumberView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initView();
    }

    public NumberView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        initView();
    }

    public void setValue(int number)
    {
        this.number = number;
        String strNum = number+"";
        for (int i = 0; i < strNum.length();i++)
        {
            int n = Integer.parseInt(strNum.charAt(i)+"");
            ImageView imageView = numbers.get(i);
            switch(n)
            {
                case 0:
                    imageView.setImageResource(R.mipmap.number0);
                    break;
                case 1:
                    imageView.setImageResource(R.mipmap.number1);

                    break;
                case 2:
                    imageView.setImageResource(R.mipmap.number2);

                    break;
                case 3:
                    imageView.setImageResource(R.mipmap.number3);

                    break;
                case 4:
                    imageView.setImageResource(R.mipmap.number4);

                    break;
                case 5:
                    imageView.setImageResource(R.mipmap.number5);

                    break;
                case 6:
                    imageView.setImageResource(R.mipmap.number6);

                    break;
                case 7:
                    imageView.setImageResource(R.mipmap.number7);

                    break;
                case 8:
                    imageView.setImageResource(R.mipmap.number8);

                    break;
                case 9:
                    imageView.setImageResource(R.mipmap.number9);

                    break;
                default:

                    break;

            }
        }
    }
    private void updateView()
    {

    }


}
