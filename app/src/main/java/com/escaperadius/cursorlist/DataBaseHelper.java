package com.escaperadius.cursorlist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chris on 6/6/2016.
 */
public class DataBaseHelper extends SQLiteOpenHelper {
    // Database Version
    private static final int DB_VERSION = 1;

    // Database Name
    private static final String DB_NAME = "library.db";

    // Table Names
    private static final String TABLE_WORDS = "words";
    // Common Column Names
    private static final String KEY_ID = "_id";

    // Library Table - column names
    private static final String KEY_VALUE = "value";
    public DataBaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_WORDS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.e("UPGRADE","WTF");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_WORDS);
    }

    // Library table creation statement
    private static final String CREATE_TABLE_WORDS = "CREATE TABLE "
            + TABLE_WORDS + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_VALUE + " TEXT" + ")";


    public void insertWord(WordDTO dto) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_VALUE, dto.word);

        db.insert(TABLE_WORDS, null, values);

        db.close();
    }

    // Get all Library entries
    public List<WordDTO> getAllLibEntries() {
        List<WordDTO> libraryDTOList = new ArrayList<WordDTO>();
        // Select All Query
        String selectQuery = "SELECT * FROM " + TABLE_WORDS;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and add to list
        if (cursor.moveToFirst()) {
            do {
                WordDTO wordDTO = new WordDTO();
                wordDTO.word = cursor.getString(1);
                Log.e("WORD", cursor.getString(1));
                libraryDTOList.add(wordDTO);
            } while (cursor.moveToNext());
        }
        db.close();
        return libraryDTOList;
    }

    // Get all Library entries
    public Cursor getCursor() {
        // Select All Query
        String selectQuery = "SELECT * FROM " + TABLE_WORDS;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        return cursor;
    }
}
