package com.sinaapp.terryspace.javadesignpattern;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by terry on 6/28/15.
 */
public class JDPDatabaseUtil {
    private SQLiteDatabase sqLiteDatabase;
    private static JDPDatabaseUtil jdpDatabaseUtil = null;

    private JDPDatabaseUtil() {
        this.sqLiteDatabase = SQLiteDatabase.openOrCreateDatabase
                (DBManager.DB_PATH + "/" + DBManager.DB_NAME, null);
    }

    public static JDPDatabaseUtil getInstance() {
        if (jdpDatabaseUtil == null) {
            jdpDatabaseUtil = new JDPDatabaseUtil();
        }
        return jdpDatabaseUtil;
    }


    //get the infomation from sqlite
    public ArrayList getDesignPatterns() {
        ArrayList<DesignPattern> designPatterns = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM pattern", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            designPatterns.add
                    (new DesignPattern(cursor.getString(0), cursor.getString(1), cursor.getString(2)));
            cursor.moveToNext();
        }
        cursor.close();
        return designPatterns;
    }

}
