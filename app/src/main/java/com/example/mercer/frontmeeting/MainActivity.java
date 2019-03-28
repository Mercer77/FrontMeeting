package com.example.mercer.frontmeeting;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.mercer.frontmeeting.Fragment.DetailsFragment;
import com.example.mercer.frontmeeting.Fragment.MemberFragment;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;

import pl.droidsonroids.gif.GifImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ViewPager viewPager;
    private DetailsFragment detailsFragment;
    private MemberFragment memberFragment;
    private List<Fragment> fragments;
    private FragmentPagerAdapter fragmentPagerAdapter;
    private FragmentManager fragmentManager;
    private ImageView arr_left;
    private ImageView arr_right;
    private GifImageView gifImageView;
    private ImageView wangwu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        arr_left.setOnClickListener(this);
        arr_right.setOnClickListener(this);
        gifImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this,DetectFaceActivity.class);
                startActivityForResult(intent,0);
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode==0&&resultCode==1){

        }
        super.onActivityResult(requestCode, resultCode, data);
    }
    public void init(){
        viewPager = findViewById(R.id.viewPager);
        arr_left = findViewById(R.id.arr_left);
        arr_right = findViewById(R.id.arr_right);
        gifImageView = findViewById(R.id.faceScan);
        detailsFragment = new DetailsFragment();
        memberFragment = new MemberFragment();
        fragments = new ArrayList<>();
        fragments.add(detailsFragment);
        fragments.add(memberFragment);
        fragmentManager =getSupportFragmentManager();
        fragmentPagerAdapter = new FragmentPagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int i) {
                return fragments.get(i);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        };
        viewPager.setAdapter(fragmentPagerAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                chang(i);

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.arr_left:
              chang(0);
                break;
            case R.id.arr_right:
              chang(1);
                break;
        }
    }
    public void chang(int item){
        switch (item){
            case 0:
                viewPager.setCurrentItem(0);
                arr_left.setVisibility(View.GONE);
                arr_right.setVisibility(View.VISIBLE);
                break;
            case 1:
                viewPager.setCurrentItem(1);
                arr_right.setVisibility(View.GONE);
                arr_left.setVisibility(View.VISIBLE);
                break;
        }
    }
}
