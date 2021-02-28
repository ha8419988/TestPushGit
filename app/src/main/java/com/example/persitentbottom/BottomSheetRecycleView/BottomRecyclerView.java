package com.example.persitentbottom.BottomSheetRecycleView;


import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.persitentbottom.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.List;

public class BottomRecyclerView extends BottomSheetDialogFragment {
    private List<Item> mList;
    private IClickListener iClickListener;

    public BottomRecyclerView(List<Item> mList, IClickListener iClickListener) {
        this.mList = mList;
        this.iClickListener = iClickListener;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        BottomSheetDialog bottomSheetDialog= (BottomSheetDialog) super.onCreateDialog(savedInstanceState);
        View view= LayoutInflater.from(getContext()).inflate(R.layout.layout_bottom_recyclerview,null);
        bottomSheetDialog.setContentView(view);

        RecyclerView rcv_item=view.findViewById(R.id.rcv_list_item);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        rcv_item.setLayoutManager(linearLayoutManager);

        ItemAdapter itemAdapter=new ItemAdapter(mList, new IClickListener() {
            @Override
            public void clickItem(Item item) {
                iClickListener.clickItem(item);
            }
        });
        rcv_item.setAdapter(itemAdapter);
        RecyclerView.ItemDecoration itemDecoration=new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL);
        rcv_item.addItemDecoration(itemDecoration);
        return  bottomSheetDialog;
    }
}
