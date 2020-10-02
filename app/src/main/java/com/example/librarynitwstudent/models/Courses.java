package com.example.librarynitwstudent.models;

public class Courses {

    private String name;
    private String details;
    private String syllabus;

    public Courses(String name, String details, String syllabus) {
        this.name = name;
        this.details = details;
        this.syllabus = syllabus;
    }

    public String getName() {
        return name;
    }

    public String getDetails() {
        return details;
    }

    public String getSyllabus() {
        return syllabus;
    }
}
