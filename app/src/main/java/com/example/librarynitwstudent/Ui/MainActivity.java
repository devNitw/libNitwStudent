package com.example.librarynitwstudent.Ui;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.librarynitwstudent.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNav = findViewById(R.id.nav_view);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().
                replace(R.id.nav_fragment_host,new HomeFragment()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment focusFragment = null;

                    switch(menuItem.getItemId()){
                        case R.id.nav_home:
                            focusFragment=new HomeFragment();
                            break;
                        case R.id.nav_lib:
                            focusFragment=new LibraryFragment();
                            break;
                        case R.id.nav_offline:
                            focusFragment=new OfflineFragment();
                            break;
                        case R.id.nav_read:
                            focusFragment=new ReadingFragment();
                            break;
                        default:return false;
                    }
                    getSupportFragmentManager().beginTransaction().
                            replace(R.id.nav_fragment_host,focusFragment).commit();

                    return true;
                }
            };

}