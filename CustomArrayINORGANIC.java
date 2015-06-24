package com.nnadid.chem101;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Felix on 6/20/2015.
 */
public class CustomArrayINORGANIC extends ArrayAdapter<String> {
    private final Activity context;
    private final String[] compounds;
    private final Integer[] imageIds;
    String [] names ={"HCL","H202","NaOH","KOH","MG(OH)2","Al2O3","CaO","MgO","H2SO4","HNO3","H2S","NH3"
                     , "NH4CL","CaCO3","CO2","CO","Fe2O3","NaNO3","Na2CO3","NaHCO3","K2CO3","KNO3",
                      "K2O","MgCO3","NH4NO3","(NH4)2CO3","(NH4)2SO4","C10H18"

    };

    public CustomArrayINORGANIC(Activity context,
                              String[] presidents, Integer[] imageIds) {
        super(context, R.layout.inorganic, presidents);
        this.context = context;
        this.compounds = presidents;
        this.imageIds = imageIds;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
//---print the index of the row to examine---
        Log.d("CustomArrayAdapter", String.valueOf(position));
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.inorganic, null, true);
        //---get a reference to all the views on the xml layout---
        TextView txtTitle       = (TextView) rowView.findViewById(R.id.txtPresidentName);
        TextView txtDescription = (TextView)rowView.findViewById(R.id.txtDescription);
        ImageView imageView     = (ImageView) rowView.findViewById(R.id.icon);
//---customize the content of each row based on position---
        txtTitle.setText(compounds[position]);
        txtDescription.setText(compounds[position] + " Formula   "+names[position]);
        imageView.setImageResource(imageIds[position]);
        return rowView;
    }
}

