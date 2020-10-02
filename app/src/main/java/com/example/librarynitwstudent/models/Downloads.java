package com.example.librarynitwstudent.models;

public class Downloads {
    private String name;
    private String details;
    private String pdfLocation;

    public Downloads(String name, String details, String pdfLocation) {
        this.name = name;
        this.details = details;
        this.pdfLocation = pdfLocation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getPdfLocation() {
        return pdfLocation;
    }

    public void setPdfLocation(String pdfLocation) {
        this.pdfLocation = pdfLocation;
    }
}
