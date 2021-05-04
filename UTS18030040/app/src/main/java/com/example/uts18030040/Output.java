package com.example.uts18030040;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
/*--tampilan dari data yang telah diisi pada halaman 2 dan di extend pada halaman 3 sebagai output

 */
public class Output extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output);
        TextView studi = findViewById(R.id.tampilan_programstudi);
        TextView nama = findViewById(R.id.tampilan_nama);
        TextView nim = findViewById(R.id.tampilan_nim);
        TextView matkul = findViewById(R.id.tampilan_matakuliah);
        TextView sks = findViewById(R.id.tampilan_sks);
        TextView dp = findViewById(R.id.tampilan_dosen);
        TextView tanggal = findViewById(R.id.tampilan_tanggal);
        TextView kelas = findViewById(R.id.tampilan_kelas);

        String programstudi = getIntent().getStringExtra("PROGRAMSTUDI");
        String nama_mhs = getIntent().getStringExtra("NAMA");
        String NIM_mhs = getIntent().getStringExtra("NIM");
        String matakuliah = getIntent().getStringExtra("MATAKULIAH");
        String SKS = getIntent().getStringExtra("SKS");
        String dosen = getIntent().getStringExtra("DOSEN");
        String Tanggal = getIntent().getStringExtra("TANGGAL");
        String kelas_mhs = getIntent().getStringExtra("KELAS");

        studi.setText(programstudi);
        nama.setText(nama_mhs);
        nim.setText(NIM_mhs);
        matkul.setText(matakuliah);
        sks.setText(SKS);
        dp.setText(dosen);
        tanggal.setText(Tanggal);
        kelas.setText(kelas_mhs);
    }
}