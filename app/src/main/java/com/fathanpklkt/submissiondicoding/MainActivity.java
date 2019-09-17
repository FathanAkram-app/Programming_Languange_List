package com.fathanpklkt.submissiondicoding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvLang;
    private ArrayList<Lang> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvLang = findViewById(R.id.rv_lang);
        rvLang.setHasFixedSize(true);


        list.addAll(LangData.getListData());
        showRecyclerList();

    }

    private void showRecyclerList() {
        LinearLayoutManager llm = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        rvLang.setLayoutManager(llm);
        LangAdapter laa = new LangAdapter(list);
        rvLang.setAdapter(laa);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);

    }

    private void setMode(int selectedMode) {
        switch (selectedMode) {
            case R.id.about_action:
                Intent moveIntent = new Intent(MainActivity.this, ProfileAbout.class);
                startActivity(moveIntent);
                break;
            default:
                break;
        }
    }
}
