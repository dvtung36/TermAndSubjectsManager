package com.tungdv.subjectmanager.subjects;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.tungdv.subjectmanager.R;
import com.tungdv.subjectmanager.database.SubjectsProvider;
import com.tungdv.subjectmanager.database.TermProvider;
import com.tungdv.subjectmanager.database.Ultils;
import com.tungdv.subjectmanager.model.Subjects;

public class AddOrEditSubjectsActivity extends AppCompatActivity {
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
        if (isAddString.equals("editSubject")) {
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

                if (isAdd) {
                    Log.d("TUNGDVDVDVDV", "addTerm onClick: is add = true");
                    ContentValues values = new ContentValues();
                    values.put(Ultils.MA_MON_HOC, "" + editMaMH.getText());
                    values.put(Ultils.TEN_MON_HOC, "" + editTenMH.getText());
                    values.put(Ultils.MA_BO_MON, "" + editMaBM.getText());
                    values.put(Ultils.SO_TIN_CHI, "" + editSoTinChi.getText().toString());
                    values.put(Ultils.SO_TIET, "" + editSoTiet.getText().toString());
                    values.put(Ultils.MO_TA, "" + editMoTa.getText());

                    getContentResolver().insert(SubjectsProvider.CONTENT_URI, values);
                    finish();
                } else {
                    ContentValues values = new ContentValues();
                    values.put(Ultils.MA_MON_HOC, "" + editMaMH.getText());
                    values.put(Ultils.TEN_MON_HOC, "" + editTenMH.getText());
                    values.put(Ultils.MA_BO_MON, "" + editMaBM.getText());
                    values.put(Ultils.SO_TIN_CHI, "" + editSoTinChi.getText().toString());
                    values.put(Ultils.SO_TIET, "" + editSoTiet.getText().toString());
                    values.put(Ultils.MO_TA, "" + editMoTa.getText());


                    getContentResolver().
                            update(SubjectsProvider.CONTENT_URI, values, Ultils.MA_MON_HOC + "=?",
                                    new String[]{String.valueOf(subjects.getMaMonHoc())});
                    finish();
                }


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
