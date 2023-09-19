package com.example.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class ContentFrag extends Fragment {
    GridView gridview;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_frag,container,false);
        gridview = view.findViewById(R.id.gridview);
        Adapter adapter = new Adapter(requireContext(), generatePhotoData());
        gridview.setAdapter(adapter);
        return view;
    }
    public void updateContent(int position){

    }

    public static ArrayList<String> generatePhotoData() {
        ArrayList<String> photos = new ArrayList<>();
        photos.add("https://images.unsplash.com/photo-1528821128474-27f963b062bf");
        photos.add("https://images.unsplash.com/photo-1528821128474-27f963b062bf");
        photos.add("https://images.unsplash.com/photo-1528821128474-27f963b062bf");
        photos.add("https://images.unsplash.com/photo-1528821128474-27f963b062bf");

        return photos;
    }
}
