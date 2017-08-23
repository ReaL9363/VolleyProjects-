package com.example.mahaautomobile;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ProductdetailsActivity extends AppCompatActivity {
    Product selectedProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productdetails);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            selectedProduct = bundle.getParcelable("selectedProduct");
        }
        setTitle(selectedProduct.getModelName());

        ViewPager imagePager = (ViewPager) findViewById(R.id.imagePager);
        TextView txtMileage = (TextView) findViewById(R.id.txtMileage);
        TextView txtEngine = (TextView) findViewById(R.id.txtEngine);
        TextView txtFuelType = (TextView) findViewById(R.id.txtFuelType);
        TextView txtBodyType = (TextView) findViewById(R.id.txtBodyType);
       // TextView txtModelName = (TextView) findViewById(R.id.txtModelName);
        TextView txtCondition = (TextView) findViewById(R.id.txtCondition);
        TextView txtBrand = (TextView) findViewById(R.id.txtBrand);
        TextView txtModelYear = (TextView) findViewById(R.id.txtModelYear);
        TextView txtProductDes = (TextView) findViewById(R.id.txtProductDes);
        TextView txtProductPrice = (TextView) findViewById(R.id.txtProductPrice);
        Button btnCall = (Button) findViewById(R.id.btnCall);
        Button btnMassage = (Button) findViewById(R.id.btnMassage);

        txtMileage.setText(selectedProduct.getMileage());
        txtEngine.setText(selectedProduct.getEngineCapacity());
        txtFuelType.setText(selectedProduct.getFuelType());
        txtBodyType.setText(selectedProduct.getBodyType());
       // txtModelName.setText(selectedProduct.getModelName());
        txtCondition.setText(selectedProduct.getCondition());
        txtBrand.setText(selectedProduct.getBrand());
        txtModelYear.setText(selectedProduct.getModelYear());
        txtProductDes.setText(selectedProduct.getDiscription());
        txtProductPrice.setText(selectedProduct.getPrice());
        ImageAdapter adapter = new ImageAdapter(ProductdetailsActivity.this, selectedProduct.getImage());
        imagePager.setAdapter(adapter);
        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("tel:" + Product.getMobile());
                Intent callIntent = new Intent(Intent.ACTION_CALL, uri);
                if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                                       return;
                }
                startActivity(callIntent);
            }
        });
        btnMassage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("smsto:"+ Product.getMobile());
                Intent it = new Intent(Intent.ACTION_SENDTO, uri);
                it.putExtra("sms_body", "I am interested to get more information about "+selectedProduct.getModelName());
                startActivity(it);
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
