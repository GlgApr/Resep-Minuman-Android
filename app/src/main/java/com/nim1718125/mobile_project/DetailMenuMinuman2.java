package com.nim1718125.mobile_project;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class DetailMenuMinuman2 extends AppCompatActivity {
    private Db_Minum2 db;

    private ImageView Eimage;
    private String Sid, Snama, Sbahan, Stambahan, Sharga;
    private TextView Enama, Etambahan, Eharga;
    private byte[] Simage;

    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().setTitle("Detail Menu Minuman");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_menu_minum2);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        db = new Db_Minum2(this);

        Intent i = this.getIntent();
        Sid = i.getStringExtra("Iid");
        Simage = i.getByteArrayExtra("Iimage");
        Snama = i.getStringExtra("Inama");
        Sbahan = i.getStringExtra("Ibahan");
        Stambahan = i.getStringExtra("Itambahan");
        Sharga = i.getStringExtra("Iharga");

        Eimage = (ImageView) findViewById(R.id.img_detailMinum2);
        Enama = (TextView) findViewById(R.id.txt_DetailnamaMinum2);
        Etambahan = (TextView) findViewById(R.id.txt_DetailcontenMinum2);
        Eharga = (TextView) findViewById(R.id.txt_DetailhargaMinum2);

        Bitmap bitmap = BitmapFactory.decodeByteArray(Simage, 0, Simage.length);
        Eimage.setImageBitmap(bitmap);
        Enama.setText(Snama);
        Eharga.setText(Sharga);
        Etambahan.setText(Stambahan);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.item_list_menu, menu);
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
            Intent a = new Intent(DetailMenuMinuman2.this, MainActivity.class);
            startActivity(a);
            return true;
        }
        else if (id == R.id.action_about){
            Intent a = new Intent(DetailMenuMinuman2.this, MainAbout.class);
            startActivity(a);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
