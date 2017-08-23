package com.example.mahaautomobile;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.util.LruCache;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;

/**
 * Created by Manik on 8/6/2016.
 */
public class ImageAdapter extends PagerAdapter {
    Context context ;
    ArrayList<String> imageList;
    @Override
    public int getCount() {
        return imageList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == (View)object;
    }

    public ImageAdapter(Context context, ArrayList<String> imageList) {
        this.context=context;
        this.imageList=imageList;
    }
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View viewItem = inflater.inflate(R.layout.image_item, container, false);
        NetworkImageView productImage = (NetworkImageView) viewItem.findViewById(R.id.productImage);

        String url ="http://popular-computer-setab.freehostia.com/image/"+imageList.get(position);
        ImageLoader imageLoader = new ImageLoader(Volley.newRequestQueue(context), new ImageLoader.ImageCache(){
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


        ((ViewPager)container).addView(viewItem);

        return viewItem;
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // TODO Auto-generated method stub
        ((ViewPager) container).removeView((View) object);
    }
}
