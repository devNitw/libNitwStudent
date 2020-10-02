package com.example.librarynitwstudent.viewModels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.librarynitwstudent.models.Courses;
import com.example.librarynitwstudent.repository.CoursesRepository;

import java.util.List;

public class HomeFragmentViewModel extends ViewModel {

    private MutableLiveData<List<Courses>> allCourses;
    private CoursesRepository repository;
    public  void init(){
        if(allCourses!=null)
        {
            return;
        }
        repository=CoursesRepository.getInstance();
        allCourses=repository.getCourses();
    }

    public MutableLiveData<List<Courses>> getAllCourses() {
        return allCourses;
    }
}
