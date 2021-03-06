package com.tungdv.subjectmanager.subjects;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import com.tungdv.subjectmanager.IIClickShow;
import com.tungdv.subjectmanager.R;
import com.tungdv.subjectmanager.adapter.SubjectsAdapter;
import com.tungdv.subjectmanager.database.SubjectsProvider;
import com.tungdv.subjectmanager.database.Ultils;
import com.tungdv.subjectmanager.model.Subjects;

import java.util.ArrayList;
import java.util.List;

public class SubjectsManagerActivity extends AppCompatActivity implements IIClickShow {

    ListView listViewSubject;
    ImageView imageViewSearch, imageViewAddSubject, imageViewShowAll;
    EditText editTextSearch;
    SubjectsAdapter adapter;

    List<Subjects> listSubject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subjects_manager);
        init();

        final ListView list_view = (ListView) findViewById(R.id.listView_Subject);
        adapter = new SubjectsAdapter(getApplicationContext(), listSubject);
        adapter.setIiClickShow(this);
        list_view.setAdapter(adapter);

        imageViewAddSubject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AddOrEditSubjectsActivity.class);
                intent.putExtra("keyIsAddSubject", "addSubject");
                startActivity(intent);
            }
        });

        imageViewSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("TungDV", "imageViewSearch onClick: ");
                listSubject= getListSubjectAfterSearch(editTextSearch.getText().toString());
                adapter.setListSubject(listSubject);
                adapter.notifyDataSetChanged();
            }
        });
        imageViewShowAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setUI();
            }
        });

    }

    void init() {
        listViewSubject = findViewById(R.id.listView_Subject);
        imageViewSearch = findViewById(R.id.imv_search);
        editTextSearch = findViewById(R.id.edt_search);
        imageViewAddSubject = findViewById(R.id.imv_add_subject);
        imageViewShowAll = findViewById(R.id.imv_show_all);

        listSubject = new ArrayList<>();
        listSubject = getListSubjectDatabase(this);
    }

    @Override
    protected void onRestart() {
        listSubject = getListSubjectDatabase(this);
        adapter.setListSubject(listSubject);
        adapter.notifyDataSetChanged();
        super.onRestart();
    }


    @Override
    public void showDetail(int pos) {
        Intent intent = new Intent(this, DetailSubjectActivity.class);
        intent.putExtra("key1", listSubject.get(pos));

        startActivity(intent);
    }

    @Override
    public void showEdit(int pos) {
        Intent intent = new Intent(this, AddOrEditSubjectsActivity.class);
        intent.putExtra("key3", listSubject.get(pos));
        intent.putExtra("keyIsAddSubject", "editSubject");

        startActivity(intent);
    }

    public void setUI() {
        listSubject = getListSubjectDatabase(this);
        adapter.setListSubject(listSubject);
        adapter.notifyDataSetChanged();
    }

    private AlertDialog DeleteOption(int pos, SubjectsManagerActivity subjectsManagerActivity) {
        AlertDialog myQuittingDialogBox = new AlertDialog.Builder(this)
                .setTitle("X??a")
                .setMessage("B???n c?? ch???c ch???n mu???n x??a m??n h???c n??y kh??ng?")
                //   .setIcon(R.drawable.delete)

                .setPositiveButton("X??a", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int whichButton) {
                        getContentResolver()
                                .delete(SubjectsProvider.CONTENT_URI,
                                        Ultils.MA_MON_HOC + "=?",
                                        new String[]{String.valueOf(listSubject.get(pos).getMaMonHoc())});


                        subjectsManagerActivity.setUI();
                        dialog.dismiss();
                    }
                })
                .setNegativeButton("H???y", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();

                    }
                })
                .create();

        return myQuittingDialogBox;
    }

    @Override
    public void showDelete(int pos) {
        AlertDialog diaBox = DeleteOption(pos, this);
        diaBox.show();
    }

    public static List<Subjects> getListSubjectDatabase(Context context) {
        List<Subjects> subjectsList = new ArrayList<>();
        Uri uri = SubjectsProvider.CONTENT_URI;
        String[] projection = {
                Ultils.MA_MON_HOC,
                Ultils.TEN_MON_HOC,
                Ultils.MA_BO_MON,
                Ultils.SO_TIN_CHI,
                Ultils.SO_TIET,
                Ultils.MO_TA,
        };

        Cursor cursor = context.getContentResolver().query(uri, projection, null, null, null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                Log.d("TungDV", "getListTermDatabase:  cursor != null");
                String mamh = cursor.getString(0);
                String tenmh = cursor.getString(1);
                String mabm = cursor.getString(2);
                int sotinchi = cursor.getInt(3);
                int sotiet = cursor.getInt(4);
                String mota = cursor.getString(5);
                Subjects subjects = new Subjects(mamh, tenmh, mabm, sotinchi, sotiet, mota);
                subjectsList.add(subjects);

            }
            cursor.close();
        }
        return subjectsList;
    }
    public  List<Subjects> getListSubjectAfterSearch(String query){

        List<Subjects> subjectsList = new ArrayList<>();
        Uri uri = SubjectsProvider.CONTENT_URI;
        String[] projection = {
                Ultils.MA_MON_HOC,
                Ultils.TEN_MON_HOC,
                Ultils.MA_BO_MON,
                Ultils.SO_TIN_CHI,
                Ultils.SO_TIET,
                Ultils.MO_TA,
        };
        Cursor cursor = getApplicationContext().getContentResolver().query(uri,
                projection, Ultils.TEN_MON_HOC + " like ?", new String[]{"%" + query + "%"}, null);
        Log.d("TungDV", "getListSubjectAfterSearch:  cursor1212 = "+cursor);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                Log.d("TungDV", "getListSubjectAfterSearch:  cursor != null");
                String mamh = cursor.getString(0);
                String tenmh = cursor.getString(1);
                String mabm = cursor.getString(2);
                int sotinchi = cursor.getInt(3);
                int sotiet = cursor.getInt(4);
                String mota = cursor.getString(5);
                Subjects subjects = new Subjects(mamh, tenmh, mabm, sotinchi, sotiet, mota);
                subjectsList.add(subjects);
            }
            cursor.close();
        }
        return subjectsList;
    }


}