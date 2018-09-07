package com.safeway.scanandgo.views.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.safeway.scanandgo.R;
import com.safeway.scanandgo.services.models.Item;
import com.safeway.scanandgo.utils.CollectionUtils;

import java.util.List;
import java.util.Locale;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ItemsAdapter extends RecyclerView.Adapter {

    private List<Item> itemsList;

    public static class ItemsViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.item_quantity)
        protected TextView mItemQuantity;
        @BindView(R.id.receipt_item_desc)
        protected TextView mItemDesc;
        @BindView(R.id.item_price)
        protected TextView mItemPrice;
        @BindView(R.id.regular_price)
        protected TextView mRegPrice;
        @BindView(R.id.club_savings_discount)
        protected TextView mClubSavingsDiscount;
        @BindView(R.id.j4u_discount)
        protected TextView mJ4uDiscount;

        @BindString(R.string.dollar_price)
        protected String mDollarPrice;
        @BindString(R.string.dollar_discount)
        protected String mDollarDiscount;
        @BindString(R.string.qty)
        protected String mQuantity;

        public ItemsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public ItemsAdapter(final List<Item> itemsList) {
        this.itemsList = itemsList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_details, parent, false);
        return new ItemsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        bindViewHolder((ItemsViewHolder) holder, itemsList.get(position));
    }

    private void bindViewHolder(ItemsViewHolder holder, Item item) {
        holder.mItemDesc.setText(item.getPosDescription());
        holder.mItemPrice.setText(String.format(Locale.US, holder.mDollarPrice, item.getSellPrice()));
        holder.mRegPrice.setText(String.format(Locale.US, holder.mDollarPrice, item.getSellPrice()));

        final int qty = item.getSellMultiple();
        if (qty > 1) {
            holder.mItemQuantity.setText(String.format(Locale.US, holder.mQuantity, qty));
            holder.mItemQuantity.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return CollectionUtils.size(itemsList);
    }
}
