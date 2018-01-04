package com.singpaulee.bangundatardanbangunruang;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class KuisKalah extends AppCompatActivity {
    TextView mtvpersen,mainlagikk,belajardulukk,gantilevelkk;
    String nampung;

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
                        .setMessage("Yaaaahh kalaaaah. Jangan sedih.\n"+
                                "Pengguna dapat mengulangi lagi dengan menekan tombol MAIN LAGI.\n"+
                                "Jika ingin mengubah level silah tekan tombol GANTI LEVEL"+
                                "Atau ingin belajar dulu? tinggal tekan saja tombol BELAJAR DULU")
                        .setPositiveButton("MENGERTI",null)
                        .setCancelable(false)
                        .show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onBackPressed(){
        Toast.makeText(getApplicationContext(), "Tidak bisa kembali ke kuis. Silahkan tekan tombol yang telah disediakan", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuis_kalah);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_kalah);
        setSupportActionBar(toolbar);

        mtvpersen = (TextView) findViewById(R.id.tvpersen);
        nampung = getIntent().getStringExtra("level");

        if(nampung.equals("1")){
            mtvpersen.setText(getIntent().getStringExtra("skorakhir"));
        }else{
            mtvpersen.setText(getIntent().getStringExtra("skorakhir2"));
        }

        mainlagikk = (TextView) findViewById(R.id.mainlagik);
        belajardulukk = (TextView) findViewById(R.id.belajarduluk);
        gantilevelkk = (TextView) findViewById(R.id.gantilevelk);

        mainlagikk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(nampung.equals("1")){
                    Intent i = new Intent(getApplicationContext(), LevelMudah.class);
                    startActivity(i);
                }else{
                    Intent ii = new Intent(getApplicationContext(), LevelSulit.class);
                    startActivity(ii);
                }
            }
        });

        belajardulukk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), PilihMateriBelajar.class);
                startActivity(i);
            }
        });

        gantilevelkk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Kuis.class);
                i.addCategory(Intent.CATEGORY_HOME);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
            }
        });

    }
}
