package com.example.librarynitwstudent.Adapters.Main;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.librarynitwstudent.R;
import com.example.librarynitwstudent.Ui.LibraryContent.ContentView;
import com.example.librarynitwstudent.Ui.MainActivity.Home.SyllabusCard;
import com.example.librarynitwstudent.models.Courses;

import java.util.ArrayList;
import java.util.List;

public class HomeRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private final LayoutInflater inflater;
    private List<Courses> allCourses=new ArrayList<>();

    public HomeRecyclerAdapter(Context context, List<Courses> value){
        inflater=LayoutInflater.from(context);
        this.context=context;
        allCourses=value;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.card_main,parent,false);
        ViewHolder vh=new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        ((ViewHolder)holder).courseName.setText((allCourses.get(position).getName()));
        ((ViewHolder)holder).courseDetails.setText(allCourses.get(position).getDetails());
        ((ViewHolder)holder).view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"clicked view",Toast.LENGTH_SHORT).show();
                Intent i =new Intent(context, ContentView.class);
                context.startActivity(i);
            }
        });
        ((ViewHolder)holder).syllabus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(context, SyllabusCard.class);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return allCourses.size();
    }

    private class ViewHolder extends RecyclerView.ViewHolder{
        private TextView courseName;
        private TextView courseDetails;
        private RelativeLayout view;
        private ImageButton syllabus;

        public  ViewHolder(@NonNull View itemView){
            super(itemView);
            view=itemView.findViewById(R.id.view);
            courseName=itemView.findViewById(R.id.courseName);
            courseDetails=itemView.findViewById(R.id.courseDetails);
            syllabus=itemView.findViewById(R.id.syllabusBT);
        }
    }
}
