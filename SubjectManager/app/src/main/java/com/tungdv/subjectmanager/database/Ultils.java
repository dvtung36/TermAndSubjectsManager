package com.tungdv.subjectmanager.database;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class Ultils {

    //Key bảng Term (hoc phan)
    public static final String MA_HOC_PHAN = "ma_hoc_phan";
    public static final String TEN_HOC_PHAN = "ten_hoc_phan";
    public static final String MA_MH = "ma_mh";
    public static final String MA_GV1 = "ma_giao_vien1";
    public static final String MA_GV2 = "ma_giao_vien2";
    public static final String HOC_KY = "hoc_ky";
    public static final String NAM_HOC = "nam_hoc";

    //Key bang subject (mon hoc)
    public static final String MA_MON_HOC = "ma_mon_hoc";
    public static final String TEN_MON_HOC = "ten_mon_hoc";
    public static final String MA_BO_MON = "ma_bo_mon";
    public static final String SO_TIN_CHI = "so_tin_chi";
    public static final String SO_TIET = "so_tiet";
    public static final String MO_TA = "mo_ta";


    public static final String TERM_TABLE = "termTable";
    public static final String SUBJECT_TABLE = "subjectTable";


    private static final String CREATE_TERM_TABLE =
            "CREATE TABLE if not exists " + TERM_TABLE + " (" +
                    MA_HOC_PHAN + " TEXT," +
                    TEN_HOC_PHAN + " TEXT," +
                    MA_MH + " TEXT," +
                    MA_GV1 + " TEXT," +
                    MA_GV2 + " TEXT," +
                    HOC_KY + " TEXT," +
                    NAM_HOC + " TEXT" + ")";

    public static void onCreateTermTable(SQLiteDatabase db) {
        db.execSQL(CREATE_TERM_TABLE);
    }

    public static void onUpgradeTermTable(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TERM_TABLE);
        onCreateTermTable(db);
    }


    private static final String CREATE_SUBJECT_TABLE =
            "CREATE TABLE if not exists " + SUBJECT_TABLE + " (" +
                    MA_MON_HOC + " TEXT," +
                    TEN_MON_HOC + " TEXT," +
                    MA_BO_MON + " TEXT," +
                    SO_TIN_CHI + " INTEGER," +
                    SO_TIET + " INTEGER," +
                    MO_TA + " TEXT" + ")";

    public static void onCreateSubjectTable(SQLiteDatabase db) {
        db.execSQL(CREATE_SUBJECT_TABLE);
    }

    public static void onUpgradeSubjectTable(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + SUBJECT_TABLE);
        onCreateSubjectTable(db);
    }

}
