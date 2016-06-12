package com.escaperadius.cursorlist;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class EnterWordsFragment extends Fragment implements View.OnClickListener  {

    private DataBaseHelper db;
    Context context;
    EditText et_word;
    Button btn_save;
    public EnterWordsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_enter_words, container, false);
        context = getActivity();
        db = new DataBaseHelper(context);
        et_word = (EditText) view.findViewById(R.id.et_word);
        btn_save = (Button) view.findViewById(R.id.btn_save);
        btn_save.setOnClickListener(this);

        return view;
    }
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_save:
                db.insertWord(new WordDTO(et_word.getText().toString()));
        }
    }
}
