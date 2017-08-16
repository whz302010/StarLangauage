package com.example.acer.starlangauage.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.acer.starlangauage.R;
import com.gyf.barlibrary.ImmersionBar;

public class BaseActivity extends AppCompatActivity {

    public ImmersionBar mImmersionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        mImmersionBar = ImmersionBar.with(this);
        mImmersionBar.init();   //所有子类都将继承这些相同的属性
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ImmersionBar.with(this).destroy();

    }
}
