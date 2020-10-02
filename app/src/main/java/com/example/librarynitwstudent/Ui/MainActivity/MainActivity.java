package com.example.librarynitwstudent.Ui.MainActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.librarynitwstudent.Adapters.Main.MainFragmentAdapter;
import com.example.librarynitwstudent.R;
import com.example.librarynitwstudent.Ui.MainActivity.Home.SyllabusCard;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawer;
    private Toolbar toolbar;

    MainFragmentAdapter fragmentAdapter;
    public static ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setupSideNavigationViewer();

        fragmentAdapter = new MainFragmentAdapter(getSupportFragmentManager());
        viewPager = findViewById(R.id.main_container);
        final BottomNavigationView bottomNav = findViewById(R.id.bottom_nav_view);
        bottomNav.setOnNavigationItemSelectedListener(bottomNavListener);

        fragmentAdapter.AddFragment(new HomeFragment(), "Home");
        fragmentAdapter.AddFragment(new LibraryFragment(), "Find");
        fragmentAdapter.AddFragment(new OfflineFragment(), "Saved");
        fragmentAdapter.AddFragment(new ReadingFragment(), "Daily");

        viewPager.setAdapter(fragmentAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                bottomNav.getMenu().getItem(position).setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void setupSideNavigationViewer() {
        drawer = findViewById(R.id.drawer);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.side_nav_view);
        navigationView.setNavigationItemSelectedListener(sideNavListener);

    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    private BottomNavigationView.OnNavigationItemSelectedListener bottomNavListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment focusFragment = null;

                    switch (menuItem.getItemId()) {
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
                        default:
                            return false;
                    }

                    return true;
                }
            };

    private NavigationView.OnNavigationItemSelectedListener sideNavListener =
            new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Intent intent = null;
                    switch(item.getItemId()){
                        case R.id.nav_profile:
                            Toast.makeText(MainActivity.this,"Launch ProfileActivity",Toast.LENGTH_SHORT).show();
//                            intent = new Intent(MainActivity.this,ProfileActivity.class);
//                            startActivity(intent);
                            break;
                        case R.id.nav_settings:
                            Toast.makeText(MainActivity.this,"Launch SettingsActivity",Toast.LENGTH_SHORT).show();
//                            intent = new Intent(MainActivity.this,SettingsActivity.class);
//                            startActivity(intent);
                            break;
                        case R.id.nav_contact:
                            intent = new Intent(MainActivity.this, ContactActivity.class);
                            startActivity(intent);
                            break;

                    }

                    drawer.closeDrawer(GravityCompat.START);
                    return true;
                }
            };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.tool_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId()){
            case R.id.search:
                Toast.makeText(MainActivity.this,"Launch SearchActivity",Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(this,SearchActivity.class);
//                startActivity(intent);
                break;

        }
        return true;
    }
}