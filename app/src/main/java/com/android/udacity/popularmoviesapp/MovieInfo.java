package com.android.udacity.popularmoviesapp;

/**
 * Created by xatn116 on 28-10-2015.
 */
public class MovieInfo {
    public String name;
    public String size;
    public String path;
    public int image;   // drawable reference id

    public MovieInfo(String _name, String _size, String _path, int _image){
        this.name = _name;
        this.size = _size;
        this.path = _path;
        this.image = _image;
    }
}
