package com.tungdv.subjectmanager.subjects;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.tungdv.subjectmanager.R;
import com.tungdv.subjectmanager.model.Subjects;

public class DetailSubjectActivity extends AppCompatActivity {
    private TextView textMaMH, textTenMH, textMaBM, textSoTinChi, textSoTiet, textMoTa;
    private Button btnOK;
    Subjects subjects;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_subject);
        init();

        subjects = (Subjects) getIntent().getSerializableExtra("key1");
        if (subjects != null) {
            textMaMH.setText("" + subjects.getMaMonHoc());
            textTenMH.setText("" + subjects.getTenMonHoc());
            textMaBM.setText("" + subjects.getMaBoMon());
            textSoTinChi.setText("" + subjects.getSoTinChi());
            textSoTiet.setText("" + subjects.getSoTiet());
            textMoTa.setText("" + subjects.getMoTa());
        }


        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void init() {
        textMaMH = findViewById(R.id.txt_maMH);
        textTenMH = findViewById(R.id.txt_tenMH);
        textMaBM = findViewById(R.id.txt_maBoMon);
        textSoTinChi = findViewById(R.id.txt_so_tin_chi);
        textSoTiet = findViewById(R.id.txt_soTiet);
        textMoTa = findViewById(R.id.txt_moTa);
        btnOK = findViewById(R.id.btn_ok);


    }
}