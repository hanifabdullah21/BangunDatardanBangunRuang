package com.singpaulee.bangundatardanbangunruang;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class Kuis extends AppCompatActivity {
    Spinner mspn_level;
    Button mbtn_mulai;
    ImageView mimg_kuis;

    String[] lvl = new String[]{"~pilih level~","mudah","sulit"};

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
                        .setMessage("Pada halaman ini merupakan halaman dimana pengguna harus memilih level sebelum memulai kuis.\n"+
                                "Bagaimana caranya? Silahkan tekan ~pilih level~ kemudian pilih mudah atau sulit.\n"+
                                "Kemudian tekan tombol Mulai untuk memulai kuis.\n"+
                                "Semoga Beruntung ^_^")
                        .setPositiveButton("MENGERTI",null)
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuis);

        mspn_level = (Spinner) findViewById(R.id.spn_level);
        mbtn_mulai = (Button) findViewById(R.id.btn_mulai);
        mimg_kuis = (ImageView) findViewById(R.id.img_kuis);

        //setting toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_kuis);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //setting spinner
        ArrayAdapter<String> request = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, lvl);
        request.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mspn_level.setAdapter(request);

        //setImage();
        mbtn_mulai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cekLevel();
            }
        });
    }

    public void cekLevel(){
        if (mspn_level.getSelectedItem().toString().equals("mudah")){
            Intent i = new Intent(Kuis.this, LevelMudah.class);
            startActivity(i);
        }else if(mspn_level.getSelectedItem().toString().equals("sulit")){
            Intent i = new Intent(Kuis.this, LevelSulit.class);
            startActivity(i);
        }else{
            new AlertDialog.Builder(this)
                    .setMessage("Silahkan pilih level dulu")
                    .setPositiveButton("OK",null)
                    .show();
        }
    }

    public void setImage(){
        Resources res = getResources();
        String x = "bangun_datar";
        int resID = res.getIdentifier(x, "drawable", getPackageName());
        Drawable drawable = res.getDrawable(resID);
        mimg_kuis.setImageDrawable(drawable);
    }
}
