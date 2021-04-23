package com.nim1718125.mobile_project;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainAbout extends AppCompatActivity {
    private RecyclerView recyclerView;
    private CustomListAdapterAbout anggotaAdapter;
    private ArrayList<About> anggotaArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        tambahData();
        recyclerView = findViewById(R.id.recycleView);
        anggotaAdapter = new CustomListAdapterAbout(anggotaArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainAbout.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(anggotaAdapter);
        getSupportActionBar().setTitle("Kelompok 26");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    private void tambahData(){
        anggotaArrayList = new ArrayList<>();
        anggotaArrayList.add(new About("Galang Aprilian Anarki", "1718125", getDrawable(R.drawable.ic_wong)));
        anggotaArrayList.add(new About("Muhammad Luthfi Andhikaputra", "1718122",  getDrawable(R.drawable.ic_wong)));
        anggotaArrayList.add(new About("Erfanda Andrianto", "1718098",  getDrawable(R.drawable.ic_wong)));
        anggotaArrayList.add(new About("Notolian", "",  getDrawable(R.drawable.ic_wong)));
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        int back = item.getItemId();
        if(back == android.R.id.home){
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
