package com.example.attendenceapps;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ClassViewHolder> {
    ArrayList<AddClass>addClasses;
    Context context;

    public MyAdapter(ArrayList<AddClass> addClasses, Context context) {
        this.addClasses = addClasses;
        this.context = context;
    }

    @NonNull
    @Override
    public ClassViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.show_recycler_view_item,parent,false);
        return new ClassViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClassViewHolder holder, int position) {
      holder.recyclerviewClassName.setText(addClasses.get(position).getClassName());
      holder.recyclerviewSubjectName.setText(addClasses.get(position).getSubjectName());

    }

    @Override
    public int getItemCount() {
        return addClasses.size();
    }

    public class ClassViewHolder extends RecyclerView.ViewHolder {
        TextView recyclerviewClassName,recyclerviewSubjectName;
        public ClassViewHolder(@NonNull View itemView) {
            super(itemView);
            recyclerviewClassName=itemView.findViewById(R.id.className_recyclerView_item);
            recyclerviewSubjectName=itemView.findViewById(R.id.subject_recyclerView_item);
        }
    }
}
