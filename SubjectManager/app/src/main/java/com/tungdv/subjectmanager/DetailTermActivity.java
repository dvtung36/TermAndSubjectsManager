package com.tungdv.subjectmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.tungdv.subjectmanager.model.Subjects;
import com.tungdv.subjectmanager.model.Term;

public class DetailTermActivity extends AppCompatActivity {
    private TextView textMaHP, textTenHP, textMaMH, textMaGV1, textMaGV2, textHocKy, textNamHoc;
    Term term;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_term);
        init();

        term = (Term) getIntent().getSerializableExtra("key2");
        if (term != null) {
            textMaHP.setText("" + term.getMaHocPhan());
            textTenHP.setText("" + term.getTenHocPhan());
            textMaMH.setText("" + term.getMaMonHoc());
            textMaGV1.setText("" + term.getMaGiaoVien1());
            textMaGV2.setText("" + term.getMaGiaoVien2());
            textHocKy.setText(""+ term.getHocKy());
            textNamHoc.setText(""+term.getNamHoc());
        }
    }

    private void init(){
        textMaHP = findViewById(R.id.txt_maHP);
        textTenHP = findViewById(R.id.txt_tenHP);
        textMaMH = findViewById(R.id.txt_maMonHoc);
        textMaGV1 = findViewById(R.id.txt_maGV1);
        textMaGV2 = findViewById(R.id.txt_maGV2);
        textHocKy = findViewById(R.id.txt_hocKy);
        textNamHoc =findViewById(R.id.txt_namHoc);
    }
}