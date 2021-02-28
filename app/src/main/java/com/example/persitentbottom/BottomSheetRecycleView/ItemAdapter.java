package com.example.persitentbottom.BottomSheetRecycleView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.persitentbottom.R;

import java.util.List;


public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {
    private List<Item> mList;
    private IClickListener iClickListener;

    public ItemAdapter(List<Item> mList, IClickListener iClickListener) {
        this.mList = mList;
        this.iClickListener = iClickListener;
    }


    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Item item = mList.get(position);
        if (item==null){
            return;
        }
        holder.tv_item.setText(item.getName());
        holder.tv_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iClickListener.clickItem(item);
            }
        });


    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_item;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_item = itemView.findViewById(R.id.tv_item);

        }
    }
}
