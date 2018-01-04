package com.singpaulee.bangundatardanbangunruang;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class LayangLayang extends AppCompatActivity {
    LinearLayout mline_sub,mline_rum,mline_con;
    TextView mtv_sub, mtv_rum, mtv_con;
    boolean showingFirst = true;
    boolean showingrumus = true;
    boolean showingcontoh = true;

    //setting menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menuapa, menu);
        return true;
    }

    //setting ketika menu diklik
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch(id){
            case R.id.keluarmenu:
                new AlertDialog.Builder(this)
                        .setMessage("Yakin keluar aplikasi?")
                        .setPositiveButton("YA", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                intent.addCategory(Intent.CATEGORY_HOME);
                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                intent.putExtra("EXIT",true);
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton("TIDAK", null)
                        .setCancelable(false)
                        .show();
                break;
            case R.id.aboutApp:
                new AlertDialog.Builder(this)
                        .setTitle("Tentang Aplikasi")
                        .setMessage("BangMat adalah sebuah aplikasi berbasis android yang berisi materi pembelajaran matematika tentang Bangun Datar dan Bangun Ruang.\n"+
                                "Pada setiap bangun berisi materi tentang sifat, rumus juga disertai contoh soal untuk mempermudah proses belajar tentang bangun tersebut.\n"+
                                "Selain berisi materi, aplikasi ini juga berisi kuis untuk mengasah kemampuan dalam belajar tentang bangun datar dan bangun ruang.\n"+
                                "Aplikasi ini sangat cocok untuk anak dalam belajar sekaligus mengasah kemampuan tentang bangun datar dan bangun ruang.")
                        .setPositiveButton("OK",null)
                        .setCancelable(false)
                        .show();
                break;
            case R.id.bantuanmenu:
                new AlertDialog.Builder(this)
                        .setTitle("Panduan Aplikasi")
                        .setMessage("Pada halaman ini disediakan materi-materi tentang LAYANG-LAYANG.\n"+
                                "Pengguna dapat membuka dan menutupnya kembali dengan menekan sub judul di bawah gambar bangun")
                        .setPositiveButton("MENGERTI",null)
                        .setCancelable(false)
                        .show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onBackPressed(){
        Intent intent = new Intent(getApplicationContext(), PilihMateriBelajar.class);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layang_layang);

        mtv_sub = (TextView) findViewById(R.id.tv_subly);
        mline_sub = (LinearLayout) findViewById(R.id.line_subly);
        mtv_rum = (TextView) findViewById(R.id.tv_rumly);
        mline_rum = (LinearLayout) findViewById(R.id.line_rumly);
        mtv_con = (TextView) findViewById(R.id.tv_conly);
        mline_con = (LinearLayout) findViewById(R.id.line_conly);

        //setting toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_ly);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        mtv_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lays();
            }
        });
        mtv_rum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layr();
            }
        });
        mtv_con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layc();
            }
        });
    }

    private void lays(){
        ViewGroup.LayoutParams params3 = mline_sub.getLayoutParams();
        if (showingFirst==true){
            Drawable draw2 = getResources().getDrawable(R.drawable.bawah2);
            mtv_sub.setCompoundDrawablesWithIntrinsicBounds(draw2, null, null, null);
            params3.height = 400;
            mline_sub.setLayoutParams(params3);
            showingFirst= false;
        }else{
            Drawable draw = getResources().getDrawable(R.drawable.atas2);
            mtv_sub.setCompoundDrawablesWithIntrinsicBounds(draw, null, null, null);
            params3.height = 110;
            mline_sub.setLayoutParams(params3);
            showingFirst =true;
        }
    }
    private void layr(){
        ViewGroup.LayoutParams params = mline_rum.getLayoutParams();
        if (showingrumus==true){
            Drawable draw2 = getResources().getDrawable(R.drawable.bawah2);
            mtv_rum.setCompoundDrawablesWithIntrinsicBounds(draw2, null, null, null);
            params.height = 400;
            mline_rum.setLayoutParams(params);
            showingrumus= false;
        }else{
            Drawable draw = getResources().getDrawable(R.drawable.atas2);
            mtv_rum.setCompoundDrawablesWithIntrinsicBounds(draw, null, null, null);
            params.height = 110;
            mline_rum.setLayoutParams(params);
            showingrumus =true;
        }
    }
    private void layc(){
        ViewGroup.LayoutParams params2 = mline_con.getLayoutParams();
        if (showingcontoh==true){
            Drawable draw2 = getResources().getDrawable(R.drawable.bawah2);
            mtv_con.setCompoundDrawablesWithIntrinsicBounds(draw2, null, null, null);
            params2.height = 400;
            mline_con.setLayoutParams(params2);
            showingcontoh= false;
        }else{
            Drawable draw = getResources().getDrawable(R.drawable.atas2);
            mtv_con.setCompoundDrawablesWithIntrinsicBounds(draw, null, null, null);
            params2.height = 110;
            mline_con.setLayoutParams(params2);
            showingcontoh =true;
        }
    }
}
