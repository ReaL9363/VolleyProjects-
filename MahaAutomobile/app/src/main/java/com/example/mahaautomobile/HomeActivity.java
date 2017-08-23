package com.example.mahaautomobile;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

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

public class HomeActivity extends AppCompatActivity {
    JSONObject jObj = null;
    JSONArray jsonArray = null;
    ArrayList<Product> products;
    ListView listview;
    String url = "http://popular-computer-setab.freehostia.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        listview = (ListView) findViewById(R.id.listview);
        setTitle("Home");

        products = new ArrayList<>();

        RequestQueue queue = Volley.newRequestQueue(this);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {


                        try {
                            jObj = new JSONObject(response);
                            jsonArray = jObj.getJSONArray("data");
                            String mobileNo=jObj.getString("MobileNo");
                            Product.setMobile(mobileNo);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject c = jsonArray.getJSONObject(i);

                                ArrayList<String> imageList = new ArrayList<>();
                                JSONArray imageArray = c.getJSONArray("Image");
                                for (int j = 0; j < imageArray.length(); j++) {
                                    imageList.add(imageArray.getString(j));
                                }

                                String brand = c.getString("Brand");
                                String modelYear = c.getString("Model_year");
                                String condition = c.getString("Condition");
                                String modelName = c.getString("Model_name");
                                String bodyType = c.getString("Body_type");
                                String fuelType = c.getString("Fuel_type");
                                String engineCapacity = c.getString("Engine_capacity");
                                String mileage = c.getString("Mileage");
                                String price = c.getString("Price");
                                String discription = c.getString("Discription");

                                Product product = new Product();
                                product.setImage(imageList);
                                product.setBrand(brand);
                                product.setModelYear(modelYear);
                                product.setCondition(condition);
                                product.setModelName(modelName);
                                product.setBodyType(bodyType);
                                product.setFuelType(fuelType);
                                product.setEngineCapacity(engineCapacity);
                                product.setMileage(mileage);
                                product.setPrice(price);
                                product.setDiscription(discription);
                                products.add(product);
                            }

                        } catch (JSONException e) {
                            Log.e("JSON Parser", "Error parsing data " + e.toString());
                        }

                        ProductAdapter adapter = new ProductAdapter(getApplicationContext(), products);
                        listview.setAdapter(adapter);


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(stringRequest);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Product selectedProduct = (Product) view.findViewById(R.id.txtModelName).getTag();
                Intent intent = new Intent(getApplicationContext(), ProductdetailsActivity.class);

                intent.putExtra("selectedProduct", (Parcelable) selectedProduct);
                startActivity(intent);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.create_new:
                Intent intent =new Intent(this,AboutUs.class);
                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
