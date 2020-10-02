package com.example.librarynitwstudent.Adapters.Main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.librarynitwstudent.R;
import com.example.librarynitwstudent.models.Streams;

import java.util.List;

public class StreamViewPagerAdapter extends PagerAdapter {

    private List<Streams> streams;
    private LayoutInflater layoutInflater;
    private Context context;

    public StreamViewPagerAdapter(List<Streams> streams, Context context) {
        this.streams = streams;
        this.context = context;
    }


    @Override
    public int getCount() {
        return streams.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater =LayoutInflater.from(context);
        View view =layoutInflater.inflate(R.layout.stream_cards,container,false);
        TextView Name=view.findViewById(R.id.StreamName);
        TextView details=view.findViewById(R.id.StreamDetails);

        Name.setText(streams.get(position).getStreamName());
        details.setText(streams.get(position).getStreamDetail());

        container.addView(view,0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

}
