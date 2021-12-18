package com.tungdv.subjectmanager.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class TermAndSubjectDatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "TermAndSubjectDB";
    private static final int DATABASE_VERSION = 1;

    TermAndSubjectDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Ultils.onCreateSubjectTable(sqLiteDatabase);
        Ultils.onCreateTermTable(sqLiteDatabase);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        Ultils.onUpgradeSubjectTable(sqLiteDatabase, i, i1);
        Ultils.onUpgradeTermTable(sqLiteDatabase, i, i1);

    }
}
