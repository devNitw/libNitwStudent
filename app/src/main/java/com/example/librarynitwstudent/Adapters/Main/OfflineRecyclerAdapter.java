package com.example.librarynitwstudent.Adapters.Main;

import android.content.Context;
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
import com.example.librarynitwstudent.models.Downloads;

import java.util.List;

public class OfflineRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final LayoutInflater inflater;
    private Context context;
    private List<Downloads> downloads;

    public OfflineRecyclerAdapter(Context context, List<Downloads> downloads) {
        inflater=LayoutInflater.from(context);
        this.context = context;
        this.downloads = downloads;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.downloaded_cards,parent,false);
        ViewHolder vh=new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {

        ((ViewHolder)holder).downloadName.setText(downloads.get(position).getName());
        ((ViewHolder)holder).downloadDetails.setText(downloads.get(position).getDetails());
        ((ViewHolder)holder).view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"Downloads clicked",Toast.LENGTH_SHORT).show();
            }
        });
        ((ViewHolder)holder).delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"deleted",Toast.LENGTH_SHORT).show();
                downloads.remove(position);
                notifyDataSetChanged();
            }
        });
    }


    @Override
    public int getItemCount() {
        return downloads.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView downloadName;
        private TextView downloadDetails;
        private ImageButton delete;
        private RelativeLayout view;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            view=itemView.findViewById(R.id.DownloadView);
            downloadName=itemView.findViewById(R.id.DownloadName);
            downloadDetails=itemView.findViewById(R.id.DownloadDescription);
            delete=itemView.findViewById(R.id.DownloadDelete);
        }
    }
}
