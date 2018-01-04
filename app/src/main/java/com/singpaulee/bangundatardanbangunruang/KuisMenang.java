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

public class KuisMenang extends AppCompatActivity {
    TextView mtvpersenm, mainlagimm, belajardulumm, gantilevelmm;
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
                        .setMessage("Yeeee Menaaaang.\n"+
                            "Ingin bermain lagi? tekan saja tombol MAIN LAGI.\n"+
                            "Ganti level? tinggal tekan tombol GANTI LEVEL saja.\n"+
                            "Jika mau belajar lagi tekan tombol BELAJAR DULU")
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
        setContentView(R.layout.activity_kuis_menang);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_menang);
        setSupportActionBar(toolbar);

        mtvpersenm = (TextView) findViewById(R.id.tvpersenm);
        nampung = getIntent().getStringExtra("level");

        if(nampung.equals("1")){
            mtvpersenm.setText(getIntent().getStringExtra("skorakhir"));
        }else{
            mtvpersenm.setText(getIntent().getStringExtra("skorakhir2"));
        }

        mainlagimm = (TextView) findViewById(R.id.mainlagim);
        belajardulumm = (TextView) findViewById(R.id.belajardulum);
        gantilevelmm = (TextView) findViewById(R.id.gantilevelm);

        mainlagimm.setOnClickListener(new View.OnClickListener() {
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

        belajardulumm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), PilihMateriBelajar.class);
                startActivity(i);
            }
        });

        gantilevelmm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Kuis.class);
                startActivity(i);
            }
        });
    }
}
