package com.example.stealth.log_ui;



import android.content.Context;
import android.os.StrictMode;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class Green_req_phar extends  RecyclerView.Adapter<Green_req_phar.NumberViewHolder>{

    private static final String TAG = Green_req_phar.class.getSimpleName();
    ListView listView;
    ArrayAdapter<String> adapter;
    int ArraySize;
    String address ="http://asuratest1996.000webhostapp.com/jeevan/pharmacy.php";
    InputStream inputStream=null;
    String line = null;
    String result=null;
    String[] data;

    ArrayList<String> Aname=new ArrayList<String>();
    ArrayList<String> AVisitinghours=new ArrayList<String>();

    final private ListItemClickListener mOnClickListener;

    private static int viewHolderCount;

    private int mNumberItems;

    public interface ListItemClickListener
    {
        void onListItemClick(int clickedItemIndex);
    }


    public Green_req_phar(int numberOfItems, ListItemClickListener listener)
    {

        mNumberItems = numberOfItems;
        mOnClickListener = listener;
        viewHolderCount = 0;
    }

    @Override
    public NumberViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {


        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.list_req_phar;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImmediately);
        NumberViewHolder viewHolder = new NumberViewHolder(view);


        viewHolder.name.setText("Name: " + Aname.get(viewHolderCount));
        viewHolder.visitinghours.setText(" Visiting Hours: " + AVisitinghours.get(viewHolderCount) + "");


        viewHolderCount++;
        Log.d(TAG, "onCreateViewHolder: number of ViewHolders created: "
                + viewHolderCount);
        return viewHolder;


    }


    public int getdata(){

        try {
            URL url = new URL(address);
            HttpURLConnection httpURLConnection= (HttpURLConnection)url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            inputStream = new BufferedInputStream(httpURLConnection.getInputStream());
        }
        catch (Exception e){
            e.printStackTrace();
        }

        try {
            BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder stringBuilder=new StringBuilder();
            while((line=bufferedReader.readLine())!=null){
                stringBuilder.append(line+"\n");


            }
            inputStream.close();
            result=stringBuilder.toString();
        }
        catch (Exception e){
            e.printStackTrace();
        }


        //parse jason

        try{
            JSONArray jsonArray= new JSONArray(result);
            JSONObject jsonObject=null;
            data =new String[jsonArray.length()];
            ArraySize=jsonArray.length();
            for(int i=0;i<jsonArray.length();i++){
                jsonObject=jsonArray.getJSONObject(i);
                Aname.add(jsonObject.getString("spname"));
                AVisitinghours.add(jsonObject.getString("vhour"));
            }


        }

        catch (Exception e){
            e.printStackTrace();
        }
        return ArraySize;
    }


    @Override
    public void onBindViewHolder(NumberViewHolder holder, int position) {
    }
    @Override
    public int getItemCount() {

        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitNetwork().build());

        return getdata();
    }






    class NumberViewHolder extends RecyclerView.ViewHolder
            implements OnClickListener {

        TextView name,Speciality,visitinghours;

        public NumberViewHolder(View itemView) {
            super(itemView);
            //  asder();

            name = (TextView) itemView.findViewById(R.id.name);
            visitinghours=(TextView) itemView.findViewById(R.id.visitinghours);


            // COMPLETED (7) Call setOnClickListener on the View passed into the constructor (use 'this' as the OnClickListener)
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            int clickedPosition = getAdapterPosition();
            mOnClickListener.onListItemClick(clickedPosition);

        }






    }
}
