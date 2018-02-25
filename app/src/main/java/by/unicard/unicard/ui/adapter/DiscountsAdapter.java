package by.unicard.unicard.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import by.unicard.unicard.R;

public class DiscountsAdapter extends RecyclerView.Adapter<DiscountsAdapter.ViewHolder> {

    private DiscountsCallback discountsCallback;

    public DiscountsAdapter(DiscountsCallback discountsCallback) {
        this.discountsCallback = discountsCallback;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        int[] resources = {R.layout.item_discount_1,
                R.layout.item_discount_2,
                R.layout.item_discount_3,
                R.layout.item_discount_4,
                R.layout.item_discount_5,
                R.layout.item_discount_6,
                R.layout.item_discount_7,
                R.layout.item_discount_8};
        View view = LayoutInflater.from(parent.getContext())
                .inflate(resources[viewType], parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.itemView.setOnClickListener((view) ->
                discountsCallback.onDiscountItemClick(position));
    }

    @Override
    public int getItemViewType(int position) {
        return position % 8;
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
