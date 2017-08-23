package com.example.android.listviewwithvolley;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private ProgressDialog pDialog;
    private static final String url = "http://restframework.herokuapp.com/users/?format=json";
    private List<User> userList = new ArrayList<>();
    private ListView listView;
    private UserAdapter userAdapter;
    RequestQueue mRequestQueue;
    JSONObject jObj = null;
    JSONArray jsonArray = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userAdapter = new UserAdapter(this, userList);
        listView = (ListView) findViewById(R.id.listViewUser);
        listView.setAdapter(userAdapter);

        // Start the queue
       // mRequestQueue.start();
        mRequestQueue = Volley.newRequestQueue(this);

        // Formulate the request and handle the response.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            jObj = new JSONObject(response);
                            jsonArray = jObj.getJSONArray("results");
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject c = jsonArray.getJSONObject(i);
                                String name = c.optString("username");
                                User user = new User(name);
                                userList.add(user);


                            }

                        } catch (JSONException e) {
                            // If an error is thrown when executing any of the above statements in the "try" block,
                            // catch the exception here, so the app doesn't crash. Print a log message
                            // with the message from the exception.
                            Log.e("QueryUtils", "Problem parsing the earthquake JSON results", e);
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, "Something went wrong ... :( ", Toast.LENGTH_SHORT).show();
                    }
                });

        // Add the request to the RequestQueue.
        mRequestQueue.add(stringRequest);

    }
}
