package com.example.mapsandcollections.ui.fr.collection;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.mapsandcollections.R;
import com.example.mapsandcollections.components.Injections;

import java.text.DecimalFormat;
import java.util.List;

import static com.example.mapsandcollections.components.tasker.TasksModel.ARRAYLIST_ADD_BEGIN;
import static com.example.mapsandcollections.components.tasker.TasksModel.ARRAYLIST_ADD_END;
import static com.example.mapsandcollections.components.tasker.TasksModel.ARRAYLIST_ADD_MIDDLE;
import static com.example.mapsandcollections.components.tasker.TasksModel.ARRAYLIST_REMOVE_BEGIN;
import static com.example.mapsandcollections.components.tasker.TasksModel.ARRAYLIST_REMOVE_END;
import static com.example.mapsandcollections.components.tasker.TasksModel.ARRAYLIST_REMOVE_MIDDLE;
import static com.example.mapsandcollections.components.tasker.TasksModel.ARRAYLIST_SEARCH_BY_VALUE;
import static com.example.mapsandcollections.components.tasker.TasksModel.COW_ADD_BEGIN;
import static com.example.mapsandcollections.components.tasker.TasksModel.COW_ADD_END;
import static com.example.mapsandcollections.components.tasker.TasksModel.COW_ADD_MIDDLE;
import static com.example.mapsandcollections.components.tasker.TasksModel.COW_REMOVE_BEGIN;
import static com.example.mapsandcollections.components.tasker.TasksModel.COW_REMOVE_END;
import static com.example.mapsandcollections.components.tasker.TasksModel.COW_REMOVE_MIDDLE;
import static com.example.mapsandcollections.components.tasker.TasksModel.COW_SEARCH_BY_VALUE;
import static com.example.mapsandcollections.components.tasker.TasksModel.LINKEDLIST_ADD_BEGIN;
import static com.example.mapsandcollections.components.tasker.TasksModel.LINKEDLIST_ADD_END;
import static com.example.mapsandcollections.components.tasker.TasksModel.LINKEDLIST_ADD_MIDDLE;
import static com.example.mapsandcollections.components.tasker.TasksModel.LINKEDLIST_REMOVE_BEGIN;
import static com.example.mapsandcollections.components.tasker.TasksModel.LINKEDLIST_REMOVE_END;
import static com.example.mapsandcollections.components.tasker.TasksModel.LINKEDLIST_REMOVE_MIDDLE;
import static com.example.mapsandcollections.components.tasker.TasksModel.LINKEDLIST_SEARCH_BY_VALUE;

public class CollectionFragment extends Fragment implements CollectionContract.IView, View.OnClickListener {

    private CollectionContract.IPresenter presenter;
    private CollectionContract.IHost host;
    private static final String ARRAY_LIST = "ArrayList";
    private static final String LINKED_LIST = "LinkedList";
    private static final String COPY_ON_WRITE_LIST = "CopyOnWriteList";

    private static final String ADD_IN_BEGINING = "Add in the\nbeginning";
    private static final String ADD_IN_END = "Add in the\nend";
    private static final String ADD_IN_MIDDLE = "Add in the\nmiddle";
    private static final String REMOVE_IN_MIDDLE = "Remove in the\nmiddle";
    private static final String REMOVE_IN_BEGINNING = "Remove in the\nbeginning";
    private static final String REMOVE_IN_END = "Remove in the\nend";
    private static final String SEARCH_BY_VALUE = "Search by\nvalue";

    DecimalFormat decimalFormat = new DecimalFormat("0.0##");

    private View arrayListAddToBegin, arrayListAddToEnd, arrayListAddToMiddle, arrayListSearchByValue, arrayListRemoveBegin, arrayListRemoveMiddle, arrayListRemoveEnd,
            linkedListAddToBegin, linkedListAddToEnd, linkedListAddToMiddle, linkedListSearchByValue, linkedListRemoveBegin, linkedListRemoveMiddle, linkedListRemoveEnd,
            cow_ListAddToBegin, cow_ListAddToEnd, cow_ListAddToMiddle, cow_ListSearchByValue, cow_ListRemoveBegin, cow_ListRemoveMiddle, cow_ListRemoveEnd;

