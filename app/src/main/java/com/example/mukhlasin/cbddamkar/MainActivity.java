package com.example.mukhlasin.cbddamkar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.mukhlasin.cbddamkar.adaters.ListHistoryAdapter;
import com.example.mukhlasin.cbddamkar.utils.HistoryData;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private static final String TAG = MainActivity.class.getSimpleName();

    List<HistoryData> historyDataList = new ArrayList<>();
    ListHistoryAdapter mAdapters;
    AdapterView.OnItemClickListener listener;
    private Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.custom_toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        }
        getSupportActionBar().setTitle(R.string.app_name);
        getSupportActionBar().setIcon(R.drawable.ic_memory_black_24dp);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                Intent intent = new Intent(MainActivity.this, UploadFormActivity.class);
                startActivity(intent);
            }
        });

        RecyclerView recyclerView = findViewById(R.id.recyclerHistory);

        mAdapters = new ListHistoryAdapter(activity, historyDataList, (ListHistoryAdapter.ListHistoryAdapterListener) listener);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(mAdapters);

        prepareHistoryData();
    }

    private void prepareHistoryData() {
        HistoryData historyData = new HistoryData("Gunung Merapi Kembali Mengeluarkan Wedus Gembel", "Tugu Pancoraan");
        historyDataList.add(historyData);

        historyData = new HistoryData("KERUNTUHAN2", "Mana Saja2");
        historyDataList.add(historyData);

        historyData = new HistoryData("KERUNTUHAN3", "Mana Saja3");
        historyDataList.add(historyData);

        historyData = new HistoryData("KERUNTUHAN1", "Mana Saja1");
        historyDataList.add(historyData);

        historyData = new HistoryData("KERUNTUHAN2", "Mana Saja2");
        historyDataList.add(historyData);

        historyData = new HistoryData("KERUNTUHAN3", "Mana Saja3");
        historyDataList.add(historyData);

        historyData = new HistoryData("KERUNTUHAN1", "Mana Saja1");
        historyDataList.add(historyData);

        historyData = new HistoryData("KERUNTUHAN2", "Mana Saja2");
        historyDataList.add(historyData);

        historyData = new HistoryData("KERUNTUHAN3", "Mana Saja3");
        historyDataList.add(historyData);

        historyData = new HistoryData("KERUNTUHAN1", "Mana Saja1");
        historyDataList.add(historyData);

        historyData = new HistoryData("KERUNTUHAN2", "Mana Saja2");
        historyDataList.add(historyData);

        historyData = new HistoryData("KERUNTUHAN3", "Mana Saja3");
        historyDataList.add(historyData);

        historyData = new HistoryData("KERUNTUHAN1", "Mana Saja1");
        historyDataList.add(historyData);

        historyData = new HistoryData("KERUNTUHAN2", "Mana Saja2");
        historyDataList.add(historyData);

        historyData = new HistoryData("KERUNTUHAN3", "Mana Saja3");
        historyDataList.add(historyData);

        mAdapters.notifyDataSetChanged();


        Log.d(TAG,"mtest" +  historyDataList);

    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        HistoryData product = (HistoryData) parent.getItemAtPosition(position);
        Toast.makeText(activity, product.toString(), Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();

        /*get popup from res>menu*/
        inflater.inflate(R.menu.activity_main_damkar_bar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.ListHistory: {
                Intent r = new Intent(MainActivity.this, UploadFormActivity.class);
                startActivity(r);
            }
            return true;
            case R.id.LogOut: {
                Intent r = new Intent(MainActivity.this, DetailActivity.class);
                startActivity(r);
            }
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
