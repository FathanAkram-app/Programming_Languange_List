package com.fathanpklkt.submissiondicoding;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class LangDetail extends AppCompatActivity {

    public TextView textTitle,textDetail;
    public ImageView viewMage;
    public Button btnYes,btnNo;

    protected void onCreate(Bundle SavedInstanceState) {
        super.onCreate(SavedInstanceState);
        setContentView(R.layout.detail_page);
        textTitle = findViewById(R.id.tv_lang_title);
        textDetail = findViewById(R.id.tv_detail);
        viewMage = findViewById(R.id.imgphoto);
        btnYes = findViewById(R.id.btn_yes);
        btnNo = findViewById(R.id.btn_no);
        Lang extra = getIntent().getParcelableExtra("objek");
        textTitle.setText(extra.getName());
        textDetail.setText(extra.getDetail());
        viewMage.setImageResource(extra.getPhoto());

    }

}
