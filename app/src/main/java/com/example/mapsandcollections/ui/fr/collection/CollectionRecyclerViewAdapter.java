package com.example.mapsandcollections.ui.fr.collection;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mapsandcollections.R;
import com.example.mapsandcollections.dto.ItemTask;

import java.util.List;

public class CollectionRecyclerViewAdapter extends RecyclerView.Adapter<CollectionRecyclerViewAdapter.MyViewHolder> {

    private final List<ItemTask> results;

    public CollectionRecyclerViewAdapter(List<ItemTask> results) {

        this.results = results;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.widget, null, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CollectionRecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.bindItem(results.get(position), position);
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView title, description, result;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.description);
            result = itemView.findViewById(R.id.result);
        }

        public void bindItem(ItemTask itemTask, int position) {
            title.setText(itemTask.getTitle());
            description.setText(itemTask.getDescription());

        }
    }
}
