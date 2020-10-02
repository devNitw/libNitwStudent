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

import com.example.librarynitwstudent.Adapters.Main.HomeRecyclerAdapter;
import com.example.librarynitwstudent.R;
import com.example.librarynitwstudent.models.Courses;
import com.example.librarynitwstudent.viewModels.HomeFragmentViewModel;

import java.util.List;

public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;
    private HomeFragmentViewModel homeFragmentViewModel;
    private HomeRecyclerAdapter recyclerAdapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_home,container,false);
        homeFragmentViewModel = ViewModelProviders.of(this).get(HomeFragmentViewModel.class);
        homeFragmentViewModel.init();
        recyclerView=view.findViewById(R.id.home_recycler_view);
        homeFragmentViewModel.getAllCourses().observe(this, new Observer<List<Courses>>() {
            @Override
            public void onChanged(List<Courses> courses) {
                recyclerAdapter.notifyDataSetChanged();
            }
        });
        initRecyclerView();
        return view;
    }
    private void initRecyclerView(){
        recyclerAdapter=new HomeRecyclerAdapter(getContext(),homeFragmentViewModel.getAllCourses().getValue());
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(recyclerAdapter);
    }
}
