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
 * Created by Nna-Did on 6/19/2015.
 */
public class CustomArrayAdapter extends ArrayAdapter<String> {
    private final Activity context;
    private final String[] compounds;
    private final Integer[] imageIds;
    String [] names ={"  CHEMICAL COMPS.","CH4","C2H6","C3H8","C4H10","C5H12","C6H14","C7H16","C8H18","C9H20","C10H22","C2H4","C3H6"
, "C4H8","C5H10","C6H12","C7H14","C8H16","C9H18","C10H20","C2H2","C3H4","C4H6","C5H8","C6H10","C7H12","C8H14","C9H16","C10H18"
  ,"C6H6","     "
    };

    public CustomArrayAdapter(Activity context,
                              String[] presidents, Integer[] imageIds) {
        super(context, R.layout.item_holder, presidents);
        this.context = context;
        this.compounds = presidents;
        this.imageIds = imageIds;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
//---print the index of the row to examine---
        Log.d("CustomArrayAdapter", String.valueOf(position));
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.item_holder, null, true);
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
