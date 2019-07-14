package com.example.mapsandcollections.ui.fr;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mapsandcollections.R;
import com.example.mapsandcollections.dto.ItemTask;

import java.text.DecimalFormat;
import java.util.List;

public class TaskItemsRecyclerViewAdapter extends RecyclerView.Adapter<TaskItemsRecyclerViewAdapter.MyViewHolder> {

    private final List<ItemTask> results;

    TaskItemsRecyclerViewAdapter(List<ItemTask> results) {
        this.results = results;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_task_view, null, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskItemsRecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.bindItem(results.get(position));
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    void setShowProgressBar() {
        for (ItemTask it : results) {
            it.setShowProgressBar(true);
        }
        notifyDataSetChanged();
    }

     class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView title, description, result;
        private final ProgressBar progressBar;

         MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.description);
            result = itemView.findViewById(R.id.result);
            progressBar = itemView.findViewById(R.id.progressBar);
        }

        void bindItem(ItemTask itemTask) {
            final DecimalFormat decimalFormat = new DecimalFormat("0.0##");
            if (itemTask.isShowProgressBar()) {
                progressBar.setVisibility(View.VISIBLE);
                result.setVisibility(View.INVISIBLE);
            } else {
                progressBar.setVisibility(View.INVISIBLE);
                result.setVisibility(View.VISIBLE);
            }
            title.setText(itemTask.getType());
            description.setText(itemTask.getAction());
            result.setText(String.format("%s ms", decimalFormat.format(itemTask.getResult())));
        }
    }
}
