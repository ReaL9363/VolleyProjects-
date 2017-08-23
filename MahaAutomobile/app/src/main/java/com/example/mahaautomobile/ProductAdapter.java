package com.example.mahaautomobile;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.Volley;

import java.util.List;

/**
 * Created by Mahabuba on 7/19/2016.
 */
public class ProductAdapter extends ArrayAdapter<Product>{
    public ProductAdapter(Context context, List<Product> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Product aProduct = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.product_view, parent, false);
        }

        TextView txtModelName = (TextView) convertView.findViewById(R.id.txtModelName);
        TextView txtMileage = (TextView) convertView.findViewById(R.id.txtMileage);
        TextView txtEngineCapacity = (TextView) convertView.findViewById(R.id.txtEngineCapacity);
        TextView txtFuelType = (TextView) convertView.findViewById(R.id.txtFuelType);
        TextView txtProductPrice = (TextView) convertView.findViewById(R.id.txtProductPrice);
        TextView txtDetails = (TextView) convertView.findViewById(R.id.txtDetails);

        NetworkImageView productImage = (NetworkImageView) convertView.findViewById(R.id.productImage);



        String url ="http://popular-computer-setab.freehostia.com/image/"+aProduct.getImage().get(0);
        ImageLoader imageLoader = new ImageLoader(Volley.newRequestQueue(getContext()), new ImageLoader.ImageCache(){
            private final LruCache<String, Bitmap> mCache = new LruCache<String, Bitmap>(10);
            @Override
            public Bitmap getBitmap(String url) {
                return mCache.get(url);
            }

            @Override
            public void putBitmap(String url, Bitmap bitmap) {
                mCache.put(url, bitmap);
            }
        });
        productImage.setImageUrl(url,imageLoader);


        txtModelName.setText(aProduct.getModelName());
        txtEngineCapacity.setText(aProduct.getEngineCapacity());
        txtFuelType.setText(aProduct.getFuelType());
        txtMileage.setText(aProduct.getMileage());
        txtProductPrice.setText(aProduct.getPrice());
        txtModelName.setTag(aProduct);
        return convertView;
    }
}
