package com.example.persitentbottom.BottomSheetRecycleView;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.persitentbottom.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    Button btn_open;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btn_open = findViewById(R.id.btn_open_rcv_list);
        btn_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickOpen();
            }
        });
    }

    private void clickOpen() {
        List<Item> mList = new ArrayList<>();
        mList.add(new Item("Item 1"));
        mList.add(new Item("Item 2"));
        mList.add(new Item("Item 3"));
        mList.add(new Item("Item 4"));
        BottomRecyclerView bottomRecyclerView = new BottomRecyclerView(mList, new IClickListener() {
            @Override
            public void clickItem(Item item) {
                Toast.makeText(MainActivity2.this, item.getName(), Toast.LENGTH_LONG).show();
            }
        });
        bottomRecyclerView.show(getSupportFragmentManager(), bottomRecyclerView.getTag());
    }
}