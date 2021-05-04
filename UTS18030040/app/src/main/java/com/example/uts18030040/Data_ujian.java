package com.example.uts18030040;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Data_ujian extends AppCompatActivity {
    private SimpleDateFormat format_tanggal;
    private DatePickerDialog datePickerDialog;
    private TextView Output_Tanggal;
    private Button Pick_Date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_ujian);
        format_tanggal = new SimpleDateFormat("dd-MM-yyyy", Locale.US);

        TextView NIM = findViewById(R.id.input_nim);
        TextView Nama = findViewById(R.id.input_nama);
        TextView kelas = findViewById(R.id.input_kelas);

/*--tampilan dari NIM, Nama, dan Kelas yang sudah terisi pada halaman 1

 */
        String nim_mhs = getIntent().getStringExtra("Masukan_NIM");
        String nama_mhs = getIntent().getStringExtra("Masukan_Nama");
        String kelas_mhs = getIntent().getStringExtra("Masukan_Kelas");

        NIM.setText(nim_mhs);
        Nama.setText(nama_mhs);
        kelas.setText(kelas_mhs);
/*--untuk mengatur tanggal dengan radiobutton--

 */

        Output_Tanggal = (TextView) findViewById(R.id.input_tanggal);
        Pick_Date = (Button) findViewById(R.id.tanggal_ujian);
        Pick_Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDateDialog();
            }

    });
}
        private void showDateDialog () {
            Calendar newCalendar = Calendar.getInstance();
            datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    Calendar newDate = Calendar.getInstance();
                    newDate.set(year, monthOfYear, dayOfMonth);
                    Output_Tanggal.setText(format_tanggal.format(newDate.getTime()));
                }
            }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
            datePickerDialog.show();
        }
/*--mereset isi data berupa matakuliah, sks, tanggal, sifatujian, programstudi, dan dosen--

 */
    public void reset(View view) {
            EditText input_matakuliah = findViewById(R.id.masukan_matakuliah);
            EditText input_sks = findViewById(R.id.masukan_sks);
            TextView hasil_tanggal = findViewById(R.id.input_tanggal);
            EditText input_sifatujian = findViewById(R.id.masukan_sifatujian);
            EditText input_programstudi = findViewById(R.id.masukan_programstudi);
            EditText input_dosen = findViewById(R.id.masukan_dosen);

            input_matakuliah.setText("");
            input_sks.setText("");
            hasil_tanggal.setText("");
            input_sifatujian.setText("");
            input_programstudi.setText("");
            input_dosen.setText("");
        }
/*--mengsubmit isi data dari NIM, Nama, Kelas, matakuliah, sks, kelas, tanggal, sifatujian, programstudi, dosen agar tertampil di halaman selanjutnya

 */
    public void submit(View view) {
        TextView NIM = findViewById(R.id.input_nim);
        TextView Nama = findViewById(R.id.input_nama);
        EditText input_matakuliah = findViewById(R.id.masukan_matakuliah);
        EditText input_sks = findViewById(R.id.masukan_sks);
        TextView Kelas = findViewById(R.id.input_kelas);
        TextView hasil_tanggal = findViewById(R.id.input_tanggal);
        EditText input_sifatujian = findViewById(R.id.masukan_sifatujian);
        EditText input_programstudi = findViewById(R.id.masukan_programstudi);
        EditText input_dosen = findViewById(R.id.masukan_dosen);

        String nim_mhs = NIM.getText().toString();
        String nama_mhs = Nama.getText().toString();
        String matakuliah = input_matakuliah.getText().toString();
        String sks = input_sks.getText().toString();
        String kelas_mhs = Kelas.getText().toString();
        String tanggal = hasil_tanggal.getText().toString();
        String sifat = input_sifatujian.getText().toString();
        String programstudi = input_programstudi.getText().toString();
        String dosen = input_dosen.getText().toString();

/*--isi tampilan yang telah di submit

 */
        Intent intent = new Intent(this, Output.class);
        intent.putExtra("NIM", nim_mhs);
        intent.putExtra("NAMA", nama_mhs);
        intent.putExtra("MATAKULIAH", matakuliah);
        intent.putExtra("SKS", sks);
        intent.putExtra("KELAS", kelas_mhs);
        intent.putExtra("TANGGAL", tanggal);
        intent.putExtra("SIFAT", sifat);
        intent.putExtra("PROGRAMSTUDI", programstudi);
        intent.putExtra("DOSEN", dosen);
        startActivity(intent);
    }
}

