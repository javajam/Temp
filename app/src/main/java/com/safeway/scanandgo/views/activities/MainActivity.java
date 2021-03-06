package com.safeway.scanandgo.views.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.safeway.scanandgo.R;
import com.safeway.scanandgo.views.fragments.PayBottomDialogFragment;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    public Toolbar mToolbar;

    @BindView(R.id.toolbar_title)
    public TextView mToolbarTitle;

    @BindView(R.id.toolbar_close)
    public ImageView mClose;

    @BindString(R.string.app_name)
    public String mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        createToolbar();
    }

    private void createToolbar() {
        setSupportActionBar(mToolbar);
        mToolbarTitle.setText(mTitle);
        mClose.setVisibility(View.GONE);
    }

    @OnClick(R.id.btn_bottom_sheet_dialog)
    void onBottomSheetBtnClicked() {
        final PayBottomDialogFragment payBottomDialogFragment = new PayBottomDialogFragment();
        payBottomDialogFragment.show(getSupportFragmentManager(), "Pay");
    }
}
