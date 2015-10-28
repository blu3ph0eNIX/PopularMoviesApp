package com.android.udacity.popularmoviesapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
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


    private AndroidFlavorAdapter mFlavorAdapter;

    AndroidFlavor[] mAndroidFlavors = {
            new AndroidFlavor("Cupcake", "1.5", R.drawable.cupcake),
            new AndroidFlavor("Donut", "1.6", R.drawable.donut),
            new AndroidFlavor("Eclair", "2.0-2.1", R.drawable.eclair),
            new AndroidFlavor("Froyo", "2.2-2.2.3", R.drawable.froyo),
            new AndroidFlavor("GingerBread", "2.3-2.3.7", R.drawable.gingerbread),
            new AndroidFlavor("Honeycomb", "3.0-3.2.6", R.drawable.honeycomb),
            new AndroidFlavor("Ice Cream Sandwich", "4.0-4.0.4", R.drawable.icecream),
            new AndroidFlavor("Jelly Bean", "4.1-4.3.1", R.drawable.jellybean),
            new AndroidFlavor("KitKat", "4.4-4.4.4", R.drawable.kitkat),
            new AndroidFlavor("Lollipop", "5.0-5.1.1", R.drawable.lollipop)
    };

    public MainActivityFragment() {
        this.mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        this.mCurrentToast=null;
        this.mCurrentSnackbar=null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        mFlavorAdapter = new AndroidFlavorAdapter(getActivity(), Arrays.asList(mAndroidFlavors));

        // Get a reference to the ListView, and attach this adapter to it.
        ListView listView = (ListView) rootView.findViewById(R.id.listView_flavor);
        listView.setAdapter(mFlavorAdapter);

        return rootView;
    }
}
