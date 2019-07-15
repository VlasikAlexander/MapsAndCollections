package com.example.mapsandcollections.ui.fr;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mapsandcollections.R;
import com.example.mapsandcollections.components.Injections;

public class ItemTasksFragment extends Fragment implements ItemTasksContract.IView, View.OnClickListener {

    private static final String EXTRA_MODEL_TYPE = "extra_model_type";

    private ItemTasksContract.IPresenter presenter;
    private TaskItemsRecyclerViewAdapter adapter;
    private EditText threadsView, elementsView;
    private String type;

    public ItemTasksFragment() {
        this.presenter = Injections.getBaseFragmentPresenter(this);
    }

    public static ItemTasksFragment newInstance(String type) {
        final Bundle args = new Bundle();
        final ItemTasksFragment fragment = new ItemTasksFragment();
        args.putString(EXTRA_MODEL_TYPE, type);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        type = getArguments() != null ? getArguments().getString(EXTRA_MODEL_TYPE) : null;
        presenter.setType(type);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.fragment_item_task, container, false);
        initViews(v);
        return v;
    }

    @Override
    public void onClick(View v) {
        presenter.calculate(type, elementsView.getText().toString(), threadsView.getText().toString());
    }

    @Override
    public void setShowProgressBar() {
        adapter.setShowProgressBar();
    }

    @Override
    public void showError() {
        Toast.makeText(getContext(), R.string.error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public synchronized void updateUI(int position) {
        adapter.notifyItemChanged(position);
    }

    private void initViews(View v) {
        v.findViewById(R.id.calculate_button).setOnClickListener(this);
        elementsView = v.findViewById(R.id.editText_elements);
        threadsView = v.findViewById(R.id.editText_threads);
        adapter = new TaskItemsRecyclerViewAdapter(presenter.getItemTasks());

        final RecyclerView recyclerView = v.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), presenter.getSpanCount(type)));
        recyclerView.addItemDecoration(new SpacesItemDecoration(8));
        recyclerView.setAdapter(adapter);
    }
}
