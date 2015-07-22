package com.sinaapp.terryspace.javadesignpattern;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by terry on 6/28/15.
 */
public class DBManager {
    private final String TAG = "DBManager";

    public static final String DB_NAME = "javadesignpattern.db";
    public static final String PACKAGE_NAME = "com.sinaapp.terryspace.javadesignpattern";
    public static final String DB_PATH = "/data" + Environment.getDataDirectory().getAbsolutePath() + "/" + PACKAGE_NAME;

    private Context context;
    private SQLiteDatabase sqLiteDatabase;

    public DBManager(Context context) {
        this.context = context;
    }

    public void openDatabase() {
        this.sqLiteDatabase = this.openDatabase(DB_PATH + "/" + DB_NAME);
    }

    private SQLiteDatabase openDatabase(String filepath) {
        //copy the database in the raw to the android file system.
        try {
            if (!(new File(filepath).exists())) {
                InputStream inputStream = context.getResources().openRawResource(R.raw.javadesignpattern);
                FileOutputStream fileOutputStream = new FileOutputStream(filepath);
                byte[] buffer = new byte[1024];
                int length = 0;
                while ((length = inputStream.read(buffer)) > 0){
                    fileOutputStream.write(buffer,0,length);
                }

                fileOutputStream.flush();
                fileOutputStream.close();
                inputStream.close();
            }

            SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(filepath,null);

            return db;
        } catch (FileNotFoundException e) {
            Log.e(TAG,"file not found");
            e.printStackTrace();
        } catch (IOException e) {
            Log.e(TAG,"io exception");
            e.printStackTrace();
        }

        return null;
    }

    public void closeDatabase(){
        this.sqLiteDatabase.close();
    }


}
