package com.example.librarynitwstudent.Ui.MainActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.librarynitwstudent.Adapters.Main.MainFragmentAdapter;
import com.example.librarynitwstudent.R;
import com.example.librarynitwstudent.Ui.MainActivity.Home.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    MainFragmentAdapter fragmentAdapter;
    public static ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentAdapter=new MainFragmentAdapter(getSupportFragmentManager());
        viewPager=findViewById(R.id.main_container);
        final BottomNavigationView bottomNav = findViewById(R.id.nav_view);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        fragmentAdapter.AddFragment(new HomeFragment(),"Home");
        fragmentAdapter.AddFragment(new LibraryFragment(),"Find");
        fragmentAdapter.AddFragment(new ReadingFragment(),"Daily");
        fragmentAdapter.AddFragment(new OfflineFragment(),"Saved");

        viewPager.setAdapter(fragmentAdapter);


    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment focusFragment = null;

                    switch(menuItem.getItemId()){
                        case R.id.nav_home:
                            MainActivity.viewPager.setCurrentItem(0);
                            break;
                        case R.id.nav_lib:
                            MainActivity.viewPager.setCurrentItem(1);
                            break;
                        case R.id.nav_offline:
                            MainActivity.viewPager.setCurrentItem(2);
                            break;
                        case R.id.nav_read:
                            MainActivity.viewPager.setCurrentItem(3);
                            break;
                        default:return false;
                    }

                    return true;
                }
            };
}