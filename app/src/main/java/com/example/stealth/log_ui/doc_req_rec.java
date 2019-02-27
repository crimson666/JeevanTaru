package com.example.stealth.log_ui;



import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class doc_req_rec extends AppCompatActivity implements green_req_doc.ListItemClickListener {
    String a;
    private static int NUM_LIST_ITEMS=10;
    String name,age,gender,detail,issue;
    private green_req_doc mAdapter;
    private RecyclerView mNumbersList;

    private Toast mToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_req_rec);

        mNumbersList = (RecyclerView) findViewById(R.id.rv_numbers);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mNumbersList.setLayoutManager(layoutManager);
        mNumbersList.setHasFixedSize(true);
        mNumbersList.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        mAdapter = new green_req_doc(NUM_LIST_ITEMS, this);
        mNumbersList.setAdapter(mAdapter);

        name= getIntent().getStringExtra("Name");
        age=getIntent().getStringExtra("age");
        gender=getIntent().getStringExtra("gender");
        detail=getIntent().getStringExtra("detail");
        issue=getIntent().getStringExtra("issue");

        a="laab";
    }

    public String an()
    {
        return "Neurologist";

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
                mAdapter = new green_req_doc(NUM_LIST_ITEMS, this);
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

        Intent intent = new Intent(getBaseContext(), doc_details.class);
        intent.putExtra("Name",mAdapter.Aname.get(clickedItemIndex));
        intent.putExtra("Speciality",mAdapter.ASpecialist.get(clickedItemIndex));
        intent.putExtra("VisitingHours",mAdapter.AVisitinghours.get(clickedItemIndex));
        intent.putExtra("PName",name);
        intent.putExtra("Phone",mAdapter.Aphone.get(clickedItemIndex));
        intent.putExtra("Address",mAdapter.AAddress.get(clickedItemIndex));
        intent.putExtra("Address",mAdapter.AAddress.get(clickedItemIndex));
        intent.putExtra("Userid",mAdapter.Auserid.get(clickedItemIndex));
        intent.putExtra("PAge",age);
        intent.putExtra("PDetails",detail);
        intent.putExtra("PGender",gender);
        startActivity(intent);
    }
}
