package com.singpaulee.bangundatardanbangunruang;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;

import org.w3c.dom.Text;

public class PilihMateriBelajar extends AppCompatActivity {
    TabHost mTabHost;
    TextView mtv_persegi,mtv_ppanjang,mtv_jgenjang,mtv_bketupat,mtv_layang2,mtv_lingkaran,mtv_segitiga,mtv_trapesium;
    TextView mtv_kubus,mtv_balok,mtv_tabung,mtv_kerucut,mtv_bola;

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
                        .setPositiveButton("OKE",null)
                        .setCancelable(false)
                        .show();
                break;
            case R.id.bantuanmenu:
                new AlertDialog.Builder(this)
                        .setTitle("Panduan Aplikasi")
                        .setMessage("Pada halaman ini menampilkan terdapat nama-nama bangun yang terbagi menjadi Bangun Datar dan Bangun Ruang.\n"+
                        "Jika ingin mempelajari Bangun Datar silahkan klik nama bangun yang berada pada Tab Bangun Datar.\n"+
                        "Jika ingin mempelajari Bangun Ruang silahkan klik nama bangun yang berada pada Tab Bangun Ruang.")
                        .setPositiveButton("OK",null)
                        .setCancelable(false)
                        .show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed(){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstancestate) {
        super.onCreate(savedInstancestate);
        setContentView(R.layout.activity_pilih_materi_belajar);

        //setting toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_pmb);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //inisialisai widget
        mtv_persegi = (TextView) findViewById(R.id.persegi);
        mtv_ppanjang = (TextView) findViewById(R.id.persegi_panjang);
        mtv_segitiga = (TextView) findViewById(R.id.segitiga);
        mtv_bketupat = (TextView) findViewById(R.id.belah_ketupat);
        mtv_jgenjang = (TextView) findViewById(R.id.jajar_genjang);
        mtv_layang2 = (TextView) findViewById(R.id.layang_layang);
        mtv_trapesium = (TextView) findViewById(R.id.trapesium);
        mtv_lingkaran = (TextView) findViewById(R.id.lingkaran);
        mtv_kubus = (TextView) findViewById(R.id.kubus);
        mtv_kerucut = (TextView) findViewById(R.id.kerucut);
        mtv_balok = (TextView) findViewById(R.id.balok);
        mtv_bola = (TextView) findViewById(R.id.bola);
        mtv_tabung = (TextView) findViewById(R.id.tabung);
        mTabHost = (TabHost) findViewById(R.id.tabHost);
        mTabHost.setup();

        //firstTab
        TabHost.TabSpec mTabSpec = mTabHost.newTabSpec("Bangun Datar"); //seperti menginisialisasikan TabSpec dgn variabel
        mTabSpec.setContent(R.id.firstTabx);
        mTabSpec.setIndicator("Bangun Datar"); //Title TabSpec
        mTabHost.addTab(mTabSpec);
        //firstTab
        mTabSpec = mTabHost.newTabSpec("Bangun Ruang");
        mTabSpec.setContent(R.id.secondTab);
        mTabSpec.setIndicator("Bangun Ruang");
        mTabHost.addTab(mTabSpec);

        mTabHost.getTabWidget().getChildAt(mTabHost.getCurrentTab())
                .setBackgroundResource(R.drawable.bgtwx);


        mtv_persegi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(PilihMateriBelajar.this, Persegi.class);
                startActivity(i);
            }
        });
        mtv_ppanjang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(PilihMateriBelajar.this, PersegiPanjang.class);
                startActivity(i);
            }
        });
        mtv_trapesium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(PilihMateriBelajar.this, Trapesium.class);
                startActivity(i);
            }
        });
        mtv_jgenjang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(PilihMateriBelajar.this, JajarGenjang.class);
                startActivity(i);
            }
        });
        mtv_bketupat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(PilihMateriBelajar.this, BelahKetupat.class);
                startActivity(i);
            }
        });
        mtv_segitiga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(PilihMateriBelajar.this, Segitiga.class);
                startActivity(i);
            }
        });
        mtv_lingkaran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(PilihMateriBelajar.this, Lingkaran.class);
                startActivity(i);
            }
        });
        mtv_layang2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(PilihMateriBelajar.this, LayangLayang.class);
                startActivity(i);
            }
        });
        mtv_kubus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(PilihMateriBelajar.this, kubus.class);
                startActivity(i);
            }
        });
        mtv_balok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(PilihMateriBelajar.this, Balok.class);
                startActivity(i);
            }
        });
        mtv_kerucut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(PilihMateriBelajar.this, Kerucut.class);
                startActivity(i);
            }
        });
        mtv_tabung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(PilihMateriBelajar.this, Tabung.class);
                startActivity(i);
            }
        });
        mtv_bola.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(PilihMateriBelajar.this, Bola.class);
                startActivity(i);
            }
        });



        //ubah warna ketika diklik
        mTabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String s) {
                for (int i = 0; i < mTabHost.getTabWidget().getChildCount(); i++) {
                    mTabHost.getTabWidget().getChildAt(i)
                            .setBackgroundColor(Color.parseColor("#FFFFFF"));
                }
                mTabHost.getTabWidget().getChildAt(mTabHost.getCurrentTab())
                        .setBackgroundResource(R.drawable.bgtwx);//tidak diklik
            }
        });
    }
}


