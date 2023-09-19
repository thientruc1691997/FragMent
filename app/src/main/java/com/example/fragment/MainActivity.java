package com.example.fragment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements MenuFrag.IFragmentClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.MenuFrag, MenuFrag.class, null)
                    .add(R.id.ContentFrag, ContentFrag.class, null)
                    .commit();
        }
    }

    @Override
    public void onMenuItemClick(int position) {
        ContentFrag content = (ContentFrag) getSupportFragmentManager().findFragmentById(R.id.ContentFrag);
        if (content != null)
            content.updateContent(position);
    }
}