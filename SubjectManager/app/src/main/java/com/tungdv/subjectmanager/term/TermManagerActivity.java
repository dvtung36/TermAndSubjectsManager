package com.tungdv.subjectmanager.term;

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
import com.tungdv.subjectmanager.adapter.TermAdapter;
import com.tungdv.subjectmanager.database.SubjectsProvider;
import com.tungdv.subjectmanager.database.TermProvider;
import com.tungdv.subjectmanager.database.Ultils;
import com.tungdv.subjectmanager.model.Subjects;
import com.tungdv.subjectmanager.model.Term;

import java.util.ArrayList;
import java.util.List;

public class TermManagerActivity extends AppCompatActivity implements IIClickShow {
    ListView listViewTerm;
    ImageView imageViewSearch, imageViewAddTerm,imageViewShowAll;
    EditText editTextSearch;
    TermAdapter adapter;

    List<Term> listTerm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_term_manager);
        init();

        final ListView list_view = (ListView) findViewById(R.id.listView_Term);
        adapter = new TermAdapter(getApplicationContext(), listTerm);
        adapter.setIiClickShow(this);
        list_view.setAdapter(adapter);

        imageViewAddTerm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AddOrEditTermActivity.class);
                intent.putExtra("keyIsAddTerm", "addTerm");
                startActivity(intent);
            }
        });
        imageViewSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listTerm = getListTermAfterSearch(editTextSearch.getText().toString());
                adapter.setListTerm(listTerm);
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

    @Override
    protected void onRestart() {
        listTerm = getListTermDatabase(this);
        adapter.setListTerm(listTerm);
        adapter.notifyDataSetChanged();
        super.onRestart();
    }


    void init() {
        listViewTerm = findViewById(R.id.listView_Term);
        imageViewSearch = findViewById(R.id.imv_search);
        editTextSearch = findViewById(R.id.edt_search);
        imageViewAddTerm = findViewById(R.id.imv_add_term);
        imageViewShowAll = findViewById(R.id.imv_show_all);

        listTerm = new ArrayList<>();
        listTerm = getListTermDatabase(this);

    }


    @Override
    public void showDetail(int pos) {
        Intent intent = new Intent(this, DetailTermActivity.class);
        intent.putExtra("key2", listTerm.get(pos));
        startActivity(intent);
    }


    @Override
    public void showEdit(int pos) {
        Intent intent = new Intent(this, AddOrEditTermActivity.class);
        intent.putExtra("key4", listTerm.get(pos));
        intent.putExtra("keyIsAddTerm", "editTerm");

        startActivity(intent);
    }

    @Override
    public void showDelete(int pos) {
        AlertDialog diaBox = DeleteOption(pos, this);
        diaBox.show();

    }

    public void setUI() {
        listTerm = getListTermDatabase(this);
        adapter.setListTerm(listTerm);
        adapter.notifyDataSetChanged();
    }

    private AlertDialog DeleteOption(int pos, TermManagerActivity termManagerActivity) {
        AlertDialog myQuittingDialogBox = new AlertDialog.Builder(this)
                .setTitle("Xóa")
                .setMessage("Bạn có chắc chắn muốn xóa học phần này không?")
                //   .setIcon(R.drawable.delete)

                .setPositiveButton("Xóa", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int whichButton) {
                        getContentResolver()
                                .delete(TermProvider.CONTENT_URI,
                                        Ultils.MA_HOC_PHAN + "=?", new String[]{String.valueOf(listTerm.get(pos).getMaHocPhan())});


                        termManagerActivity.setUI();
                        dialog.dismiss();
                    }
                })
                .setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();

                    }
                })
                .create();

        return myQuittingDialogBox;
    }

    public static List<Term> getListTermDatabase(Context context) {
        List<Term> lisTerm = new ArrayList<>();
        Uri uri = TermProvider.CONTENT_URI;
        String[] projection = {
                Ultils.MA_HOC_PHAN,
                Ultils.TEN_HOC_PHAN,
                Ultils.MA_MH,
                Ultils.MA_GV1,
                Ultils.MA_GV2,
                Ultils.HOC_KY,
                Ultils.NAM_HOC,
        };
        Log.d("TungDV", "getListTermDatabase:  uri= " + uri);
        Cursor cursor = context.getContentResolver().query(uri, projection, null, null, null);
        Log.d("TungDV", "getListTermDatabase:  cursor= " + cursor);

        if (cursor != null) {
            while (cursor.moveToNext()) {
                Log.d("TungDV", "getListTermDatabase:  cursor != null");
                String mahp = cursor.getString(0);
                String tehp = cursor.getString(1);
                String mamh = cursor.getString(2);
                String magv1 = cursor.getString(3);
                String magv2 = cursor.getString(4);
                String hocky = cursor.getString(5);
                String namhoc = cursor.getString(6);
                Term term = new Term(mahp, tehp, mamh, magv1, magv2, hocky, namhoc);
                lisTerm.add(term);

            }
            cursor.close();
        }

        return lisTerm;
    }

    public  List<Term> getListTermAfterSearch(String query){

        List<Term> lisTerm = new ArrayList<>();
        Uri uri = TermProvider.CONTENT_URI;
        String[] projection = {
                Ultils.MA_HOC_PHAN,
                Ultils.TEN_HOC_PHAN,
                Ultils.MA_MH,
                Ultils.MA_GV1,
                Ultils.MA_GV2,
                Ultils.HOC_KY,
                Ultils.NAM_HOC,
        };
        Cursor cursor = getApplicationContext().getContentResolver().query(uri,
                projection, Ultils.TEN_HOC_PHAN + " like ?", new String[]{"%" + query + "%"}, null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                String mahp = cursor.getString(0);
                String tehp = cursor.getString(1);
                String mamh = cursor.getString(2);
                String magv1 = cursor.getString(3);
                String magv2 = cursor.getString(4);
                String hocky = cursor.getString(5);
                String namhoc = cursor.getString(6);
                Term term = new Term(mahp, tehp, mamh, magv1, magv2, hocky, namhoc);
                lisTerm.add(term);
            }
            cursor.close();
        }
        return lisTerm;
    }

}