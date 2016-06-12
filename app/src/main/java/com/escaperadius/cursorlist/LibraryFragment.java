package com.escaperadius.cursorlist;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class LibraryFragment extends Fragment {
    DataBaseHelper dataBaseHelper;
    LibraryCursorAdapter libraryCursorAdapter;
    public LibraryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_library, container, false);
        dataBaseHelper = new DataBaseHelper(getActivity());
        SQLiteDatabase db = dataBaseHelper.getWritableDatabase();
        Cursor libraryCursor = db.rawQuery("SELECT * FROM words", null);
        ListView listView = (ListView) view.findViewById(R.id.listView);
        libraryCursorAdapter = new LibraryCursorAdapter(getActivity(),libraryCursor);
        listView.setAdapter(libraryCursorAdapter);

        Button btn_update = (Button) view.findViewById(R.id.btn_update);
        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("SWAP", "CURSOR");
                libraryCursorAdapter.swapCursor(dataBaseHelper.getCursor());
            }
        });

        return view;
    }

}
