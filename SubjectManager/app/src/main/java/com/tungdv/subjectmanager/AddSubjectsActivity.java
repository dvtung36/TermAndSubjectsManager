package com.tungdv.subjectmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.tungdv.subjectmanager.model.Subjects;

public class AddSubjectsActivity extends AppCompatActivity {
    private EditText editMaMH, editTenMH, editMaBM, editSoTinChi, editSoTiet, editMoTa;
    private Button addSubject;
    Subjects subjects;
    String isAddString = "";
    Boolean isAdd = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_subjects);

        init();

        isAddString = getIntent().getStringExtra("keyIsAddSubject");
        if (isAddString != "editSubject") {
            isAdd = false;
            subjects = (Subjects) getIntent().getSerializableExtra("key3");
            if (subjects != null) {
                editMaMH.setText("" + subjects.getMaMonHoc());
                editTenMH.setText("" + subjects.getTenMonHoc());
                editMaBM.setText("" + subjects.getMaBoMon());
                editSoTinChi.setText("" + subjects.getSoTinChi());
                editSoTiet.setText("" + subjects.getSoTiet());
                editMoTa.setText("" + subjects.getMoTa());
                addSubject.setText("Save");
            }

        } else {
            isAdd = true;
            editMaMH.setText(" ");
            editTenMH.setText(" ");
            editMaBM.setText(" ");
            editSoTinChi.setText(" ");
            editSoTiet.setText(" ");
            editMoTa.setText(" ");
            addSubject.setText("Add Subject");

        }


        addSubject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });

    }

    private void init() {
        editMaMH = findViewById(R.id.edt_maMH);
        editTenMH = findViewById(R.id.edt_tenMH);
        editMaBM = findViewById(R.id.edt_mabomon);
        editSoTinChi = findViewById(R.id.edt_soTinchi);
        editSoTiet = findViewById(R.id.edt_soTiet);
        editMoTa = findViewById(R.id.edt_mota);
        addSubject = findViewById(R.id.btn_add_subject);
    }
}
