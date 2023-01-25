package com.example.customadapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<Element> list;

    public MyAdapter(Context mContext) {
        this.mContext = mContext;
        list = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        Object o = null;
        try {
            o = list.get(i);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return o;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public void addElement(Element e) {
        list.add(e);
        notifyDataSetChanged();
    }

    public void removeElementByIndex(int i) {
        list.remove(i);
        notifyDataSetChanged();
    }

    public void removeElementByValue(Element e) {
        list.remove(e);
        notifyDataSetChanged();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        Log.d("Adapter_TAG", "getView");
        if (view == null) {
            Log.d("Adapter_TAG", "getView - null");
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.row, null);
            viewHolder = new ViewHolder();
            viewHolder.textViewItem = view.findViewById(R.id.row_text);
            viewHolder.imageViewItem = view.findViewById(R.id.row_image);
            viewHolder.buttonItem = view.findViewById(R.id.row_button);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        Element element = (Element) getItem(i);

        viewHolder.textViewItem.setText(element.getmText());
        if (element.isCheckText()) {
            viewHolder.textViewItem.setTextColor(Color.RED);
            viewHolder.textViewItem.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        } else {
            viewHolder.textViewItem.setTextColor(Color.BLACK);
            viewHolder.textViewItem.setPaintFlags(Paint.ANTI_ALIAS_FLAG);
        }

        viewHolder.imageViewItem.setImageDrawable(element.getmImage());

        viewHolder.buttonItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewHolder.textViewItem.setTextColor(Color.RED);
                viewHolder.textViewItem.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
            }
        });

        return view;
    }

    static class ViewHolder {
        TextView textViewItem;
        ImageView imageViewItem;
        Button buttonItem;
    }
}
