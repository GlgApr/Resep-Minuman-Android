package com.nim1718125.mobile_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MenuMinum2 extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView mListView;
    private CustomListAdapterMinum2 adapter_off;
    private Db_Minum2 db;
    private List<Minum2> ListMinum2 = new ArrayList<Minum2>();

    public void btn_adddata2 (View view){
        Intent a = new Intent(MenuMinum2.this, AddMinum2.class);
        startActivity(a);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_minum2);
        getSupportActionBar().setTitle("List Menu Minuman");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        db = new Db_Minum2(this);

        adapter_off = new CustomListAdapterMinum2(this, ListMinum2);
        mListView = (ListView) findViewById(R.id.list_minuman2);
        mListView.setAdapter(adapter_off);
        mListView.setOnItemClickListener(this);
        mListView.setClickable(true);
        ListMinum2.clear();

        List<Minum2> contacts = db.ReadMinum2();
        for (Minum2 cn : contacts) {
            Minum2 judulModel = new Minum2();
            judulModel.set_id(cn.get_id());
            judulModel.set_image(cn.get_image());
            judulModel.set_nama(cn.get_nama());
            judulModel.set_bahan(cn.get_bahan());
            judulModel.set_tambahan(cn.get_tambahan());
            judulModel.set_harga(cn.get_harga());
            ListMinum2.add(judulModel);

            if ((ListMinum2.isEmpty()))
                Toast.makeText(MenuMinum2.this, "Tidak ada data", Toast.LENGTH_SHORT).show();
            else {

            }
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
        Object o = mListView.getItemAtPosition(i);
        Minum2 obj_itemDetails = (Minum2) o;

        String Sid = obj_itemDetails.get_id();
        byte[] Simage = obj_itemDetails.get_image();
        String Snama = obj_itemDetails.get_nama();
        String Sbahan = obj_itemDetails.get_bahan();
        String Stambahan = obj_itemDetails.get_tambahan();
        String Sharga = obj_itemDetails.get_harga();

        Intent goUpdate = new Intent(MenuMinum2.this, EditMinum2.class);
        goUpdate.putExtra("Iid", Sid);
        goUpdate.putExtra("Iimage", Simage);
        goUpdate.putExtra("Inama", Snama);
        goUpdate.putExtra("Ibahan", Sbahan);
        goUpdate.putExtra("Itambahan", Stambahan);
        goUpdate.putExtra("Iharga", Sharga);
        startActivity(goUpdate);     }

    @Override
    protected void onResume() {
        super.onResume();
        ListMinum2.clear();
        mListView.setAdapter(adapter_off);

        List<Minum2> contacts = db.ReadMinum2();
        for (Minum2 cn : contacts) {
            Minum2 judulModel = new Minum2();
            judulModel.set_id(cn.get_id());
            judulModel.set_image(cn.get_image());
            judulModel.set_nama(cn.get_nama());
            judulModel.set_bahan(cn.get_bahan());
            judulModel.set_tambahan(cn.get_tambahan());
            judulModel.set_harga(cn.get_harga());
            ListMinum2.add(judulModel);

            if ((ListMinum2.isEmpty()))
                Toast.makeText(MenuMinum2.this, "Tidak ada data", Toast.LENGTH_SHORT).show();
            else {

            }
        }

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.item_list_admin, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        int back = item.getItemId();
        if(back == android.R.id.home){
            this.finish();
        }

        else if (id == R.id.action_home){
            Intent a = new Intent(MenuMinum2.this, HomeAdmin.class);
            startActivity(a);
            return true;
        }
        else if (id == R.id.action_logout){
            Intent a = new Intent(MenuMinum2.this, MainActivity.class);
            startActivity(a);
            return true;
        }
        else if (id == R.id.action_about){
            Intent a = new Intent(MenuMinum2.this, MainAbout.class);
            startActivity(a);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
