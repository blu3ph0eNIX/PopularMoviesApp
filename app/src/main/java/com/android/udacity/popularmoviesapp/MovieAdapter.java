package com.android.udacity.popularmoviesapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by xatn116 on 27-10-2015.
 */
public class MovieAdapter extends ArrayAdapter<MovieInfo> {
    private static final String LOG_TAG = MovieAdapter.class.getSimpleName();

    public MovieAdapter(Activity context, List<MovieInfo> movieInfoList){
        super(context,0,movieInfoList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MovieInfo movieInfo = getItem(position);

        // Adapters recycle views to AdapterViews.
        // If this is a new View object we're getting, then inflate the layout.
        // If not, this view already has the layout inflated from a previous call to getView,
        // and we modify the View widgets as usual.
        if(convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.grid_item_movie,parent,false);

        ImageView imageView = (ImageView)convertView.findViewById(R.id.grid_item_imageView);
        imageView.setImageResource(movieInfo.image);

        TextView textView = (TextView)convertView.findViewById(R.id.grid_item_textView);
        textView.setText(movieInfo.name);

        return convertView;
    }
}
