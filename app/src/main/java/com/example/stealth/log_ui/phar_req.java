package com.example.stealth.log_ui;



import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class phar_req extends AppCompatActivity implements Green_req_phar.ListItemClickListener {

    private static int NUM_LIST_ITEMS=10;

    private Green_req_phar mAdapter;
    private RecyclerView mNumbersList;

    private Toast mToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phar_req);
        mNumbersList = (RecyclerView) findViewById(R.id.rv_numbers);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mNumbersList.setLayoutManager(layoutManager);
        mNumbersList.setHasFixedSize(true);
        mNumbersList.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        mAdapter = new Green_req_phar(NUM_LIST_ITEMS, this);
        mNumbersList.setAdapter(mAdapter);

        // Toast.makeText(this,mAdapter.Aname.get(1),Toast.LENGTH_LONG).show();


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int itemId = item.getItemId();

        switch (itemId) {
            case R.id.action_refresh:
                // COMPLETED (14) Pass in this as the ListItemClickListener to the GreenAdapter constructor
                NUM_LIST_ITEMS=mAdapter.ArraySize;
                mAdapter = new Green_req_phar(NUM_LIST_ITEMS, this);
                mNumbersList.setAdapter(mAdapter);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }



    @Override
    public void onListItemClick(int clickedItemIndex) {

        if (mToast != null) {
            mToast.cancel();
        }

        Intent intent = new Intent(getBaseContext(), phar_req_details.class);
        intent.putExtra("Name",mAdapter.Aname.get(clickedItemIndex));
        intent.putExtra("VisitingHours",mAdapter.AVisitinghours.get(clickedItemIndex));
        startActivity(intent);
    }
}
