package com.example.uts18030040;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
/*--untuk memasukan NIM dan Nama serta memilih kelas pada radiobutton--/

 */
    public void simpan_data(View view) {
        EditText masukan_nim = findViewById(R.id.masukan_nim);
        String NIM = masukan_nim.getText().toString();
        EditText masukan_nama = findViewById(R.id.masukan_nama);
        String Nama = masukan_nama.getText().toString();
        RadioGroup masukan_kelas = findViewById(R.id.radiogroup);
        int Kelas = masukan_kelas.getCheckedRadioButtonId();

        RadioButton kls = findViewById(Kelas);
        String kelas_1 = String.valueOf(kls.getText().toString());
/*--untuk membuka ke halaman baru agar pada tampilan Data_ujian tertampil NIM, Nama dan kelas yang telah di masukan--/

 */
        Intent intent = new Intent(this, Data_ujian.class);
        intent.putExtra("Masukan_NIM", NIM);
        intent.putExtra("Masukan_Nama", Nama);
        intent.putExtra("Masukan_Kelas", kelas_1);
        startActivity(intent);
    }
}