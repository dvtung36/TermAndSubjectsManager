package com.tungdv.subjectmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import com.tungdv.subjectmanager.adapter.SubjectsAdapter;
import com.tungdv.subjectmanager.model.Subjects;

import java.util.ArrayList;
import java.util.List;

public class SubjectsManagerActivity extends AppCompatActivity implements IIClickShow {

    ListView listViewSubject;
    ImageView imageViewSearch,imageViewAddSubject;
    EditText editTextSearch;


    List<Subjects> listSubject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subjects_manager);
        init();

        final ListView list_view = (ListView) findViewById(R.id.listView_Subject);
        SubjectsAdapter adapter = new SubjectsAdapter(getApplicationContext(), listSubject);
        adapter.setIiClickShow(this);
        list_view.setAdapter(adapter);

        imageViewAddSubject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AddSubjectsActivity.class);
                startActivity(intent);
            }
        });

    }
    void init(){
        listViewSubject =findViewById(R.id.listView_Subject);
        imageViewSearch = findViewById(R.id.imv_search);
        editTextSearch = findViewById(R.id.edt_search);
        imageViewAddSubject = findViewById(R.id.imv_add_subject);

        listSubject = new ArrayList<>();
        Subjects subjects2 = new Subjects("12323","Vat Ly","123",1,22,"khong co gi");
        Subjects subjects1 = new Subjects("12323","Hoa Hoc","123",1,22,"khong co gi");
        Subjects subjects = new Subjects("12323","Tieng Anh","123",1,22,"khong co gi");
        listSubject.add(subjects);
        listSubject.add(subjects1);
        listSubject.add(subjects2);
    }


    @Override
    public void showDetail(int pos) {
        Intent intent = new Intent(this, DetailSubjectActivity.class);
        intent.putExtra("key1", listSubject.get(pos));

        startActivity(intent);
    }

    @Override
    public void showEdit(int pos) {
        Intent intent = new Intent(this, AddSubjectsActivity.class);
        intent.putExtra("key3", listSubject.get(pos));
        intent.putExtra("keyIsAddSubject", "editSubject");

        startActivity(intent);
    }

    @Override
    public void showDelete(int pos) {

    }
}