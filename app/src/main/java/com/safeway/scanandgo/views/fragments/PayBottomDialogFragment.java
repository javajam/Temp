package com.safeway.scanandgo.views.fragments;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.safeway.scanandgo.R;
import com.safeway.scanandgo.services.models.CartResponse;
import com.safeway.scanandgo.viewmodels.CheckoutViewModel;
import com.safeway.scanandgo.views.activities.ConfirmationActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class PayBottomDialogFragment extends BottomSheetDialogFragment{

    @BindView(R.id.payment_method)
    public ViewGroup mPaymenMethodGroup;

    @BindView(R.id.choose_payment_method)
    public ViewGroup mChoosePaymentMethodGroup;

    @BindView(R.id.cta_pay)
    public Button mCtaPayBtn;

    @BindView(R.id.cta_pay_disabled)
    public View mCtaPayDisabled;

    private Unbinder mUnbinder;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_pay_bottom_dialog, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mUnbinder = ButterKnife.bind(this, view);

        mCtaPayDisabled.setVisibility(View.VISIBLE);

        final CheckoutViewModel model = ViewModelProviders.of(this).get(CheckoutViewModel.class);
        model.getCart().observe(this, new Observer<CartResponse>() {
            @Override
            public void onChanged(@Nullable CartResponse cartResponse) {
                System.err.println("response: " + cartResponse);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mUnbinder != null) {
            mUnbinder.unbind();
        }
    }

    @OnClick(R.id.dialog_close)
    void onDialogClose() {
        dismiss();
    }

    @SuppressWarnings("unused")
    @OnClick(R.id.cta_add)
    void onCtaAddClick() {
        togglePaymentMethods(false);
    }

    @SuppressWarnings("unused")
    @OnClick(R.id.pm_change)
    void onPmChangeClick() {
        togglePaymentMethods(true);
    }

    @OnClick(R.id.cta_pay)
    void onCtaPay() {
        handleCtaPay();
    }

    private void handleCtaPay() {
        final Intent intent = new Intent(getActivity(), ConfirmationActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        dismiss();
    }

    private void togglePaymentMethods(final boolean hasPaymentMethod) {
        mChoosePaymentMethodGroup.setVisibility(hasPaymentMethod ? View.VISIBLE : View.GONE);
        mPaymenMethodGroup.setVisibility(hasPaymentMethod ? View.GONE : View.VISIBLE);
        mCtaPayBtn.setVisibility(hasPaymentMethod ? View.GONE : View.VISIBLE);
        mCtaPayDisabled.setVisibility(hasPaymentMethod ? View.VISIBLE : View.GONE);
    }
}
