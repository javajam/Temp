package com.safeway.scanandgo.views.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.safeway.scanandgo.R;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ConfirmationActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    public Toolbar mToolbar;

    @BindView(R.id.toolbar_title)
    public TextView mToolbarTitle;

    @BindView(R.id.cta_view_receipt)
    public Button mViewReceiptBtn;

    @BindString(R.string.confirmation)
    public String mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);

        ButterKnife.bind(this);

        initViews();
    }

    private void initViews() {
        createToolbar();
        mViewReceiptBtn.setVisibility(View.VISIBLE);
    }

    private void createToolbar() {
        setSupportActionBar(mToolbar);
        mToolbarTitle.setText(mTitle);
    }

    @SuppressWarnings("unused")
    @OnClick(R.id.cta_view_receipt)
    public void onCtaViewReceiptClicked() {
        final Intent intent = new Intent(this, ReceiptActivity.class);
        startActivity(intent);
    }

    @SuppressWarnings("unused")
    @OnClick(R.id.toolbar_close)
    public void onCloseClicked() {
        onBackPressed();
    }
}
