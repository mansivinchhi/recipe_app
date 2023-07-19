package com.example.my_food_recipe_app_project_design;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

//import com.example.my_food_recipe_app_project_design.adapters.ViewPagerAdapter;
import com.example.my_food_recipe_app_project_design.ui.home.Home;


public class BlankFragment extends Fragment {
    ViewPager mSLideViewPager;
    LinearLayout mDotLayout;

    Button backbtn,nextbtn,skipbtn;
    TextView[] dots;
   // ViewPagerAdapter viewPagerAdapter;


    View blank;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        blank=inflater.inflate(R.layout.fragment_blank, container, false);
       // backbtn = blank.findViewById(R.id.backbtn);
        skipbtn = blank.findViewById(R.id.skipButton);
        nextbtn = blank.findViewById(R.id.nextbtn);
        skipbtn = blank.findViewById(R.id.skipButton);

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (getitem(0) > 0){

                    mSLideViewPager.setCurrentItem(getitem(-1),true);

                }

            }
        });

        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (getitem(0) < 3)
                    mSLideViewPager.setCurrentItem(getitem(1),true);
                else {
                    Intent i = new Intent(getActivity(), Home.class);
                    startActivity(i);
                }

            }
        });
        skipbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent i = new Intent(getActivity(),MainActivity.class);
                startActivity(i);

            }
        });

        mSLideViewPager = (ViewPager) blank.findViewById(R.id.slideViewPager);
        mDotLayout = (LinearLayout) blank.findViewById(R.id.indicator_layout);

        //viewPagerAdapter = new ViewPagerAdapter(getContext()) ;

      //  mSLideViewPager.setAdapter(viewPagerAdapter);

        setUpindicator(0);
        mSLideViewPager.addOnPageChangeListener(viewListener);




        return blank;
    }
    public void setUpindicator(int position){

        dots = new TextView[4];
        mDotLayout.removeAllViews();

        for (int i = 0 ; i < dots.length ; i++){

            dots[i] = new TextView(getContext());
            dots[i].setText(Html.fromHtml("&#8226"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(getResources().getColor(R.color.inactive,getActivity().getApplicationContext().getTheme()));
            mDotLayout.addView(dots[i]);

        }

        dots[position].setTextColor(getResources().getColor(R.color.active,getActivity().getApplicationContext().getTheme()));

    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

            setUpindicator(position);

            if (position > 0){

                backbtn.setVisibility(View.VISIBLE);

            }else {

                backbtn.setVisibility(View.INVISIBLE);

            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    private int getitem(int i){

        return mSLideViewPager.getCurrentItem() + i;
    }
}
