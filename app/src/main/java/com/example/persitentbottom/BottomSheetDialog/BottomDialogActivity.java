package com.example.persitentbottom.BottomSheetDialog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.persitentbottom.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class BottomDialogActivity extends AppCompatActivity {
    Button btn_show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_dialog2);
        btn_show = findViewById(R.id.btn_show);
        btn_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickOpenBottomSheetDialog();
            }
        });
    }

    private void clickOpenBottomSheetDialog() {
        View view = getLayoutInflater().inflate(R.layout.activity_bottom_dialog, null);
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(view);
        bottomSheetDialog.show();
        bottomSheetDialog.setCancelable(false);

        Button btn_Cancel = view.findViewById(R.id.btn_cancel);
        Button btn_Payment = view.findViewById(R.id.btn_payment);
        btn_Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheetDialog.dismiss();
            }
        });
    }
}