package com.example.librarynitwstudent.Ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.librarynitwstudent.R;

public class LibrarianView extends AppCompatActivity {

    TextView filePath;
    Button selectFile;
    Button upload;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.librarian_view);
        filePath=findViewById(R.id.filePath);
        selectFile=findViewById(R.id.selectFile);
        upload=findViewById(R.id.uploadFile);

        selectFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Intent.ACTION_GET_CONTENT);
                i.setType("*/*");
                startActivityForResult(i,1);
            }
        });
        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filePath.setVisibility(View.GONE);
                upload.setVisibility(View.GONE);
                Toast.makeText(getApplicationContext(),"File uploaded",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if(requestCode==1)
        {
            if(resultCode==RESULT_OK)
            {
                String path=data.getData().getPath();
                filePath.setText(path);
                filePath.setVisibility(View.VISIBLE);
                upload.setVisibility(View.VISIBLE);
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
