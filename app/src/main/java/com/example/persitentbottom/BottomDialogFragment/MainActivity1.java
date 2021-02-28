package com.example.persitentbottom.BottomDialogFragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.persitentbottom.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        Button btn_openFragment=findViewById(R.id.btn_open_fragment);
        btn_openFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickOpenFragment();
            }
        });
    }

    private void clickOpenFragment() {
        List<Product> listProduct=new ArrayList<>();
        listProduct.add(new Product("Bim Bim"));
        listProduct.add(new Product("Bim Bim Han Qioc"));
        listProduct.add(new Product("Tra Sua"));


        Order order=new Order("500 VND",listProduct,"Ha Noi_Viet Nam");
        BottomFragment bottomFragment=BottomFragment.newInstance(order);
        bottomFragment.show(getSupportFragmentManager(),bottomFragment.getTag());
        bottomFragment.setCancelable(false);

    }
}