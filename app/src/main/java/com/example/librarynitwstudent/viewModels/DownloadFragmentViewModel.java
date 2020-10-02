package com.example.librarynitwstudent.viewModels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.librarynitwstudent.models.Downloads;
import com.example.librarynitwstudent.repository.DownloadRepository;

import java.util.List;

public class DownloadFragmentViewModel extends ViewModel {
    private MutableLiveData<List<Downloads>> allDownloads;
    private DownloadRepository repository;
    public void init(){
        if(allDownloads!=null)
        {
            return;
        }
        repository=DownloadRepository.getInstance();
        allDownloads=repository.getDownloads();
    }

    public MutableLiveData<List<Downloads>> getAllDownloads() {
        return allDownloads;
    }
}
