package com.example.librarynitwstudent.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.librarynitwstudent.models.Downloads;

import java.util.ArrayList;
import java.util.List;

public class DownloadRepository {

    private static DownloadRepository instance;
    private ArrayList<Downloads> dataSet=new ArrayList<>();

    public static DownloadRepository getInstance() {
        if(instance==null)
            instance=new DownloadRepository();
        return instance;
    }

    public MutableLiveData<List<Downloads>> getDownloads() {
        setDownloads();
        MutableLiveData<List<Downloads>> data =new MutableLiveData<>();
        data.setValue(dataSet);
        return data;
    }
    private void setDownloads(){
        dataSet.add(new Downloads("HCVerma","Physics","cc.pdf"));
        dataSet.add(new Downloads("CC","Competitive coding","cc.pdf"));
        dataSet.add(new Downloads("CC3","Competitive coding 3","cc.pdf"));
        dataSet.add(new Downloads("HCVerma","Physics","cc.pdf"));
        dataSet.add(new Downloads("CC","Competitive coding","cc.pdf"));
        dataSet.add(new Downloads("CC3","Competitive coding 3","cc.pdf"));
    }

}
