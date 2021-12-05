package com.tungdv.subjectmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import com.tungdv.subjectmanager.adapter.SubjectsAdapter;
import com.tungdv.subjectmanager.model.Subjects;

import java.util.ArrayList;
import java.util.List;

public class SubjectsManagerActivity extends AppCompatActivity {

    ListView listViewSubject;
    ImageView imageViewSearch;
    EditText editTextSearch;

    List<Subjects> listSubject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subjects_manager);
        init();

        final ListView list_view = (ListView) findViewById(R.id.listView_Subject);
        SubjectsAdapter adapter = new SubjectsAdapter(getApplicationContext(), listSubject);
        list_view.setAdapter(adapter);

    }
    void init(){
        listViewSubject =findViewById(R.id.listView_Subject);
        imageViewSearch = findViewById(R.id.imv_search);
        editTextSearch = findViewById(R.id.edt_search);
        listSubject = new ArrayList<>();
        Subjects subjects2 = new Subjects("12323","Vat Ly","123",1,22,"khong co gi");
        Subjects subjects1 = new Subjects("12323","Hoa Hoc","123",1,22,"khong co gi");
        Subjects subjects = new Subjects("12323","Tieng Anh","123",1,22,"khong co gi");
        listSubject.add(subjects);
        listSubject.add(subjects1);
        listSubject.add(subjects2);
    }
}