package com.example.mapsandcollections.ui.fr.collection;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mapsandcollections.R;
import com.example.mapsandcollections.components.Injections;
import com.example.mapsandcollections.dto.ItemTask;

import java.util.List;


public class CollectionFragment extends Fragment implements CollectionContract.IView, View.OnClickListener {

    private CollectionContract.IPresenter presenter;
    private CollectionRecyclerViewAdapter adapter;

    private EditText threadsView, elementsView;
    private List<ItemTask> itemTasks;

    public CollectionFragment() {
        this.presenter = Injections.getCollectionPresenter(this);
    }

    public static CollectionFragment newInstance() {
        Bundle args = new Bundle();
        CollectionFragment fragment = new CollectionFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_collection, container, false);
        initViews(v);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        itemTasks = presenter.getItemTasks();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onClick(View v) {
        if (TextUtils.isEmpty(elementsView.getText()) ||
                TextUtils.isEmpty(threadsView.getText()) ||
                "0".contentEquals(elementsView.getText()) ||
                "0".contentEquals(threadsView.getText())
        ) return;
        setShowProgressBar();
        adapter.notifyDataSetChanged();
        presenter.calculate(elementsView.getText().toString(), threadsView.getText().toString());
    }

    private void setShowProgressBar() {
        for (ItemTask it : itemTasks) {
            it.setShowProgressBar(true);
        }
    }

    @Override
    public void updateUI(int position) {
        adapter.notifyDataSetChanged();
    }

    private void initViews(View v) {
        v.findViewById(R.id.calculate_button).setOnClickListener(this);
        final RecyclerView recyclerView = v.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        recyclerView.addItemDecoration(new SpacesItemDecoration(8));
        adapter = new CollectionRecyclerViewAdapter(presenter.getItemTasks());
        recyclerView.setAdapter(adapter);
        threadsView = v.findViewById(R.id.editText_threads);
        elementsView = v.findViewById(R.id.editText_elements);
    }
}

