package com.example.librarynitwstudent.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.librarynitwstudent.models.Courses;

import java.util.ArrayList;
import java.util.List;

public class CoursesRepository {

    private static  CoursesRepository instance;
    private ArrayList<Courses> dataSet=new ArrayList<>();

    public static CoursesRepository getInstance() {
        if(instance==null)
            instance=new CoursesRepository();
        return instance;
    }

    public MutableLiveData<List<Courses>> getCourses(){
        setCourses();
        MutableLiveData<List<Courses>> data=new MutableLiveData<>();
        data.setValue(dataSet);
        return  data;

    }

    private void setCourses(){
        dataSet.add(new Courses("DSA","Data structures and algorithms","Demo syllabus"));
        dataSet.add(new Courses("DLD","Digital logic circuits","Demo syllabus"));
        dataSet.add(new Courses("NA","Network Analysis","Demo syllabus"));
        dataSet.add(new Courses("DM","Discrete Mathematics","Demo syllabus"));
        dataSet.add(new Courses("DSA","Data structures and algorithms","Demo syllabus"));
        dataSet.add(new Courses("DLD","Digital logic circuits","Demo syllabus"));
        dataSet.add(new Courses("NA","Network Analysis","Demo syllabus"));
        dataSet.add(new Courses("DM","Discrete Mathematics","Demo syllabus"));

    }

}
