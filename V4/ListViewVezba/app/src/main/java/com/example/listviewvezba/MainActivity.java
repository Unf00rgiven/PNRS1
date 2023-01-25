package com.example.listviewvezba;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private EditText mNewItem;
    private ArrayAdapter<String> mListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button submitBtn = findViewById(R.id.submitBtn);
        submitBtn.setOnClickListener(new MyOnClickListener());

        mNewItem =  findViewById(R.id.newItem);

        mListAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1);

        ListView list = findViewById(R.id.list);
        list.setAdapter(mListAdapter);
        list.setOnItemClickListener(new MyOnItemClickListener());
        list.setEmptyView(findViewById(R.id.emptyView));


    }

    private class MyOnClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            String item = mNewItem.getText().toString();

            if (TextUtils.isEmpty(item)) {
                mNewItem.setError(getString(R.string.error_empty_input));
                return;
            }

            mListAdapter.add(item);
        }
    }

    private class MyOnItemClickListener implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            String item = mListAdapter.getItem(position);
            mListAdapter.remove(item);
        }
    }
}
