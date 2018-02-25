package by.unicard.unicard.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import by.unicard.unicard.R;
import by.unicard.unicard.ui.adapter.DiscountsAdapter;

public class DiscountsFragment extends Fragment implements DiscountsAdapter.DiscountsCallback{

    @BindView(R.id.discounts_recycler_view)
    RecyclerView discountsRecyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_discounts, container, false);
        ButterKnife.bind(this, view);

        Log.d("qwerty", "onCreateView");
        setDiscountsRecyclerView();

        return view;
    }

    private void setDiscountsRecyclerView() {
        discountsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        DiscountsAdapter discountsAdapter = new DiscountsAdapter(this);
        discountsRecyclerView.setAdapter(discountsAdapter);
    }

    @Override
    public void onDiscountItemClick(int taskId) {

    }
}
