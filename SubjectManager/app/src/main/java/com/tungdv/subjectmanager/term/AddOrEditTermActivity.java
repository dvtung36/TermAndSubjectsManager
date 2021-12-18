package com.tungdv.subjectmanager.term;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.tungdv.subjectmanager.R;
import com.tungdv.subjectmanager.database.TermAndSubjectDatabaseHelper;
import com.tungdv.subjectmanager.database.TermProvider;
import com.tungdv.subjectmanager.database.Ultils;
import com.tungdv.subjectmanager.model.Subjects;
import com.tungdv.subjectmanager.model.Term;

public class AddOrEditTermActivity extends AppCompatActivity {
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

        if (isAddString.equals("editTerm")) {
            addTerm.setText("Save");
            isAdd = false;
            term = (Term) getIntent().getSerializableExtra("key4");
            editMaHP.setText("" + term.getMaHocPhan());
            editTenHP.setText("" + term.getTenHocPhan());
            editMaGV1.setText("" + term.getMaGiaoVien1());
            editMaGV2.setText("" + term.getMaGiaoVien2());
            editHocKy.setText("" + term.getHocKy());
            editNamHoc.setText("" + term.getNamHoc());
            editMaMH.setText("" + term.getMaMonHoc());
            addTerm.setText("Save");

        } else {
            isAdd = true;
            editMaHP.setText("");
            editTenHP.setText("");
            editMaGV1.setText("");
            editMaGV2.setText("");
            editHocKy.setText("");
            editNamHoc.setText("");
            editMaMH.setText("");
            addTerm.setText("Add Term");
        }


        addTerm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("TUNGDVDVDVDV", "addTerm onClick: is add = " + isAdd);
                if (isAdd) {
                    //  Log.d("TUNGDVDVDVDV", "addTerm onClick: is add = true");
                    ContentValues values = new ContentValues();
                    values.put(Ultils.MA_HOC_PHAN, "" + editMaHP.getText());
                    values.put(Ultils.TEN_HOC_PHAN, "" + editTenHP.getText());
                    values.put(Ultils.MA_MH, "" + editMaMH.getText());
                    values.put(Ultils.MA_GV1, "" + editMaGV1.getText());
                    values.put(Ultils.MA_GV2, "" + editMaGV2.getText());
                    values.put(Ultils.HOC_KY, "" + editHocKy.getText());
                    values.put(Ultils.NAM_HOC, "" + editNamHoc.getText());

                    getContentResolver().insert(TermProvider.CONTENT_URI, values);
                    finish();
                } else {
                    ContentValues values = new ContentValues();
                    values.put(Ultils.MA_HOC_PHAN, "" + editMaHP.getText());
                    values.put(Ultils.TEN_HOC_PHAN, "" + editTenHP.getText());
                    values.put(Ultils.MA_MH, "" + editMaMH.getText());
                    values.put(Ultils.MA_GV1, "" + editMaGV1.getText());
                    values.put(Ultils.MA_GV2, "" + editMaGV2.getText());
                    values.put(Ultils.HOC_KY, "" + editHocKy.getText());
                    values.put(Ultils.NAM_HOC, "" + editNamHoc.getText());

                    getContentResolver().
                            update(TermProvider.CONTENT_URI, values, Ultils.MA_HOC_PHAN + "=?",
                                    new String[]{String.valueOf(term.getMaHocPhan())});
                    finish();
                }

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