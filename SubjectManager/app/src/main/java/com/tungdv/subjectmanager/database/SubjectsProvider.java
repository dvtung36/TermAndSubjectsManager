package com.tungdv.subjectmanager.database;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class SubjectsProvider extends ContentProvider {

    private TermAndSubjectDatabaseHelper dbHelper;

    private static final int URI_ALL_ITEMS_CODE = 1;
    private static final int URI_ONE_ITEM_CODE = 2;
    private static final String AUTHORITY = "com.tungdv.subjectmanager.database.SubjectsProvider";

    // create content URIs from the authority by appending path to database table
    public static final Uri CONTENT_URI =
            Uri.parse("content://" + AUTHORITY + "/subjectTable");

    private static final UriMatcher uriMatcher;

    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(AUTHORITY, "subjectTable", URI_ALL_ITEMS_CODE);
        uriMatcher.addURI(AUTHORITY, "subjectTable/#", URI_ONE_ITEM_CODE);
    }

    public SubjectsProvider() {

    }

    @Override
    public boolean onCreate() {
        // get access to the database helper
        dbHelper = new TermAndSubjectDatabaseHelper(getContext());
        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] strings, @Nullable String s, @Nullable String[] strings1, @Nullable String s1) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();
        queryBuilder.setTables(Ultils.SUBJECT_TABLE);

        switch (uriMatcher.match(uri)) {
            case URI_ALL_ITEMS_CODE:
                //do nothing
                break;
            case URI_ONE_ITEM_CODE:
                String id = uri.getPathSegments().get(1);
                queryBuilder.appendWhere(Ultils.MA_MON_HOC + "=" + id);
                break;
            default:
                throw new IllegalArgumentException("Unsupported URI: " + uri);
        }

        Cursor cursor = queryBuilder.query(db, strings, s,
                strings1, null, null, s1);
        return cursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        switch (uriMatcher.match(uri)) {
            case URI_ALL_ITEMS_CODE:
                return "vnd.android.cursor.dir/vnd.com.tungdv.subjectmanager.database.TermProvider.subjectTable";
            case URI_ONE_ITEM_CODE:
                return "vnd.android.cursor.item/vnd.com.tungdv.subjectmanager.database.TermProvider.subjectTable";
            default:
                throw new IllegalArgumentException("Unsupported URI: " + uri);
        }
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        switch (uriMatcher.match(uri)) {
            case URI_ALL_ITEMS_CODE:
                //do nothing
                break;
            default:
                throw new IllegalArgumentException("Unsupported URI: " + uri);
        }
        long id = db.insert(Ultils.SUBJECT_TABLE, null, contentValues);
        getContext().getContentResolver().notifyChange(uri, null);
        Toast.makeText(getContext(), "add subject success", Toast.LENGTH_SHORT).show();
        return Uri.parse(CONTENT_URI + "/" + id);
    }

    @Override
    public int delete(Uri uri, String where, String[] whereArgs) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        int deleteCount = db.delete(Ultils.SUBJECT_TABLE, where, whereArgs);
        getContext().getContentResolver().notifyChange(uri, null);
        return deleteCount;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues,
                      @Nullable String selection, @Nullable String[] selectionArgs) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        switch (uriMatcher.match(uri)) {
            case URI_ALL_ITEMS_CODE:
                //do nothing
                break;
            case URI_ONE_ITEM_CODE:
                String id = uri.getPathSegments().get(1);
                selection = Ultils.MA_MON_HOC + "=" + id
                        + (!TextUtils.isEmpty(selection) ?
                        " AND (" + selection + ')' : "");
                break;
            default:
                throw new IllegalArgumentException("Unsupported URI: " + uri);
        }

        int updateCount = db.update(Ultils.SUBJECT_TABLE, contentValues, selection, selectionArgs);
        getContext().getContentResolver().notifyChange(uri, null);
        return updateCount;
    }
}
