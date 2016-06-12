package com.escaperadius.cursorlist;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * Created by Chris on 6/8/2016.
 */
public class LibraryCursorAdapter extends CursorAdapter {
    public LibraryCursorAdapter(Context context, Cursor c) {
        super(context, c);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.row_library, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView row_word = (TextView) view.findViewById(R.id.row_word);

        String word = cursor.getString(cursor.getColumnIndexOrThrow("value"));
        row_word.setText(word);
    }
}
