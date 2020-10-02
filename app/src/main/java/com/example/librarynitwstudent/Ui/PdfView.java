package com.example.librarynitwstudent.Ui;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.librarynitwstudent.R;
import com.github.barteksc.pdfviewer.PDFView;

public class PdfView extends AppCompatActivity {

    PDFView pdfView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pdf_view);

        pdfView=findViewById(R.id.pdfView);
        pdfView.fromAsset("cc.pdf").load();


    }
}
