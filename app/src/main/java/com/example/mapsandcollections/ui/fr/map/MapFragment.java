package com.example.mapsandcollections.ui.fr.map;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mapsandcollections.R;
import com.example.mapsandcollections.components.Injections;

import java.util.List;

public class MapFragment extends Fragment implements MapContract.IView, View.OnClickListener {

    private static final String TREE_MAP = "TreeMap";
    private static final String HASH_MAP = "HashMap";

    private static final String ADD_NEW = "Add new";
    private static final String SEARCH_BY_KEY = "Search by key";
    private static final String REMOVING = "Removing";
    private  Handler handler;



    private View treeMapAddNew, treeMapSearchByKey, treeMapRemoving,
            hashMapAddNew, hashMapSearchByKey, hashMapRemoving;

    private EditText threadsView, elementsView;
    private Button button;


    private MapContract.IPresenter presenter;
    private MapContract.IHost host;




    public static MapFragment newInstance() {
        
        Bundle args = new Bundle();
        
        MapFragment fragment = new MapFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_map, null,  false);
        initViews(v);
        presenter = Injections.getMapFragmentPresenter(this);
        return v;
    }

    private void initViews(View v) {



        threadsView = v.findViewById(R.id.editText_threads);
        elementsView = v.findViewById(R.id.editText_elements);
        button = v.findViewById(R.id.calculate_button);
        button.setOnClickListener(this);



        treeMapAddNew = v.findViewById(R.id.include1);
        treeMapRemoving = v.findViewById(R.id.include3);
        treeMapSearchByKey = v.findViewById(R.id.include5);

        hashMapAddNew = v.findViewById(R.id.include2);
        hashMapRemoving = v.findViewById(R.id.include4);
        hashMapSearchByKey = v.findViewById(R.id.include6);

        ((TextView) treeMapAddNew.findViewById(R.id.title)).setText(TREE_MAP);
        ((TextView) treeMapSearchByKey.findViewById(R.id.title)).setText(TREE_MAP);
        ((TextView) treeMapRemoving.findViewById(R.id.title)).setText(TREE_MAP);


        ((TextView) treeMapAddNew.findViewById(R.id.description)).setText(ADD_NEW);
        ((TextView) treeMapSearchByKey.findViewById(R.id.description)).setText(SEARCH_BY_KEY);
        ((TextView) treeMapRemoving.findViewById(R.id.description)).setText(REMOVING);

        ((TextView) hashMapAddNew.findViewById(R.id.title)).setText(HASH_MAP);
        ((TextView) hashMapSearchByKey.findViewById(R.id.title)).setText(HASH_MAP);
        ((TextView) hashMapRemoving.findViewById(R.id.title)).setText(HASH_MAP);

        ((TextView) hashMapAddNew.findViewById(R.id.description)).setText(ADD_NEW);
        ((TextView) hashMapSearchByKey.findViewById(R.id.description)).setText(SEARCH_BY_KEY);
        ((TextView) hashMapRemoving.findViewById(R.id.description)).setText(REMOVING);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        host = (MapContract.IHost) context;
    }

    @Override
    public void onDetach() {
        host = null;
        super.onDetach();
    }


    @SuppressLint("HandlerLeak")
    @Override
    public void onClick(View v) {
        final String threads = threadsView.getText().toString();
        final String elements = elementsView.getText().toString();
        if (TextUtils.isEmpty(threads) || TextUtils.isEmpty(elements)) return;
        showProgressBar();
        presenter.calculate(threads, elements);

        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                Toast.makeText(getContext(), "Hello", Toast.LENGTH_SHORT).show();
                super.handleMessage(msg);
            }
        };
    }

    private void showProgressBar() {

    }

    @Override
    public void updateUI(List<Double> list) {
        Toast.makeText(getContext(), list.size() + " ", Toast.LENGTH_SHORT).show();
    }
}
