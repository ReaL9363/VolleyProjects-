package com.example.android.volleyjsonarray;

import android.content.Context;

import com.android.volley.toolbox.JsonArrayRequest;

import java.util.ArrayList;

/**
 * Created by ReaL PC on 11/20/2016.
 */

public class BackGroundTask {
    Context context;
    ArrayList<Doctor> arrayList = new ArrayList<>();


    public BackGroundTask(Context context) {
        this.context = context;
    }

    public ArrayList<Doctor> getArrayList() {
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest();

        return null;
    }
}
