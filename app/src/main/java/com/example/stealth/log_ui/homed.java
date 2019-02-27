package com.example.stealth.log_ui;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class homed extends AppCompatActivity implements Green_doc_home.ListItemClickListener {
    String a="";
    private static int NUM_LIST_ITEMS=10;
    String name,age,gender,detail,issue;
    private Green_doc_home mAdapter;
    private RecyclerView mNumbersList;
    String value;

    private Toast mToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homep);
        Bundle extras = getIntent().getExtras();
        if(extras !=null) {
            value = extras.getString("KEY");
        }

        a=""+value;

        mNumbersList = (RecyclerView) findViewById(R.id.rv_numbers);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mNumbersList.setLayoutManager(layoutManager);
        mNumbersList.setHasFixedSize(true);
        mNumbersList.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        mAdapter = new Green_doc_home(NUM_LIST_ITEMS, this,a);
        mNumbersList.setAdapter(mAdapter);



    }

    public String an()
    {
        return a;

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
                mAdapter = new Green_doc_home(NUM_LIST_ITEMS, this,a);
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

        Intent intent = new Intent(getBaseContext(), detail_home_doc.class);

        intent.putExtra("name",mAdapter.pname.get(clickedItemIndex));
        intent.putExtra("gender",mAdapter.pgender.get(clickedItemIndex));
        intent.putExtra("age",mAdapter.age.get(clickedItemIndex));
        intent.putExtra("phone",mAdapter.phone.get(clickedItemIndex));
        intent.putExtra("address",mAdapter.addres.get(clickedItemIndex));
        intent.putExtra("desc",mAdapter.desc.get(clickedItemIndex));
        startActivity(intent);
    }
}
