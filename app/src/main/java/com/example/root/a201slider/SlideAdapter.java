package com.example.root.a201slider;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by root on 1/12/18.
 */

public class SlideAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;

    //list of images
    int[] lstImages = {
        R.drawable.imga,
        R.drawable.imgb,
        R.drawable.imgc,
        R.drawable.imgd
    };

    //list of titles
    String[] lstTitles = {
        "Title 1",
        "Title 2",
        "Title 3",
        "Title4"
    };

    //list of descriptions
    String[] lstDescriptions = {
        "Description one of slide",
        "Description two of slide",
        "Description three of slide",
        "Description four of slide"
    };

    //list of colors
    int [] lstColors = {
            Color.rgb(55,55,55),
            Color.rgb(239,85,85),
            Color.rgb(110,49,89),
            Color.rgb(1,188,212)
    };

    public SlideAdapter(Context context){
        this.context = context;
    }

    @Override
    public int getCount() {
        return lstTitles.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {

        return (view == (LinearLayout)object);

    }

    @Override
    public Object instantiateItem(ViewGroup container, int i) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slider, container, false);
        LinearLayout linearLayout = view.findViewById(R.id.sliderLinearLayout);
        ImageView slideImage = view.findViewById(R.id.sliderImage);
        TextView slideTitle = view.findViewById(R.id.titleSlider);
        TextView slideDescription = view.findViewById(R.id.descriptionSlider);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            linearLayout.setBackgroundColor(lstColors[i]);
        }
        slideImage.setImageResource(lstImages[i]);
        slideTitle.setText(lstTitles[i]);
        slideDescription.setText(lstDescriptions[i]);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
       container.removeView((LinearLayout)object);
    }
}
