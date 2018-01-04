package com.singpaulee.bangundatardanbangunruang;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.annotation.IdRes;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Random;

import static junit.runner.Version.id;

public class LevelMudah extends AppCompatActivity {
    BankSoal mBank = new BankSoal();
    TextView mtv_soal;
    ImageView mnyawa1,mnyawa2,mnyawa3;
    RadioButton mrba, mrbb, mrbc;
    Button mbtn_next;
    RadioGroup mrg;
    String jawaban;
    ProgressBar one,two;
    double skor=0;
    double benar;
    TextView mtv;
    int ambil;
    int z=0;
    int nyawa=3;

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
                        .setMessage("Kuis level mudah sedang dimainkan.\n"+
                                "Pada level ini disediakan soal berjumlah 10 buah secara acak.\n"+
                                "Pengguna harus menjawab soal dengan cara menekan salah satu jawaban yang telah disediakan kemudian tekan tombol LANJUT untuk menuju ke soal berikutnya.\n+" +
                                "Pengguna dapat memenangkan kuis dengan menyelesaikan soal dan menjawab 8 soal dengan benar.\n"+
                                "Semoga beruntung ^_^")
                        .setPositiveButton("MENGERTI",null)
                        .setCancelable(false)
                        .show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onBackPressed(){
        Toast.makeText(getApplicationContext(), "Tidak bisa kembali ke kuis. Silahkan selesaikan terlebih dahulu", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_mudah);

        mtv_soal= (TextView) findViewById(R.id.tv_soal);
        mrba = (RadioButton) findViewById(R.id.rba);
        mrbb = (RadioButton) findViewById(R.id.rbb);
        mrbc = (RadioButton) findViewById(R.id.rbc);
        mbtn_next = (Button) findViewById(R.id.btn_next);
        mrg = (RadioGroup) findViewById(R.id.rg_jawaban);
        mnyawa1 = (ImageView) findViewById(R.id.nyawa0);
        mnyawa2 = (ImageView) findViewById(R.id.nyawa2);
        mnyawa3 = (ImageView) findViewById(R.id.nyawa3);
        one = (ProgressBar) findViewById(R.id.pbhrizontal);
        two = (ProgressBar) findViewById(R.id.pbhrizontal2);
        mtv = (TextView) findViewById(R.id.tv);

        //setting toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_mudah);
        setSupportActionBar(toolbar);

        update();

        mbtn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cekJawaban();
            }
        });


    }

    public void update(){
        mrg.clearCheck();
        if (z == 10){
            skor = (benar/10)*100;
            String skorx = String.valueOf(skor)+"%";
            String easy="1";
            Intent i = new Intent(LevelMudah.this, KuisMenang.class);
            i.putExtra("skorakhir",skorx);
            i.putExtra("skorskor", skor);
            i.putExtra("level",easy);
            startActivity(i);
        }else{
            Random random = new Random();
            ambil = random.nextInt(25);
            mtv_soal.setText(mBank.getSoal(ambil));
            mrba.setText(mBank.getPilihanJawaban1(ambil));
            mrbb.setText(mBank.getPilihanJawaban2(ambil));
            mrbc.setText(mBank.getPilihanJawaban3(ambil));
            jawaban = mBank.getJawaban(ambil);
            one.setProgress(z);
            two.setProgress(z+1);
        }
        z++;
    }

    public void cekJawaban(){
        if (mrba.isChecked()){
            if(mrba.getText().toString().equals(jawaban)){
                benarloh();
            }else{
                Toast.makeText(getApplicationContext(), "Anda salah", Toast.LENGTH_SHORT).show();
                salah();
                update();
            }
        }
        if (mrbb.isChecked()){
            if(mrbb.getText().toString().equals(jawaban)){
               benarloh();
            }else{
                Toast.makeText(getApplicationContext(), "Anda salah", Toast.LENGTH_SHORT).show();
                salah();
                update();
            }
        }
        if (mrbc.isChecked()){
            if(mrbc.getText().toString().equals(jawaban)){
                benarloh();
            }else{
                Toast.makeText(getApplicationContext(), "Anda salah", Toast.LENGTH_SHORT).show();
                salah();
                update();
            }
        }
    }
    public void benarloh(){
        benar=benar+1;
        Toast.makeText(getApplicationContext(), "Anda benar", Toast.LENGTH_SHORT).show();
        update();
    }

    public void salah(){
        nyawa=nyawa-1;
        benar=benar+0;
        Drawable image1 = getResources().getDrawable(R.drawable.nyawamati);
        if(nyawa==2){
            mnyawa1.setImageDrawable(image1);
        }else if(nyawa== 1){
            mnyawa1.setImageDrawable(image1);
            mnyawa2.setImageDrawable(image1);

//        }else if(nyawa==1){
//            mnyawa1.setImageDrawable(image1);
//            mnyawa2.setImageDrawable(image1);
//            mnyawa3.setImageDrawable(image1);
        }else{
            mnyawa1.setImageDrawable(image1);
            mnyawa2.setImageDrawable(image1);
            mnyawa3.setImageDrawable(image1);
            skor = (benar/10)*100;
            String skorx = String.valueOf(skor)+"%";
            String easy="1";
            Intent i = new Intent(LevelMudah.this, KuisKalah.class);
            i.putExtra("skorakhir",skorx);
            i.putExtra("level",easy);
            startActivity(i);
        }
    }
}
