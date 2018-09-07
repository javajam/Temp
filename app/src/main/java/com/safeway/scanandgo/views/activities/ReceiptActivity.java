package com.safeway.scanandgo.views.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.safeway.scanandgo.R;
import com.safeway.scanandgo.services.models.Item;
import com.safeway.scanandgo.utils.DateUtils;
import com.safeway.scanandgo.views.adapters.ItemsAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ReceiptActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    public Toolbar mToolbar;

    @BindView(R.id.toolbar_title)
    public TextView mToolbarTitle;

    @BindView(R.id.timestamp)
    public TextView mTimestamp;

    @BindView(R.id.edible_items_recycler_view)
    public RecyclerView mEdibleItemsRV;

    @BindView(R.id.nonedible_items_recycler_view)
    public RecyclerView mNonEdibleItemsRV;

    @BindString(R.string.receipt)
    public String mTitle;

    private RecyclerView.Adapter mItemsAdapter;
    private RecyclerView.Adapter mNonEdibleItemsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipt);

        ButterKnife.bind(this);

        initViews();
    }

    private void initViews() {
        createToolbar();
        createViews();
    }

    private void createToolbar() {
        setSupportActionBar(mToolbar);
        mToolbarTitle.setText(mTitle);
    }

    private void createViews() {
        mTimestamp.setText(DateUtils.getStandardDate());

        mEdibleItemsRV.setLayoutManager(new LinearLayoutManager(this));
        mNonEdibleItemsRV.setLayoutManager(new LinearLayoutManager(this));

        mItemsAdapter = new ItemsAdapter(getItemsList());
        mEdibleItemsRV.setAdapter(mItemsAdapter);

        mNonEdibleItemsAdapter = new ItemsAdapter(getNonEdibleItemsList());
        mNonEdibleItemsRV.setAdapter(mNonEdibleItemsAdapter);
    }

    private List<Item> getItemsList() {
        final List<Item> items = new ArrayList<>();
        final Item item = new Item();
        item.setPosDescription("Soft Drinks");
        item.setSellMultiple(4);
        item.setSellPrice(5.99);
        items.add(item);

        final Item item2 = new Item();
        item2.setPosDescription("Bananas");
        item2.setSellMultiple(7);
        item2.setSellPrice(0.99);
        items.add(item2);

        final Item item3 = new Item();
        item3.setPosDescription("Candy Bar");
        item3.setSellMultiple(1);
        item3.setSellPrice(1.99);
        items.add(item3);

        final Item item4 = new Item();
        item4.setPosDescription("Lunchables");
        item4.setSellMultiple(5);
        item4.setSellPrice(10.08);
        items.add(item4);

        final Item item5 = new Item();
        item5.setPosDescription("Ribeye Steak");
        item5.setSellMultiple(1);
        item5.setSellPrice(12.97);
        items.add(item5);

        return items;
    }

    private List<Item> getNonEdibleItemsList() {
        final List<Item> items = new ArrayList<>();
        final Item item = new Item();
        item.setPosDescription("Men's Shaving Cream");
        item.setSellMultiple(1);
        item.setSellPrice(3.99);
        items.add(item);

        final Item item2 = new Item();
        item2.setPosDescription("Clorox Bleach");
        item2.setSellMultiple(1);
        item2.setSellPrice(6.99);
        items.add(item2);

        final Item item3 = new Item();
        item3.setPosDescription("Paper Towels");
        item3.setSellMultiple(4);
        item3.setSellPrice(8.25);
        items.add(item3);

        return items;
    }

    @SuppressWarnings("unused")
    @OnClick(R.id.toolbar_close)
    public void onCloseClicked() {
        onBackPressed();
    }
}
