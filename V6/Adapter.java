package com.example.vezba6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter extends BaseAdapter {
    private ArrayList<Task> mTasks;
    private Context mcontext;

    public Adapter(Context mcontext) {
        this.mTasks = new ArrayList<Task>();
        this.mcontext = mcontext;
    }

    public void addTask(Task task){
        mTasks.add(task);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mTasks.size();
    }

    @Override
    public Object getItem(int i) {
        Object returnObject = null;

        try{
            returnObject = mTasks.get(i);
        }catch(IndexOutOfBoundsException e){
            e.printStackTrace();
        }

        return returnObject;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public void addTask(String taskName) {
        Task task = new Task(taskName, false);
        mTasks.add(task);
        notifyDataSetChanged();
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        View view = convertView;

        if(view == null){
            LayoutInflater inflater = (LayoutInflater)mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.row_element, null);

            ViewHolder holder = new ViewHolder();
                holder.image = view.findViewById(R.id.image1);
                holder.text = view.findViewById(R.id.text1);
                holder.box = view.findViewById(R.id.box1);
                view.setTag(holder);
        }

        Task task = (Task) getItem(i);
        ViewHolder holder = (ViewHolder) view.getTag();

        //TODO ako ne bude radilo onda je do vidljivosti
        holder.image.setImageDrawable(task.mImage);
        holder.text.setText(task.mText);
        holder.box.setChecked(task.mCheckBox);

        return view;
    }

    private class ViewHolder{
        public ImageView image = null;
        public TextView text = null;
        public CheckBox box = null;
    }
}