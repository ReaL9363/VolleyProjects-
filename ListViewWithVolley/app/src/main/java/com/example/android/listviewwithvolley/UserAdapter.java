package com.example.android.listviewwithvolley;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ReaL PC on 11/22/2016.
 */

public class UserAdapter extends ArrayAdapter<User> {
    private static final String LOG_TAG = UserAdapter.class.getSimpleName();

    public UserAdapter(Context context, List<User> userList) {
        super(context, 0, userList);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.user_list_row, parent, false);
        }
        User currentDoctor = getItem(position);
        TextView tvDoctorName = (TextView) listItemView.findViewById(R.id.tvDoctorName);
        tvDoctorName.setText(currentDoctor.getUserName());

        return listItemView;

    }
}
