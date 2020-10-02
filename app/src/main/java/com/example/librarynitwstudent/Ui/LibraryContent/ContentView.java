package com.example.librarynitwstudent.Ui.LibraryContent;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.librarynitwstudent.Adapters.Main.LibraryRecyclerAdapters.ContentRecyclerAdapter;
import com.example.librarynitwstudent.Adapters.Main.OfflineRecyclerAdapter;
import com.example.librarynitwstudent.R;
import com.example.librarynitwstudent.models.Downloads;
import com.example.librarynitwstudent.viewModels.DownloadFragmentViewModel;

import java.util.List;

public class ContentView extends AppCompatActivity {

    private RecyclerView booksRecyclerView, thesisRecyclerView, papersRecyclerView, magazineRecyclerView;
    private DownloadFragmentViewModel viewModel;
    private ContentRecyclerAdapter recyclerAdapter;
    private Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.course_activity);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        viewModel= ViewModelProviders.of(this).get(DownloadFragmentViewModel.class);
        viewModel.init();
        booksRecyclerView=findViewById(R.id.BooksRecyclerView);
        thesisRecyclerView=findViewById(R.id.ThesisRecyclerView);
        papersRecyclerView=findViewById(R.id.PapersRecyclerView);
        magazineRecyclerView=findViewById(R.id.MagazineRecyclerView);
        viewModel.getAllDownloads().observe(this, new Observer<List<Downloads>>() {
            @Override
            public void onChanged(List<Downloads> downloads) {
                recyclerAdapter.notifyDataSetChanged();
            }
        });
        initRecyclerView();
        super.onCreate(savedInstanceState);
    }
    private void initRecyclerView(){
        recyclerAdapter=new ContentRecyclerAdapter(getApplicationContext(),viewModel.getAllDownloads().getValue());
        RecyclerView.LayoutManager layoutManagerA= new LinearLayoutManager(getApplicationContext());
        booksRecyclerView.setLayoutManager(layoutManagerA);
        booksRecyclerView.setAdapter(recyclerAdapter);
        booksRecyclerView.setNestedScrollingEnabled(false);
        RecyclerView.LayoutManager layoutManagerB= new LinearLayoutManager(getApplicationContext());
        thesisRecyclerView.setLayoutManager(layoutManagerB);
        thesisRecyclerView.setAdapter(recyclerAdapter);
        thesisRecyclerView.setNestedScrollingEnabled(false);
        RecyclerView.LayoutManager layoutManagerC= new LinearLayoutManager(getApplicationContext());
        papersRecyclerView.setLayoutManager(layoutManagerC);
        papersRecyclerView.setAdapter(recyclerAdapter);
        papersRecyclerView.setNestedScrollingEnabled(false);
        RecyclerView.LayoutManager layoutManagerD= new LinearLayoutManager(getApplicationContext());
        magazineRecyclerView.setLayoutManager(layoutManagerD);
        magazineRecyclerView.setAdapter(recyclerAdapter);
        magazineRecyclerView.setNestedScrollingEnabled(false);
    }
}
