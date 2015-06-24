package com.nnadid.chem101;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import java.util.Locale;

public class MainActivity extends ListActivity {


    TextToSpeech t1;
    String[] presidents = {
            "CHEMICAL",
            "Methane  ",
            "Ethane ",
            "Propane ",
            "Butane  ",
            "Pentane  ",
            "Hexane  ",
            "Heptane ",
            "Octane  ",
            "Nonane  ",
            "Decane  ",
            "Ethene  ",
            "propene  ",
            "Butene ",
            "Pentene  ",
            "Hexene  ",
            "Heptene  ",
            "Octene  ",
            "Nonene  ",
            "Decene  ",
            "Ethyne  ",
            "Propyne  ",
            "Butyne  ",
            "Pentyne  ",
            "Hexyne  ",
            "Heptyne  ",
            "Octyne   ",
            "Nonyne  ",
            "Decyne  ",
            "Benzene  ",
            "      "
    };

    Integer[] imageIDs = {
            1000000,
            R.drawable.btn,
            R.drawable.nigeria,
            R.drawable.btn,
            R.drawable.nigeria,
            R.drawable.btn,
            R.drawable.nigeria,
            R.drawable.btn,
            R.drawable.nigeria,
            R.drawable.btn,
            R.drawable.nigeria,
            R.drawable.btn,
            R.drawable.nigeria,
            R.drawable.btn,
            R.drawable.nigeria,
            R.drawable.btn,
            R.drawable.nigeria,
            R.drawable.btn,
            R.drawable.nigeria,
            R.drawable.btn,
            R.drawable.nigeria,
            R.drawable.btn,
            R.drawable.nigeria,
            R.drawable.btn,
            R.drawable.nigeria,
            R.drawable.btn,
            R.drawable.nigeria,
            R.drawable.btn,
            R.drawable.nigeria,
            R.drawable.btn,
            100000000
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new ArrayAdapter<String>(this,R.layout.item_holder, R.id.txtPresidentName, presidents);

        //---using custom array adapter---
        CustomArrayAdapter adapter = new CustomArrayAdapter(this, presidents, imageIDs);
        setListAdapter(adapter);




        // Implementing the text To speech code here
        t1=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    t1.setLanguage(Locale.ENGLISH);
                    t1.setPitch(1);
                    t1.setSpeechRate(1);
                }
            }
        });
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        t1.speak(presidents[position], TextToSpeech.QUEUE_FLUSH, null);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.IO) {
            finish();
            startActivity(new Intent(getApplicationContext(),InOgarnic.class));
        }else{
            finish();
            startActivity(new Intent(getApplicationContext(),MainActivity.class));

        }

        return super.onOptionsItemSelected(item);
    }



}




