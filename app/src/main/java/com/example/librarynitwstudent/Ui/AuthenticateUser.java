package com.example.librarynitwstudent.Ui;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.librarynitwstudent.Ui.MainActivity.MainActivity;
import com.example.librarynitwstudent.R;

public class AuthenticateUser extends AppCompatActivity {

    Button login;
    EditText username;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_card);
        login=findViewById(R.id.loginBT);
        username=findViewById(R.id.usernameET);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!username.getText().toString().equalsIgnoreCase("library")) {
                    Intent i = new Intent(AuthenticateUser.this, MainActivity.class);
                    startActivity(i);
                    finish();
                }
                else
                {
                    Intent i =new Intent(AuthenticateUser.this,LibrarianView.class);
                    startActivity(i);
                    finish();
                }
            }
        });
    }

}