    private Button button;
    private EditText threadsView, elementsView;

    public static CollectionFragment newInstance() {

        Bundle args = new Bundle();
        CollectionFragment fragment = new CollectionFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_collection, null, false);
        initViews(v);
        presenter = Injections.getCollectionPresenter(this);
        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        host = (CollectionContract.IHost) context;
    }

    @Override
    public void onDetach() {
        host = null;
        super.onDetach();
    }

    @Override
    public void onClick(View v) {
        final String threads = threadsView.getText().toString();
        final String elements = elementsView.getText().toString();
        if (TextUtils.isEmpty(threads) || TextUtils.isEmpty(elements) || "0".equals(elements) || "0".equals(threads))
            return;
        showProgressBar(true);
        clearTextHolder();

        presenter.calculate(threads, elements);
    }

    private void clearTextHolder() {
        ((TextView) arrayListAddToBegin.findViewById(R.id.result)).setText("");
        ((TextView) arrayListAddToEnd.findViewById(R.id.result)).setText("");
        ((TextView) arrayListAddToMiddle.findViewById(R.id.result)).setText("");
        ((TextView) arrayListSearchByValue.findViewById(R.id.result)).setText("");
        ((TextView) arrayListRemoveBegin.findViewById(R.id.result)).setText("");
        ((TextView) arrayListRemoveMiddle.findViewById(R.id.result)).setText("");
        ((TextView) arrayListRemoveEnd.findViewById(R.id.result)).setText("");

        ((TextView) linkedListAddToBegin.findViewById(R.id.result)).setText("");
        ((TextView) linkedListAddToEnd.findViewById(R.id.result)).setText("");
        ((TextView) linkedListAddToMiddle.findViewById(R.id.result)).setText("");
        ((TextView) linkedListRemoveEnd.findViewById(R.id.result)).setText("");
        ((TextView) linkedListRemoveMiddle.findViewById(R.id.result)).setText("");
        ((TextView) linkedListRemoveBegin.findViewById(R.id.result)).setText("");
        ((TextView) linkedListSearchByValue.findViewById(R.id.result)).setText("");

        ((TextView) cow_ListAddToBegin.findViewById(R.id.result)).setText("");
        ((TextView) cow_ListAddToEnd.findViewById(R.id.result)).setText("");
        ((TextView) cow_ListAddToMiddle.findViewById(R.id.result)).setText("");
        ((TextView) cow_ListSearchByValue.findViewById(R.id.result)).setText("");
        ((TextView) cow_ListRemoveBegin.findViewById(R.id.result)).setText("");
        ((TextView) cow_ListRemoveMiddle.findViewById(R.id.result)).setText("");
        ((TextView) cow_ListRemoveEnd.findViewById(R.id.result)).setText("");
    }

    @Override
    public void updateUI(List<Double> list) {
        showProgressBar(false);

        ((TextView) arrayListAddToBegin.findViewById(R.id.result)).setText(String.format("%sms", list.get(0)));
        ((TextView) arrayListAddToEnd.findViewById(R.id.result)).setText(String.format("%sms", list.get(1)));
        ((TextView) arrayListAddToMiddle.findViewById(R.id.result)).setText(String.format("%sms", list.get(2)));
        ((TextView) arrayListSearchByValue.findViewById(R.id.result)).setText(String.format("%sms", list.get(3)));
        ((TextView) arrayListRemoveBegin.findViewById(R.id.result)).setText(String.format("%sms", list.get(4)));
        ((TextView) arrayListRemoveMiddle.findViewById(R.id.result)).setText(String.format("%sms", list.get(5)));
        ((TextView) arrayListRemoveEnd.findViewById(R.id.result)).setText(String.format("%sms", list.get(6)));

        ((TextView) linkedListAddToBegin.findViewById(R.id.result)).setText(String.format("%sms", list.get(7)));
        ((TextView) linkedListAddToEnd.findViewById(R.id.result)).setText(String.format("%sms", list.get(8)));
        ((TextView) linkedListAddToMiddle.findViewById(R.id.result)).setText(String.format("%sms", list.get(9)));
        ((TextView) linkedListRemoveEnd.findViewById(R.id.result)).setText(String.format("%sms", list.get(10)));
        ((TextView) linkedListRemoveMiddle.findViewById(R.id.result)).setText(String.format("%sms", list.get(11)));
        ((TextView) linkedListRemoveBegin.findViewById(R.id.result)).setText(String.format("%sms", list.get(12)));
        ((TextView) linkedListSearchByValue.findViewById(R.id.result)).setText(String.format("%sms", list.get(13)));

        ((TextView) cow_ListAddToBegin.findViewById(R.id.result)).setText(String.format("%sms", list.get(14)));
        ((TextView) cow_ListAddToEnd.findViewById(R.id.result)).setText(String.format("%sms", list.get(15)));
        ((TextView) cow_ListAddToMiddle.findViewById(R.id.result)).setText(String.format("%sms", list.get(16)));
        ((TextView) cow_ListSearchByValue.findViewById(R.id.result)).setText(String.format("%sms", list.get(17)));
        ((TextView) cow_ListRemoveBegin.findViewById(R.id.result)).setText(String.format("%sms", list.get(18)));
        ((TextView) cow_ListRemoveMiddle.findViewById(R.id.result)).setText(String.format("%sms", list.get(19)));
        ((TextView) cow_ListRemoveEnd.findViewById(R.id.result)).setText(String.format("%sms", list.get(20)));


    }

    @Override
    public void updateOneWidget(double time, String task) {

        switch (task) {
            case ARRAYLIST_ADD_BEGIN:
                arrayListAddToBegin.findViewById(R.id.progressBar).setVisibility(View.INVISIBLE);
                ((TextView) arrayListAddToBegin.findViewById(R.id.result)).setText(String.format("%s ms", decimalFormat.format(time)));
                break;
            case ARRAYLIST_ADD_MIDDLE:
                arrayListAddToMiddle.findViewById(R.id.progressBar).setVisibility(View.INVISIBLE);
                ((TextView) arrayListAddToMiddle.findViewById(R.id.result)).setText(String.format("%s ms", decimalFormat.format(time)));
                break;
            case ARRAYLIST_ADD_END:
                arrayListAddToEnd.findViewById(R.id.progressBar).setVisibility(View.INVISIBLE);
                ((TextView) arrayListAddToEnd.findViewById(R.id.result)).setText(String.format("%s ms", decimalFormat.format(time)));
                break;
            case ARRAYLIST_SEARCH_BY_VALUE:
                arrayListSearchByValue.findViewById(R.id.progressBar).setVisibility(View.INVISIBLE);
                ((TextView) arrayListSearchByValue.findViewById(R.id.result)).setText(String.format("%s ms", decimalFormat.format(time)));
                break;
            case ARRAYLIST_REMOVE_BEGIN:
                arrayListRemoveBegin.findViewById(R.id.progressBar).setVisibility(View.INVISIBLE);
                ((TextView) arrayListRemoveBegin.findViewById(R.id.result)).setText(String.format("%s ms", decimalFormat.format(time)));
                break;
            case ARRAYLIST_REMOVE_MIDDLE:
                arrayListRemoveMiddle.findViewById(R.id.progressBar).setVisibility(View.INVISIBLE);
                ((TextView) arrayListRemoveMiddle.findViewById(R.id.result)).setText(String.format("%s ms", decimalFormat.format(time)));
                break;
            case ARRAYLIST_REMOVE_END:
                arrayListRemoveEnd.findViewById(R.id.progressBar).setVisibility(View.INVISIBLE);
                ((TextView) arrayListRemoveEnd.findViewById(R.id.result)).setText(String.format("%s ms", decimalFormat.format(time)));
                break;
            case LINKEDLIST_ADD_BEGIN:
                linkedListAddToBegin.findViewById(R.id.progressBar).setVisibility(View.INVISIBLE);
                ((TextView) linkedListAddToBegin.findViewById(R.id.result)).setText(String.format("%s ms", decimalFormat.format(time)));
                break;
            case LINKEDLIST_ADD_MIDDLE:
                linkedListAddToMiddle.findViewById(R.id.progressBar).setVisibility(View.INVISIBLE);
                ((TextView) linkedListAddToMiddle.findViewById(R.id.result)).setText(String.format("%s ms", decimalFormat.format(time)));
                break;
            case LINKEDLIST_ADD_END:
                linkedListAddToEnd.findViewById(R.id.progressBar).setVisibility(View.INVISIBLE);
                ((TextView) linkedListAddToEnd.findViewById(R.id.result)).setText(String.format("%s ms", decimalFormat.format(time)));
                break;
            case LINKEDLIST_SEARCH_BY_VALUE:
                linkedListSearchByValue.findViewById(R.id.progressBar).setVisibility(View.INVISIBLE);
                ((TextView) linkedListSearchByValue.findViewById(R.id.result)).setText(String.format("%s ms", decimalFormat.format(time)));
                break;
            case LINKEDLIST_REMOVE_BEGIN:
                linkedListRemoveBegin.findViewById(R.id.progressBar).setVisibility(View.INVISIBLE);
                ((TextView) linkedListRemoveBegin.findViewById(R.id.result)).setText(String.format("%s ms", decimalFormat.format(time)));
                break;
            case LINKEDLIST_REMOVE_MIDDLE:
                linkedListRemoveMiddle.findViewById(R.id.progressBar).setVisibility(View.INVISIBLE);
                ((TextView) linkedListRemoveMiddle.findViewById(R.id.result)).setText(String.format("%s ms", decimalFormat.format(time)));
                break;
            case LINKEDLIST_REMOVE_END:
                linkedListRemoveEnd.findViewById(R.id.progressBar).setVisibility(View.INVISIBLE);
                ((TextView) linkedListRemoveEnd.findViewById(R.id.result)).setText(String.format("%s ms", decimalFormat.format(time)));
                break;
            case COW_ADD_BEGIN:
                cow_ListAddToBegin.findViewById(R.id.progressBar).setVisibility(View.INVISIBLE);
                ((TextView) cow_ListAddToBegin.findViewById(R.id.result)).setText(String.format("%s ms", decimalFormat.format(time)));
                break;
            case COW_ADD_MIDDLE:
                cow_ListAddToMiddle.findViewById(R.id.progressBar).setVisibility(View.INVISIBLE);
                ((TextView) cow_ListAddToMiddle.findViewById(R.id.result)).setText(String.format("%s ms", decimalFormat.format(time)));
                break;
            case COW_ADD_END:
                cow_ListAddToEnd.findViewById(R.id.progressBar).setVisibility(View.INVISIBLE);
                ((TextView) cow_ListAddToEnd.findViewById(R.id.result)).setText(String.format("%s ms", decimalFormat.format(time)));
                break;
            case COW_SEARCH_BY_VALUE:
                cow_ListSearchByValue.findViewById(R.id.progressBar).setVisibility(View.INVISIBLE);
                ((TextView) cow_ListSearchByValue.findViewById(R.id.result)).setText(String.format("%s ms", decimalFormat.format(time)));
                break;
            case COW_REMOVE_BEGIN:
                cow_ListRemoveBegin.findViewById(R.id.progressBar).setVisibility(View.INVISIBLE);
                ((TextView) cow_ListRemoveBegin.findViewById(R.id.result)).setText(String.format("%s ms", decimalFormat.format(time)));
                break;
            case COW_REMOVE_MIDDLE:
                cow_ListRemoveMiddle.findViewById(R.id.progressBar).setVisibility(View.INVISIBLE);
                ((TextView) cow_ListRemoveMiddle.findViewById(R.id.result)).setText(String.format("%s ms", decimalFormat.format(time)));
                break;
            case COW_REMOVE_END:
                cow_ListRemoveEnd.findViewById(R.id.progressBar).setVisibility(View.INVISIBLE);
                ((TextView) cow_ListRemoveEnd.findViewById(R.id.result)).setText(String.format("%s ms", decimalFormat.format(time)));
                break;
        }
    }

    private void initViews(View v) {

        button = v.findViewById(R.id.calculate_button);
        button.setOnClickListener(this);

        threadsView = v.findViewById(R.id.editText_threads);
        elementsView = v.findViewById(R.id.editText_elements);

        arrayListAddToBegin = v.findViewById(R.id.include1);
        arrayListAddToEnd = v.findViewById(R.id.include4);
        arrayListAddToMiddle = v.findViewById(R.id.include7);
        arrayListSearchByValue = v.findViewById(R.id.include10);
        arrayListRemoveBegin = v.findViewById(R.id.include13);
        arrayListRemoveMiddle = v.findViewById(R.id.include16);
        arrayListRemoveEnd = v.findViewById(R.id.include19);

        linkedListAddToBegin = v.findViewById(R.id.include2);
        linkedListAddToEnd = v.findViewById(R.id.include5);
        linkedListAddToMiddle = v.findViewById(R.id.include8);
        linkedListSearchByValue = v.findViewById(R.id.include11);
        linkedListRemoveBegin = v.findViewById(R.id.include14);
        linkedListRemoveMiddle = v.findViewById(R.id.include17);
        linkedListRemoveEnd = v.findViewById(R.id.include20);

        cow_ListAddToBegin = v.findViewById(R.id.include3);
        cow_ListAddToEnd = v.findViewById(R.id.include6);
        cow_ListAddToMiddle = v.findViewById(R.id.include9);
        cow_ListSearchByValue = v.findViewById(R.id.include12);
        cow_ListRemoveBegin = v.findViewById(R.id.include15);
        cow_ListRemoveMiddle = v.findViewById(R.id.include18);
        cow_ListRemoveEnd = v.findViewById(R.id.include21);


        ((TextView) arrayListAddToBegin.findViewById(R.id.title)).setText(ARRAY_LIST);
        ((TextView) arrayListAddToEnd.findViewById(R.id.title)).setText(ARRAY_LIST);
        ((TextView) arrayListAddToMiddle.findViewById(R.id.title)).setText(ARRAY_LIST);
        ((TextView) arrayListSearchByValue.findViewById(R.id.title)).setText(ARRAY_LIST);
        ((TextView) arrayListRemoveBegin.findViewById(R.id.title)).setText(ARRAY_LIST);
        ((TextView) arrayListRemoveMiddle.findViewById(R.id.title)).setText(ARRAY_LIST);
        ((TextView) arrayListRemoveEnd.findViewById(R.id.title)).setText(ARRAY_LIST);

        ((TextView) arrayListAddToBegin.findViewById(R.id.description)).setText(ADD_IN_BEGINING);
        ((TextView) arrayListAddToEnd.findViewById(R.id.description)).setText(ADD_IN_END);
        ((TextView) arrayListAddToMiddle.findViewById(R.id.description)).setText(ADD_IN_MIDDLE);
        ((TextView) arrayListSearchByValue.findViewById(R.id.description)).setText(SEARCH_BY_VALUE);
        ((TextView) arrayListRemoveBegin.findViewById(R.id.description)).setText(REMOVE_IN_BEGINNING);
        ((TextView) arrayListRemoveMiddle.findViewById(R.id.description)).setText(REMOVE_IN_MIDDLE);
        ((TextView) arrayListRemoveEnd.findViewById(R.id.description)).setText(REMOVE_IN_END);

        ((TextView) linkedListAddToBegin.findViewById(R.id.title)).setText(LINKED_LIST);
        ((TextView) linkedListAddToEnd.findViewById(R.id.title)).setText(LINKED_LIST);
        ((TextView) linkedListAddToMiddle.findViewById(R.id.title)).setText(LINKED_LIST);
        ((TextView) linkedListRemoveEnd.findViewById(R.id.title)).setText(LINKED_LIST);
        ((TextView) linkedListRemoveMiddle.findViewById(R.id.title)).setText(LINKED_LIST);
        ((TextView) linkedListRemoveBegin.findViewById(R.id.title)).setText(LINKED_LIST);
        ((TextView) linkedListSearchByValue.findViewById(R.id.title)).setText(LINKED_LIST);

        ((TextView) linkedListAddToBegin.findViewById(R.id.description)).setText(ADD_IN_BEGINING);
        ((TextView) linkedListAddToEnd.findViewById(R.id.description)).setText(ADD_IN_END);
        ((TextView) linkedListAddToMiddle.findViewById(R.id.description)).setText(ADD_IN_MIDDLE);
        ((TextView) linkedListSearchByValue.findViewById(R.id.description)).setText(SEARCH_BY_VALUE);
        ((TextView) linkedListRemoveBegin.findViewById(R.id.description)).setText(REMOVE_IN_BEGINNING);
        ((TextView) linkedListRemoveMiddle.findViewById(R.id.description)).setText(REMOVE_IN_MIDDLE);
        ((TextView) linkedListRemoveEnd.findViewById(R.id.description)).setText(REMOVE_IN_END);

        ((TextView) cow_ListAddToBegin.findViewById(R.id.title)).setText(COPY_ON_WRITE_LIST);
        ((TextView) cow_ListAddToEnd.findViewById(R.id.title)).setText(COPY_ON_WRITE_LIST);
        ((TextView) cow_ListAddToMiddle.findViewById(R.id.title)).setText(COPY_ON_WRITE_LIST);
        ((TextView) cow_ListSearchByValue.findViewById(R.id.title)).setText(COPY_ON_WRITE_LIST);
        ((TextView) cow_ListRemoveBegin.findViewById(R.id.title)).setText(COPY_ON_WRITE_LIST);
        ((TextView) cow_ListRemoveMiddle.findViewById(R.id.title)).setText(COPY_ON_WRITE_LIST);
        ((TextView) cow_ListRemoveEnd.findViewById(R.id.title)).setText(COPY_ON_WRITE_LIST);

        ((TextView) cow_ListAddToBegin.findViewById(R.id.description)).setText(ADD_IN_BEGINING);
        ((TextView) cow_ListAddToEnd.findViewById(R.id.description)).setText(ADD_IN_END);
        ((TextView) cow_ListAddToMiddle.findViewById(R.id.description)).setText(ADD_IN_MIDDLE);
        ((TextView) cow_ListSearchByValue.findViewById(R.id.description)).setText(SEARCH_BY_VALUE);
        ((TextView) cow_ListRemoveBegin.findViewById(R.id.description)).setText(REMOVE_IN_BEGINNING);
        ((TextView) cow_ListRemoveMiddle.findViewById(R.id.description)).setText(REMOVE_IN_MIDDLE);
        ((TextView) cow_ListRemoveEnd.findViewById(R.id.description)).setText(REMOVE_IN_END);
    }

    private void showProgressBar(boolean b) {
        int visible;
        if (b) visible = View.VISIBLE;
        else visible = View.INVISIBLE;

        arrayListAddToBegin.findViewById(R.id.progressBar).setVisibility(visible);
        arrayListAddToEnd.findViewById(R.id.progressBar).setVisibility(visible);
        arrayListAddToMiddle.findViewById(R.id.progressBar).setVisibility(visible);
        arrayListSearchByValue.findViewById(R.id.progressBar).setVisibility(visible);
        arrayListRemoveBegin.findViewById(R.id.progressBar).setVisibility(visible);
        arrayListRemoveMiddle.findViewById(R.id.progressBar).setVisibility(visible);
        arrayListRemoveEnd.findViewById(R.id.progressBar).setVisibility(visible);

        linkedListSearchByValue.findViewById(R.id.progressBar).setVisibility(visible);
        linkedListRemoveBegin.findViewById(R.id.progressBar).setVisibility(visible);
        linkedListRemoveMiddle.findViewById(R.id.progressBar).setVisibility(visible);
        linkedListRemoveEnd.findViewById(R.id.progressBar).setVisibility(visible);
        linkedListAddToMiddle.findViewById(R.id.progressBar).setVisibility(visible);
        linkedListAddToBegin.findViewById(R.id.progressBar).setVisibility(visible);
        linkedListAddToEnd.findViewById(R.id.progressBar).setVisibility(visible);

        cow_ListRemoveEnd.findViewById(R.id.progressBar).setVisibility(visible);
        cow_ListRemoveMiddle.findViewById(R.id.progressBar).setVisibility(visible);
        cow_ListRemoveBegin.findViewById(R.id.progressBar).setVisibility(visible);
        cow_ListSearchByValue.findViewById(R.id.progressBar).setVisibility(visible);
        cow_ListAddToMiddle.findViewById(R.id.progressBar).setVisibility(visible);
        cow_ListAddToEnd.findViewById(R.id.progressBar).setVisibility(visible);
        cow_ListAddToBegin.findViewById(R.id.progressBar).setVisibility(visible);


    }
}

