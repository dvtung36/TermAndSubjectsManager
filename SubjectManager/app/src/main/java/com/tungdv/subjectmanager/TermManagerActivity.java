package com.tungdv.subjectmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import com.tungdv.subjectmanager.adapter.SubjectsAdapter;
import com.tungdv.subjectmanager.adapter.TermAdapter;
import com.tungdv.subjectmanager.model.Subjects;
import com.tungdv.subjectmanager.model.Term;

import java.util.ArrayList;
import java.util.List;

public class TermManagerActivity extends AppCompatActivity {
    ListView listViewTerm;
    ImageView imageViewSearch;
    EditText editTextSearch;

    List<Term> listTerm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_term_manager);
        init();

        final ListView list_view = (ListView) findViewById(R.id.listView_Term);
        TermAdapter adapter = new TermAdapter(getApplicationContext(), listTerm);
        list_view.setAdapter(adapter);
    }
    void init(){
        listViewTerm =findViewById(R.id.listView_Term);
        imageViewSearch = findViewById(R.id.imv_search);
        editTextSearch = findViewById(R.id.edt_search);
        Term term = new Term("1","Lập Trình","12","1",
                "2","2","2020-2021");
        Term term1 = new Term("1","Khoa Học Xã Hội","12","1",
                "2","2","2020-2021");
        Term term2 = new Term("1","Thể dục","12","1",
                "2","2","2020-2021");
        Term term3 = new Term("1","Tự chọn","12","1",
                "2","2","2020-2021");

        listTerm = new ArrayList<>();
        listTerm.add(term);
        listTerm.add(term1);
        listTerm.add(term2);
        listTerm.add(term3);
    }
}