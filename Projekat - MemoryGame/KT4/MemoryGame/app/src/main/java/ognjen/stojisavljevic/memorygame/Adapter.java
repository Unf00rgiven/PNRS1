package ognjen.stojisavljevic.memorygame;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;

public class Adapter extends BaseAdapter{
    private Context mContext;
    private ArrayList<Element> mList;
    PlayerDBHelper dbHelper;
    String Username;
    String deleteURL = "http://192.168.1.117:3000/score/?username=";
    HttpHelper httpHelper = new HttpHelper();

    public Adapter(Context mContext,String username) {
        this.mContext = mContext;
        mList = new ArrayList<Element>();
        dbHelper = new PlayerDBHelper(mContext);
        Username = username;
        deleteURL += username;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int i) {
        Object o = null;

        try{
            o = mList.get(i);
        }catch (Exception e){
            e.printStackTrace();
        }
        return o;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public void addElement(Element element){
        mList.add(element);
        notifyDataSetChanged();
    }

    public void removeElementByPosition(int i){
        mList.remove(mList.get(i));
        notifyDataSetChanged();
    }

    public void delete()
    {
        mList.clear();
        notifyDataSetChanged();
    }

    public ArrayList<Integer> resultsList(String username) {
        ArrayList<Integer> tmp = new ArrayList<>();

        for (int i = 0; i < mList.size(); i++) {
            if (mList.get(i).getUsername().equals(username)) {
                for (Integer j : mList.get(i).getResults()) {
                    tmp.add(j);
               }
            }
        }
        return tmp;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null){
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.model, null);

            ViewHolder vh = new ViewHolder();
            vh.username = view.findViewById(R.id.username);
            vh.email = view.findViewById(R.id.email);
            vh.best = view.findViewById(R.id.best);
            vh.worst = view.findViewById(R.id.worst);
            vh.bestResult = view.findViewById(R.id.bestResult);
            vh.worstResult = view.findViewById(R.id.worstResult);
            vh.button = view.findViewById(R.id.removeButton);
            vh.button.setTag(i);
            view.setTag(vh);
        }

        Element element = (Element) getItem(i);
        ViewHolder holder = (ViewHolder) view.getTag();

        holder.username.setText(element.getUsername());
        holder.email.setText(element.getEmail());
        holder.best.setText(element.getBest());
        holder.worst.setText(element.getWorst());
        holder.bestResult.setText(element.getBestResult());
        holder.worstResult.setText(element.getWorstResult());

        if(holder.username.getText().toString().equals(Username)){
            holder.button.setEnabled(true);
        } else {
            holder.button.setEnabled(false);
        }


        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    if(holder.username.getText().toString().equals(Username)) {
                        removeElementByPosition(i);
                        dbHelper.delete((String) holder.username.getText());
                        notifyDataSetChanged();
                    }
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                httpHelper.httpDelete(deleteURL);
                            } catch (IOException e) {
                                e.printStackTrace();
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }).start();
            }
        });

        return view;
    }

    private class ViewHolder{
        public TextView username = null;
        public TextView email = null;
        public TextView best = null;
        public TextView worst = null;
        public TextView bestResult = null;
        public TextView worstResult = null;
        public Button button = null;

    }
}
