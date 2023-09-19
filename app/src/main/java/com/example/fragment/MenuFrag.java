package com.example.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;

import java.util.ArrayList;
import java.util.Arrays;

public class MenuFrag extends ListFragment {
    String[] menus = new String[]{"Flowers", "Animal", "Food"};
    ListView list;
    private AdapterView.OnItemClickListener onclick = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.menu_frag,container,false);
        list = view.findViewById(android.R.id.list);
        ArrayAdapter<String> listadapter = new ArrayAdapter<String>(view.getContext(),R.layout.menu_layout,(new ArrayList<String>(Arrays.asList(menus))));

        list.setAdapter(listadapter);
        list.setOnItemClickListener(onclick);

        return view;
    }


    public  interface IFragmentClickListener{
        public void onMenuItemClick(int position);
    }

    IFragmentClickListener itemfragment;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            itemfragment = (IFragmentClickListener) context;
        }
        catch (ClassCastException e){e.printStackTrace();}
    }
}
