package com.nnadid.chem101;

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

/**
 * Created by Nna-Did on 6/20/2015.
 */
public class InOgarnic extends ListActivity{
    TextToSpeech t1;
    String [] INORGANIC ={"Hydrogen Chloride","Hydrogen Peroxide","Sodium Hydroxide","Potassiun Hydroxide","Magnesium Hydroxide",
                          "Aluminiun Oxide","Calcium Oxide","Magnesium Oxide","Sulphuric Acid","Nitric Acid","Hydrogen Sulphide",
                           "Ammonia","Ammonium Chloride ","Clcium Carbornate","Carbon(IV)oxide","Carbon(II)oxide","Iron(III)oxide",
                          "Sodium Trioxonitrate(V)","Sodium Trioxocarbonate(iv)","Sodium Bicarbonate","Potassium Trioxocarbonate(iv)",
                          "Potassium Nitrate(v)","Potassium Oxide","Magnesium Trioxocarbonate(iv)","Ammonium Trioxonitrate(V)",
                           "Ammonium Trioxocarbonate(iv)","Ammonium Sulphate","  "};
    Integer[] imageIDs = {
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
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new ArrayAdapter<String>(this,R.layout.inorganic, R.id.txtPresidentName, INORGANIC);

        //---using custom array adapter---
        CustomArrayINORGANIC adapter = new CustomArrayINORGANIC(this, INORGANIC, imageIDs);
        setListAdapter(adapter);
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
        t1.speak(INORGANIC[position], TextToSpeech.QUEUE_FLUSH, null);
    }

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
            startActivity(new Intent(getApplicationContext(),InOgarnic.class));
        }else{
            startActivity(new Intent(this,MainActivity.class));

        }

        return super.onOptionsItemSelected(item);
    }

}
