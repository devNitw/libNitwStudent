package com.example.librarynitwstudent.Ui.MainActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.librarynitwstudent.Adapters.Main.HomeRecyclerAdapter;
import com.example.librarynitwstudent.Adapters.Main.OfflineRecyclerAdapter;
import com.example.librarynitwstudent.R;
import com.example.librarynitwstudent.models.Downloads;
import com.example.librarynitwstudent.repository.DownloadRepository;
import com.example.librarynitwstudent.viewModels.DownloadFragmentViewModel;

import java.util.List;

public class OfflineFragment extends Fragment {

    private RecyclerView recyclerView;
    private DownloadFragmentViewModel viewModel;
    private OfflineRecyclerAdapter recyclerAdapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_offline,container,false);

        viewModel= ViewModelProviders.of(this).get(DownloadFragmentViewModel.class);
        viewModel.init();
        recyclerView=view.findViewById(R.id.offline_recycler_view);
        viewModel.getAllDownloads().observe(this, new Observer<List<Downloads>>() {
            @Override
            public void onChanged(List<Downloads> downloads) {
                recyclerAdapter.notifyDataSetChanged();
            }
        });
        initRecyclerView();

        return view;
    }
    private void initRecyclerView(){
        recyclerAdapter=new OfflineRecyclerAdapter(getContext(),viewModel.getAllDownloads().getValue());
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(recyclerAdapter);
    }
}
