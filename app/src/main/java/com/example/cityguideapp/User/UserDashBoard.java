package com.example.cityguideapp.User;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.cityguideapp.Common.LoginSignup.RetailerStartUpScreen;
import com.example.cityguideapp.HelperClasses.HomeAdpater.CategoryAdapter;
import com.example.cityguideapp.HelperClasses.HomeAdpater.CategoryHelperCalss;
import com.example.cityguideapp.HelperClasses.HomeAdpater.FeaturedAdapter;
import com.example.cityguideapp.HelperClasses.HomeAdpater.FeaturedHelperClass;
import com.example.cityguideapp.HelperClasses.HomeAdpater.MostViewedAdapter;
import com.example.cityguideapp.HelperClasses.HomeAdpater.MostViewedHelperClass;
import com.example.cityguideapp.R;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class UserDashBoard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //Variable
    static final float END_SCALE = 0.7f;
    LinearLayout contentView;

    RecyclerView featuredRecycler, mostViewedRecycler, categoryRecycler;
    RecyclerView.Adapter adapter;

    GradientDrawable gradient1, gradient2, gradient3, gradient4;
    //Drawer Layout
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    //Menu Icon Clickable
    ImageView menuIconClick;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*****************************For Action bar Disappearing*****************************/
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_user_dash_board);

        /**************************** RecyclerView Hooks *******************/
        featuredRecycler = findViewById(R.id.featured_recyler);
        mostViewedRecycler = findViewById(R.id.most_viewed_recyler);
        categoryRecycler = findViewById(R.id.categories_recycler);

        /**************************Menu Hooks *******************/
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        menuIconClick = findViewById(R.id.menu_bar);

        /**************************Drawer Animation  Hooks *******************/
        contentView = findViewById(R.id.content_animation);

        /************************ Navigation Drawer Menu Method calls *******************/
        navigationDrawer();

        /************************Recycler Views Method calls *******************/
        featuredRecycler();
        mostViewedRecycler();
        categoryRecycler();
    }

    /**************************Navigation Drawer method *******************/
    private void navigationDrawer() {
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        //home is always checked
        navigationView.setCheckedItem(R.id.nav_home);

        //when user click on menu Icon
        menuIconClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (drawerLayout.isDrawerVisible(GravityCompat.START))
                    drawerLayout.closeDrawer(GravityCompat.START);
                else drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        /**************************Animation Navigation Drawer method Calling *******************/
        animateNavigationDrawer();

    }

    /**************************Animation Navigation Drawer method *******************/
    private void animateNavigationDrawer() {

        //for primary color when drawer open and close
        drawerLayout.setScrimColor(getResources().getColor(R.color.colorPrimaryDark));

        drawerLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                //scale the View based on current slide effect
                final float diffScaledOffset = slideOffset * (1 - END_SCALE);
                final float offsetScale =  1 - diffScaledOffset;
                contentView.setScaleX(offsetScale);
                contentView.setScaleY(offsetScale);

                //Translate the view, Accounting for the scaled width
                final float xOffset = drawerView.getWidth() * slideOffset;
                final float xOffsetDiff = contentView.getWidth() * diffScaledOffset / 2;
                final float xTranslation = xOffset - xOffsetDiff;
                contentView.setTranslationX(xTranslation);
            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.nav_all_categories:
                startActivity(new Intent(getApplicationContext(),AllCategories.class));
                break;
        }

        return true;
    }


    /**************************RecyclerView Methods*******************/
    private void featuredRecycler() {

        featuredRecycler.setHasFixedSize(true);
        featuredRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        ArrayList<FeaturedHelperClass> featuredLocations = new ArrayList<>();
        featuredLocations.add(new FeaturedHelperClass(R.drawable.education_image, "Alexa University", ",mnd,mxvn,mxc mvxcmvmxc mdbmvbv"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.bank_image, "HDFC BANK", ",mnd,mxvn,mxc mvxcmvmxc mdbmvbv"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.hotel_image, "5Star HOTEL", ",mnd,mxvn,mxc mvxcmvmxc mdbmvbv"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.hotel_1_image, "SMS HOSPITAL", ",mnd,mxvn,mxc mvxcmvmxc mdbmvbv"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.shop_image, "24X7 Open Shop", ",mnd,mxvn,mxc mvxcmvmxc mdbmvbv"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.restaurant_image, "God Father", ",mnd,mxvn,mxc mvxcmvmxc mdbmvbv"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.recycler1, "MacDonald's", ",mnd,mxvn,mxc mvxcmvmxc mdbmvbv"));
        adapter = new FeaturedAdapter(featuredLocations);
        featuredRecycler.setAdapter(adapter);

    }

    private void mostViewedRecycler() {

        mostViewedRecycler.setHasFixedSize(true);
        mostViewedRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        ArrayList<MostViewedHelperClass> mostViewLocations = new ArrayList<>();
        mostViewLocations.add(new MostViewedHelperClass(R.drawable.hotel_image, "5Star HOTEL", "Hello Iam Deendayal Kumawat and iam Java Deveoper"));
        mostViewLocations.add(new MostViewedHelperClass(R.drawable.hotel_1_image, "5Star HOTEL", "Hello Iam Deendayal Kumawat and iam Java Deveoper"));
        mostViewLocations.add(new MostViewedHelperClass(R.drawable.bank_image, "HDFC BANK", "Hello Iam Deendayal Kumawat and iam Java Deveoper"));
        mostViewLocations.add(new MostViewedHelperClass(R.drawable.shop_image, "24X7 Open Shop", "Hello Iam Deendayal Kumawat and iam Java Deveoper"));
        mostViewLocations.add(new MostViewedHelperClass(R.drawable.education_image, "Alexa University", "Hello Iam Deendayal Kumawat and iam Java Deveoper"));
        mostViewLocations.add(new MostViewedHelperClass(R.drawable.restaurant_image, "MacDonald's", "Hello Iam Deendayal Kumawat and iam Java Deveoper"));

        adapter = new MostViewedAdapter(mostViewLocations);
        mostViewedRecycler.setAdapter(adapter);

        //GradientDrawable colors
        //GradientDrawable  gradient1 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT,new int[]{0xffeff400,0xffaff600});
    }

    private void categoryRecycler() {

        categoryRecycler.setHasFixedSize(true);

        categoryRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        ArrayList<CategoryHelperCalss> categoryLocations = new ArrayList<>();
        categoryLocations.add(new CategoryHelperCalss(R.drawable.bank_image, "SBI BANK"));
        categoryLocations.add(new CategoryHelperCalss(R.drawable.hotel_1_image, "GOPAL HOSPITAL"));
        categoryLocations.add(new CategoryHelperCalss(R.drawable.hotel_image, "OYO HOTEL"));
        categoryLocations.add(new CategoryHelperCalss(R.drawable.education_image, "Raj University"));
        categoryLocations.add(new CategoryHelperCalss(R.drawable.shop_image, "24X7 Shop"));
        categoryLocations.add(new CategoryHelperCalss(R.drawable.restaurant_image, "God Father"));
        adapter = new CategoryAdapter(categoryLocations);
        categoryRecycler.setAdapter(adapter);

    }

    /**************************Retailer Methods*******************/
    public void callRetailerScreens(View view){

        startActivity(new Intent(getApplicationContext(), RetailerStartUpScreen.class));
    }

    /************************Drawer close when back button pressed and application close*********/
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    /**************************Navigation Drawer MenuItem selecting *******************/
}
