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

public class Green_phar_home extends  RecyclerView.Adapter<Green_phar_home.NumberViewHolder>{

    private static final String TAG = Green_phar_home.class.getSimpleName();
    ListView listView;
    ArrayAdapter<String> adapter;
    int ArraySize;
    String address="http://asuratest1996.000webhostapp.com/jeevan/phar_home.php";
    InputStream inputStream=null;
    String line = null;
    private double lati=22.647051;
    private double longi=88.431683;

    String result=null;
    String[] data;
    String name,a;

    ArrayList<Double> distance=new ArrayList<Double>();
    ArrayList<String> cname=new ArrayList<String>();
    ArrayList<String> phone=new ArrayList<String>();
    ArrayList<String> addres=new ArrayList<String>();
    ArrayList<String> latitude=new ArrayList<String>();
    ArrayList<String> longitude=new ArrayList<String>();
    ArrayList<String> age=new ArrayList<String>();
    ArrayList<String> o_desc=new ArrayList<String>();
    final private ListItemClickListener mOnClickListener;

    private static int viewHolderCount;

    private int mNumberItems;
    public String Type;

    public interface ListItemClickListener
    {
        void onListItemClick(int clickedItemIndex);
    }


    public Green_phar_home(int numberOfItems, ListItemClickListener listener, String a)
    {

        mNumberItems = numberOfItems;
        mOnClickListener = listener;
        viewHolderCount = 0;
        this.a=a;
    }

    @Override
    public NumberViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {


        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.list_view_phar_home;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImmediately);
        NumberViewHolder viewHolder = new NumberViewHolder(view);


        viewHolder.name.setText("Name: " + cname.get(viewHolderCount));
        viewHolder.visitinghours.setText("address: " + addres.get(viewHolderCount) + "");
        viewHolder.Speciality.setText("Phone Number: " + phone.get(viewHolderCount) + "");
        //viewHolder.Aphone.setText("Visiting Hours: " + Aphone.get(viewHolderCount) + "");
        viewHolder.dist.setText(distance.get(viewHolderCount)+"");


        viewHolderCount++;
        Log.d(TAG, "onCreateViewHolder: number of ViewHolders created: "
                + viewHolderCount);
        return viewHolder;


    }

    public int getdata(){

        try {
            MainActivity d1=new MainActivity();

            URL url = new URL(address+"?Type="+a);
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
                cname.add(jsonObject.getString("cname"));
                phone.add(jsonObject.getString("phone"));
                addres.add(jsonObject.getString("address"));
                o_desc.add(jsonObject.getString("o_desc"));
                longitude.add(jsonObject.getString("lat"));
                latitude.add(jsonObject.getString("lng"));



                int r = 6371; // average radius of the earth in km
                double dLat = Math.toRadians(lati - Double.parseDouble(latitude.get(i)));
                double dLon = Math.toRadians(longi - Double.parseDouble(longitude.get(i)));
                double aa = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                        Math.cos(Math.toRadians(lati)) * Math.cos(Math.toRadians( Double.parseDouble(latitude.get(i))))
                                * Math.sin(dLon / 2) * Math.sin(dLon / 2);
                double cc = 2 * Math.atan2(Math.sqrt(aa), Math.sqrt(1 - aa));
                double d = r * cc;
                distance.add(d);



            }



            //sorting Algorithm
            int n = jsonArray.length();
            double temp;
            String alter="";
            for (int i = 0; i < n; i++) {
                for (int j = 1; j < (n - i); j++) {
                    if (distance.get(j - 1) > distance.get(j)) {
                        //swap elements
                        temp = distance.get(j - 1);
                        distance.set((j - 1), distance.get(j));
                        distance.set((j), temp);

                        alter = cname.get(j - 1);
                        cname.set((j - 1), cname.get(j));
                        cname.set((j), alter);



                        alter = phone.get(j - 1);
                        phone.set((j - 1), phone.get(j));
                        phone.set((j), alter);

                        alter = latitude.get(j - 1);
                        latitude.set((j - 1), latitude.get(j));
                        latitude.set((j), alter);

                        alter = longitude.get(j - 1);
                        longitude.set((j - 1), longitude.get(j));
                        longitude.set((j), alter);

                        alter = addres.get(j - 1);
                        addres.set((j - 1), addres.get(j));
                        addres.set((j), alter);

                        alter = o_desc.get(j - 1);
                        o_desc.set((j - 1), o_desc.get(j));
                        o_desc.set((j), alter);
                    }

                }
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

        TextView name,Speciality,visitinghours,dist;

        public NumberViewHolder(View itemView) {
            super(itemView);
            //  asder();

            name = (TextView) itemView.findViewById(R.id.name);
            Speciality = (TextView) itemView.findViewById(R.id.Speciality);
            visitinghours=(TextView) itemView.findViewById(R.id.visitinghours);
            dist=(TextView) itemView.findViewById(R.id.dist);


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
