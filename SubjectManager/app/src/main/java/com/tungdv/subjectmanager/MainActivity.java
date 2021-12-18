package com.tungdv.subjectmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.tungdv.subjectmanager.subjects.SubjectsManagerActivity;
import com.tungdv.subjectmanager.term.TermManagerActivity;

public class MainActivity extends AppCompatActivity {
    TextView textViewSubject, textViewTerm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewSubject = findViewById(R.id.txt_subjects_manager);
        textViewTerm = findViewById(R.id.txt_term_manager);

        textViewTerm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), TermManagerActivity.class);
                startActivity(intent);
            }
        });
        textViewSubject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SubjectsManagerActivity.class);
                startActivity(intent);
            }
        });
    }
}