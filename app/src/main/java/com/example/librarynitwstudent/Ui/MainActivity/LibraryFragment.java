package com.example.librarynitwstudent.Ui.MainActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.librarynitwstudent.Adapters.Main.HomeRecyclerAdapter;
import com.example.librarynitwstudent.Adapters.Main.StreamViewPagerAdapter;
import com.example.librarynitwstudent.R;
import com.example.librarynitwstudent.models.Courses;
import com.example.librarynitwstudent.models.Streams;
import com.example.librarynitwstudent.viewModels.HomeFragmentViewModel;

import java.util.ArrayList;
import java.util.List;

public class LibraryFragment extends Fragment {

    ViewPager viewPager;
    StreamViewPagerAdapter adapter;
    List<Streams> data;
    private RecyclerView recyclerView;
    private HomeFragmentViewModel frequentlyUsedViewModel;
    private HomeRecyclerAdapter recyclerAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_library,container,false);
        data=new ArrayList<>();
        data.add(new Streams("CSE","Computer Science and Engineering"));
        data.add(new Streams("ECE","Electronics and communication Engineering"));
        data.add(new Streams("EEE","Electrical Engineering"));
        data.add(new Streams("ME","Mechanical Engineering"));
        data.add(new Streams("CE","Civil Engineering"));

        adapter=new StreamViewPagerAdapter(data,getContext());
        viewPager=view.findViewById(R.id.StreamPager);
        viewPager.setAdapter(adapter);

        viewPager.setPadding(130,0,130,0);

        frequentlyUsedViewModel = ViewModelProviders.of(this).get(HomeFragmentViewModel.class);
        frequentlyUsedViewModel.init();
        recyclerView=view.findViewById(R.id.frequently_used_recycler_view);
        frequentlyUsedViewModel.getAllCourses().observe(this, new Observer<List<Courses>>() {
            @Override
            public void onChanged(List<Courses> courses) {
                recyclerAdapter.notifyDataSetChanged();
            }
        });
        initRecyclerView();




        return view;
    }
    private void initRecyclerView(){
        recyclerAdapter=new HomeRecyclerAdapter(getContext(),frequentlyUsedViewModel.getAllCourses().getValue());
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(recyclerAdapter);
    }
}
