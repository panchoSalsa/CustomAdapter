package com.example.franciscofranco.customadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by FranciscoFranco on 7/12/16.
 */
public class ContactListAdapter extends BaseAdapter {
    Context context;
    ArrayList<ContactListItems> contactList;

    public ContactListAdapter(Context context, ArrayList<ContactListItems> list) {
        this.context = context;
        contactList = list;
    }


    @Override
    public int getCount() {
        return contactList.size();
    }

    @Override
    public Object getItem(int position) {
        return contactList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ContactListItems contactListItems = contactList.get(position);

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(
                    Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.contact_list_row,null);
        }

        TextView tvSlNo = (TextView) convertView.findViewById(R.id.tv_slno);
        tvSlNo.setText(contactListItems.getSlno());
        TextView tvName = (TextView) convertView.findViewById(R.id.tv_name);
        tvName.setText(contactListItems.getName());
        TextView tvPhone = (TextView) convertView.findViewById(R.id.tv_phone);
        tvPhone.setText(contactListItems.getPhone());

        return convertView;
    }
}
