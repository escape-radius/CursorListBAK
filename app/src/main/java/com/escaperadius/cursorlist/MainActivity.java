package com.escaperadius.cursorlist;

import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    ViewPager pager;
    TabLayout tabLayout;
    PageAdapter adapter;
    FragmentManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pager= (ViewPager) findViewById(R.id.view_pager);
        tabLayout= (TabLayout) findViewById(R.id.tab_layout);

        // Fragment manager to add fragment in viewpager we will pass object of Fragment manager to adpater class.
        manager=getSupportFragmentManager();
        //object of PagerAdapter passing fragment manager object as a parameter of constructor of PagerAdapter class.
        adapter=new PageAdapter(manager);

        //set Adapter to view pager
        pager.setAdapter(adapter);

        //set tablayout with viewpager
        tabLayout.setupWithViewPager(pager);
        //Setting tabs from adpater
        tabLayout.setTabsFromPagerAdapter(adapter);
/*
        DataBaseHelper db = new DataBaseHelper(this);


        Log.d("Insert: ", "Inserting ..");
        db.insertWord(new WordDTO("wa'"));
        db.insertWord(new WordDTO("cha'"));
        db.insertWord(new WordDTO("wej"));
        db.insertWord(new WordDTO("loS"));

       // Reading all contacts
        Log.d("Reading: ", "Reading all contacts..");
        List<WordDTO> words = db.getAllLibEntries();

        for (WordDTO cn : words) {
            String log = cn.word;
            // Writing Contacts to log
            Log.d("Name: ", log);
        }
*/
    }
}
