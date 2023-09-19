package com.example.fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements MenuFrag.IFragmentClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onMenuItemClick(int position) {
        ContentFrag content = (ContentFrag) getSupportFragmentManager().findFragmentById(R.id.ContentFrag);
        if(content!=null)
            content.updateContent(position);
    }
}