package com.example.librarynitwstudent.Ui.MainActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.WindowManager;

import androidx.annotation.Nullable;

import com.example.librarynitwstudent.R;

public class ContactActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        setLayout();
    }
    void setLayout(){
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        DisplayMetrics dm=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width=dm.widthPixels;
        int height=dm.heightPixels;

        WindowManager.LayoutParams wlp=getWindow().getAttributes();
        getWindow().setAttributes(wlp);

        getWindow().setLayout((int) (width*0.9),WindowManager.LayoutParams.WRAP_CONTENT);
        getWindow().setGravity(Gravity.CENTER);
    }
}
