package com.example.persitentbottom.BottomDialogFragment;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.persitentbottom.BottomDialogFragment.Order;
import com.example.persitentbottom.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.List;

public class BottomFragment extends BottomSheetDialogFragment {
    private Order mOrder;
    private static final String KEY_OBJECT = "object";
    private TextView tv_total, tv_address, tv_productname;
    Button btn_huy;

    public static BottomFragment newInstance(Order order) {//truyen du lieu sang (Order)
        BottomFragment bottomFragment = new BottomFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(KEY_OBJECT, order);
        bottomFragment.setArguments(bundle);
        return bottomFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundleReceive = getArguments();
        if (bundleReceive != null) {
            mOrder = (Order) bundleReceive.get(KEY_OBJECT);
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        BottomSheetDialog bottomSheetDialog = (BottomSheetDialog) super.onCreateDialog(savedInstanceState);
        View viewDialog = LayoutInflater.from(getContext()).inflate(R.layout.layout_bottom_sheet_fragment, null);
        bottomSheetDialog.setContentView(viewDialog);
        btn_huy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheetDialog.dismiss();
            }
        });
        initView(viewDialog);
        setData();
        return bottomSheetDialog;
    }

    private void setData() {
        tv_total.setText(mOrder.getPrice());
        tv_address.setText(mOrder.getAddress());
        tv_productname.setText(mOrder.getListProductName());
    }

    private void initView(View view) {
        tv_total = view.findViewById(R.id.tv_price_total);
        tv_address = view.findViewById(R.id.tv_address_delivery);
        tv_productname = view.findViewById(R.id.tv_product_name);
        btn_huy = view.findViewById(R.id.btn_huy);
    }
}
