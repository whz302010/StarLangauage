package com.example.acer.starlangauage.activity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.support.annotation.IdRes;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.acer.starlangauage.R;
import com.gyf.barlibrary.ImmersionBar;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

import fragment.HomeFragment;
import fragment.SlideFragment;

public class HomeActivity extends SlidingFragmentActivity {

    private SlidingMenu slidingMenu;
    private ImmersionBar mImmersionBar;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_home);
        mImmersionBar = ImmersionBar.with(this);
        mImmersionBar.init();   //所有子类都将继承这些相同的属性
        mImmersionBar.navigationBarColor(R.color.colorPrimary);
        slidingMenu = getSlidingMenu();
        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
        slidingMenu.setMenu(R.layout.sliding);
        initFragment();
        initView();


    }

    private void initView() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mImmersionBar.destroy();
    }

    private void initFragment() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        HomeFragment homeFragment = new HomeFragment();
        SlideFragment slideFragment = new SlideFragment();
        FragmentTransaction transaction = supportFragmentManager.beginTransaction();
        transaction.replace(R.id.slide_container,slideFragment);
        transaction.replace(R.id.fl_container,homeFragment);
        transaction.commit();
    }
}
