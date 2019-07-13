package com.example.mapsandcollections.ui.fr;

import android.os.Bundle;
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

import static com.example.mapsandcollections.ui.MyFragmentAdapter.COLLECTION;

public class BaseFragment extends Fragment implements BaseContract.IView, View.OnClickListener {

    private static final String EXTRA_MODEL_TYPE = "extra_model_type";

    private BaseContract.IPresenter presenter;
    private TaskItemsRecyclerViewAdapter adapter;
    private EditText threadsView, elementsView;
    private String type;

    public BaseFragment() {
        this.presenter = Injections.getBaseFragmentPresenter(this);
    }

    public static BaseFragment newInstance(String type) {
        final Bundle args = new Bundle();
        final BaseFragment fragment = new BaseFragment();
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
        final View v = inflater.inflate(R.layout.fragment_base, container, false);
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
    public void updateUI(int position) {
        adapter.notifyItemChanged(position);
    }

    private void initViews(View v) {
        v.findViewById(R.id.calculate_button).setOnClickListener(this);
        elementsView = v.findViewById(R.id.editText_elements);
        threadsView = v.findViewById(R.id.editText_threads);
        final RecyclerView recyclerView = v.findViewById(R.id.recycler);
        adapter = new TaskItemsRecyclerViewAdapter(presenter.getItemTasks());
        if (COLLECTION.equals(type))
            recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        else recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        recyclerView.addItemDecoration(new SpacesItemDecoration(8));
        recyclerView.setAdapter(adapter);
    }
}
