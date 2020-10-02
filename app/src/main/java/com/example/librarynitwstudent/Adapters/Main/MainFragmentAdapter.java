package com.example.librarynitwstudent.Adapters.Main;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainFragmentAdapter extends FragmentStatePagerAdapter {

    private final List<Fragment> fragments=new ArrayList<Fragment>();
    private final List<String> titles=new ArrayList<String >();

    public MainFragmentAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    public void AddFragment(Fragment fragment,String title)
    {
        fragments.add(fragment);
        titles.add(title);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        return super.instantiateItem(container, position);
    }

    @Override
    public void setPrimaryItem(@NonNull ViewGroup container, int position, @NonNull Object object) {


        super.setPrimaryItem(container, position, object);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
