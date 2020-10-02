package com.example.librarynitwstudent.Adapters.Main.LibraryRecyclerAdapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.librarynitwstudent.R;
import com.example.librarynitwstudent.Ui.MainActivity.Home.SyllabusCard;
import com.example.librarynitwstudent.models.Downloads;

import java.util.List;

public class ContentRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<Downloads> books;

    public ContentRecyclerAdapter(Context context, List<Downloads> books) {
        this.context = context;
        this.books = books;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.library_content_cards, parent, false);
        ViewHolder vh=new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ViewHolder)holder).contentName.setText(books.get(position).getName());
        ((ViewHolder)holder).contentDetails.setText(books.get(position).getDetails());
        ((ViewHolder)holder).view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(context, SyllabusCard.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(i);
            }
        });
        ((ViewHolder)holder).save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Content will be downloaded, see the offline tab for further info.", Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    public int getItemCount() {
        return books.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView contentName;
        private TextView contentDetails;
        private ImageButton save;
        private RelativeLayout view;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView.findViewById(R.id.ContentView);
            contentName = itemView.findViewById(R.id.ContentName);
            contentDetails = itemView.findViewById(R.id.ContentDescription);
            save = itemView.findViewById(R.id.ContentSave);
        }

    }
}
