package com.example.librarynitwstudent.Ui.MainActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.librarynitwstudent.Adapters.Main.Adapter;
import com.example.librarynitwstudent.R;
import com.example.librarynitwstudent.Ui.MainActivity.Daily.VerticalViewPager;
import com.example.librarynitwstudent.models.Model;

import java.util.ArrayList;
import java.util.List;

public class ReadingFragment extends Fragment {

    VerticalViewPager viewPager;
    Adapter adapter;
    List<Model> models;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup viewGroup=(ViewGroup) inflater.inflate((R.layout.fragment_reading),container,false);

        models=new ArrayList<>();
        models.add(new Model(R.drawable.authentication_custom_views,"Name: lorem ipsum\\nType: lorem ipsum\\nCategory: lorem ipsum\\nPeriod: lorem ipsum\\nCost: lorem ipsum"));
        models.add(new Model(R.drawable.authentication_custom_views,"Name: lorem ipsum\\nType: lorem ipsum\\nCategory: lorem ipsum\\nPeriod: lorem ipsum\\nCost: lorem ipsum"));
        models.add(new Model(R.drawable.authentication_custom_views,"Name: lorem ipsum\\nType: lorem ipsum\\nCategory: lorem ipsum\\nPeriod: lorem ipsum\\nCost: lorem ipsum"));
        models.add(new Model(R.drawable.authentication_custom_views,"Name: lorem ipsum\\nType: lorem ipsum\\nCategory: lorem ipsum\\nPeriod: lorem ipsum\\nCost: lorem ipsum"));
        models.add(new Model(R.drawable.authentication_custom_views,"Name: lorem ipsum\\nType: lorem ipsum\\nCategory: lorem ipsum\\nPeriod: lorem ipsum\\nCost: lorem ipsum"));

        adapter=new Adapter(models,getContext());
        viewPager=viewGroup.findViewById(R.id.verticalViewPager);
        viewPager.setAdapter(adapter);


        return viewGroup;
    }
}
