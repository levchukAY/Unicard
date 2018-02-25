package by.unicard.unicard.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

import by.unicard.unicard.R;

public class DiscountsAdapter extends RecyclerView.Adapter<DiscountsAdapter.ViewHolder> {

    private DiscountsCallback discountsCallback;

    public DiscountsAdapter(DiscountsCallback discountsCallback) {
        this.discountsCallback = discountsCallback;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_discount, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.itemView.setOnClickListener((view) ->
                discountsCallback.onDiscountItemClick(position));
    }

    @Override
    public int getItemCount() {
        return 30;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView titleTextView;

        private ViewHolder(View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.title_text_view);
        }
    }

    public interface DiscountsCallback {

        void onDiscountItemClick(int taskId);
    }
}
