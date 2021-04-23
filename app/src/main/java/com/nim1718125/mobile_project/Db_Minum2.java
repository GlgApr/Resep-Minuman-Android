package com.nim1718125.mobile_project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class Db_Minum2 extends SQLiteOpenHelper {
    private static int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "db_rmPD1";
    private static final String tb_minum = "tb_minum";
    private static final String tb_minum_id = "id_makanan";
    private static final String tb_minum_image = "image_makanan";
    private static final String tb_minum_nama = "nama_makanan";
    private static final String tb_minum_bahan = "bahan_makanan";
    private static final String tb_minum_tambahan = "tambahan_makanan";
    private static final String tb_minum_harga = "harga_makanan";
    private static final String CREATE_TABLE = "CREATE TABLE "
            + tb_minum + "("
            + tb_minum_id + " INTEGER PRIMARY KEY ,"
            + tb_minum_image + " BLOB,"
            + tb_minum_nama + " TEXT,"
            + tb_minum_bahan + " TEXT, "
            + tb_minum_tambahan + " TEXT, "
            + tb_minum_harga + " TEXT " + ")";

    public Db_Minum2(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public void CreateMinum (Minum2 mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_minum_id, mdNotif.get_id());
        values.put(tb_minum_image, mdNotif.get_image());
        values.put(tb_minum_nama, mdNotif.get_nama());
        values.put(tb_minum_bahan, mdNotif.get_bahan());
        values.put(tb_minum_tambahan, mdNotif.get_tambahan());
        values.put(tb_minum_harga, mdNotif.get_harga());
        db.insert(tb_minum, null, values);
        db.close();
    }

    public List<Minum2> ReadMinum2() {
        List<Minum2> judulModelList = new ArrayList<Minum2>();
        String selectQuery = "SELECT  * FROM " + tb_minum;
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Minum2 mdMinum = new Minum2();
                mdMinum.set_id(cursor.getString(0));
                mdMinum.set_image(cursor.getBlob(1));
                mdMinum.set_nama(cursor.getString(2));
                mdMinum.set_bahan(cursor.getString(3));
                mdMinum.set_tambahan(cursor.getString(4));
                mdMinum.set_harga(cursor.getString(5));

                judulModelList.add(mdMinum);
            }
            while (cursor.moveToNext());
        }
        db.close();
        return judulModelList;
    }

    public int UpdateMinum2 (Minum2 mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_minum_image, mdNotif.get_image());
        values.put(tb_minum_nama, mdNotif.get_nama());
        values.put(tb_minum_bahan, mdNotif.get_bahan());
        values.put(tb_minum_tambahan, mdNotif.get_tambahan());
        values.put(tb_minum_harga, mdNotif.get_harga());
        return db.update(tb_minum, values, tb_minum_id + " = ?",
                new String[] { String.valueOf(mdNotif.get_id())});
    }

    public void DeleteMinum2 (Minum2 mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_minum, tb_minum_id+ " = ?",
                new String[]{String.valueOf(mdNotif.get_id())});
        db.close();
    }
}
