package com.android.udacity.popularmoviesapp;

import android.app.Activity;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by xatn116 on 27-10-2015.
 */
public class MovieAdapter extends ArrayAdapter<AndroidFlavor> {
    private static final String LOG_TAG = MovieAdapter.class.getSimpleName();

    public MovieAdapter(Activity context, List<AndroidFlavor> androidFlavors){
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context,0,androidFlavors);
    }



}
