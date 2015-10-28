package com.android.udacity.popularmoviesapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.Arrays;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    /** Current class simple name, MainActivityFragment, added as Log Tag. */
    private static final String LOG_TAG = MainActivityFragment.class.getSimpleName();

    private SharedPreferences   mSharedPreferences;
    private Toast               mCurrentToast;
    private Snackbar            mCurrentSnackbar;

    private MovieAdapter mMovieAdapter;

    MovieInfo[] mMoviesInfo = {
            new MovieInfo("Cupcake", "1.5", "", R.drawable.cupcake),
            new MovieInfo("Donut", "1.6", "", R.drawable.donut),
            new MovieInfo("Eclair", "2.0-2.1", "", R.drawable.eclair),
            new MovieInfo("Froyo", "2.2-2.2.3", "", R.drawable.froyo),
            new MovieInfo("GingerBread", "2.3-2.3.7", "", R.drawable.gingerbread),
            new MovieInfo("Honeycomb", "3.0-3.2.6", "", R.drawable.honeycomb),
            new MovieInfo("Ice Cream Sandwich", "4.0-4.0.4", "", R.drawable.icecream),
            new MovieInfo("Jelly Bean", "4.1-4.3.1", "", R.drawable.jellybean),
            new MovieInfo("KitKat", "4.4-4.4.4", "", R.drawable.kitkat),
            new MovieInfo("Lollipop", "5.0-5.1.1", "", R.drawable.lollipop)
    };

    public MainActivityFragment() {
        this.mCurrentToast=null;
        this.mCurrentSnackbar=null;
    }

    @Override
    public void onStart() {
        super.onStart();
        this.mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        mMovieAdapter = new MovieAdapter(getActivity(), Arrays.asList(mMoviesInfo));

        // Get a reference to the GridView, and attach this adapter to it.
        GridView gridView = (GridView) rootView.findViewById(R.id.gridView_movieGrid);
        gridView.setAdapter(mMovieAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                if(mCurrentToast != null) mCurrentToast.cancel();
                mCurrentToast.makeText(getActivity(), "" + position,
                        Toast.LENGTH_LONG).show();
            }
        });

        return rootView;
    }
}
