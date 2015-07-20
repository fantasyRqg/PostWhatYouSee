package com.ranqingguo.postwhatyousee;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * @Created by ranqingguo on 19/7/15.
 */
public class FLAdapter extends ArrayAdapter<String> {
    public FLAdapter(Context context, int resource, int textViewResourceId, List<String> objects) {
        super(context, resource, textViewResourceId, objects);
    }


}
