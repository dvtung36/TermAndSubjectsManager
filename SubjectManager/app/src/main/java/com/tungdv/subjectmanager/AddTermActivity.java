package com.tungdv.subjectmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.tungdv.subjectmanager.model.Subjects;
import com.tungdv.subjectmanager.model.Term;

public class AddTermActivity extends AppCompatActivity {
    private EditText editMaHP, editTenHP, editMaMH, editMaGV1, editMaGV2, editHocKy, editNamHoc;
    private Button addTerm;
    Term term;
    String isAddString = "";
    Boolean isAdd = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_term);
        init();
        isAddString = getIntent().getStringExtra("keyIsAddTerm");
            if (isAddString != "editTerm") {
                isAdd = false;
                term = (Term) getIntent().getSerializableExtra("key4");
                if (term != null) {
                    editMaHP.setText("" + term.getMaHocPhan());
                    editTenHP.setText("" + term.getTenHocPhan());
                    editMaGV1.setText("" + term.getMaGiaoVien1());
                    editMaGV2.setText("" + term.getMaGiaoVien2());
                    editHocKy.setText("" + term.getHocKy());
                    editNamHoc.setText("" + term.getNamHoc());
                    editMaMH.setText("" + term.getMaMonHoc());
                    addTerm.setText("Save");
                }
            }
        else {
                isAdd = true;
                editMaHP.setText("" );
                editTenHP.setText("" );
                editMaGV1.setText("" );
                editMaGV2.setText("" );
                editHocKy.setText("" );
                editNamHoc.setText("" );
                editMaMH.setText("" );
                addTerm.setText("Add Term");
            }

        addTerm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void init() {
        editMaHP = findViewById(R.id.edt_maHP);
        editTenHP = findViewById(R.id.edt_tenHP);
        editMaMH = findViewById(R.id.edt_maMonHoc);
        editMaGV1 = findViewById(R.id.edt_maGV1);
        editMaGV2 = findViewById(R.id.edt_maGV2);
        editHocKy = findViewById(R.id.edt_hocKy);
        editNamHoc = findViewById(R.id.edt_namHoc);
        addTerm = findViewById(R.id.btn_add_term);
    }
}