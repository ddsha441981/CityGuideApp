package com.example.cityguideapp.HelperClasses;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

import com.example.cityguideapp.R;

public class SliderAdpater extends PagerAdapter {

    Context context;

    LayoutInflater layoutInflater;

    /****************************Context means which activity we want to use********************/
    public SliderAdpater(Context context) {
        this.context = context;
    }

    int images[] = {
            R.drawable.search_place,
            R.drawable.make_a_call,
            R.drawable.add_missing_place,
            R.drawable.sit_back_and_relax
    };

    int headings[] = {
            R.string.first_slide_tittle,
            R.string.second_slide_tittle,
            R.string.third_slide_tittle,
            R.string.fourth_slide_tittle
    };

    int descriptions[] = {
            R.string.first_slide_desc,
            R.string.second_slide_desc,
            R.string.third_slide_desc,
            R.string.fourth_slide_desc
    };


    /*******************************Means how many slides we use****************************/
    @Override
    public int getCount() {
        return headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (ConstraintLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);

        //Hooks
        ImageView imageView = view.findViewById(R.id.slider_image);
        TextView heading = view.findViewById(R.id.slider_heading);
        TextView desc = view.findViewById(R.id.slider_desc);

        /*****************************Apply Hooks Here*****************************/
        imageView.setImageResource(images[position]);
        heading.setText(headings[position]);
        desc.setText(descriptions[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((ConstraintLayout) object);
    }
}
