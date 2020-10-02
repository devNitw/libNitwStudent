package com.example.librarynitwstudent.models;

public class Streams {
    private String StreamName;
    private String StreamDetail;

    public Streams(String name, String detail) {
        this.StreamName = name;
        this.StreamDetail = detail;
    }

    public String getStreamName() {
        return StreamName;
    }

    public void setStreamName(String streamName) {
        StreamName = streamName;
    }

    public String getStreamDetail() {
        return StreamDetail;
    }

    public void setStreamDetail(String streamDetail) {
        StreamDetail = streamDetail;
    }
}
