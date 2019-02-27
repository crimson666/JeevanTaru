package com.example.stealth.log_ui;



import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class doc_details extends Activity {
    TextView textView1,textView2,textView3,textView4,textView5;
    Button button,button4;
    String pname,paddress,page,pgender,pdetails,puserid,phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_details);
        pname=getIntent().getStringExtra("PName");
        paddress=getIntent().getStringExtra("PAge");
        page=getIntent().getStringExtra("PAddress");
        pgender=getIntent().getStringExtra("PGender");
        pdetails=getIntent().getStringExtra("PDetails");
        phone=getIntent().getStringExtra("Phone");

        textView1=(TextView)findViewById(R.id.TextView1);
        textView2=(TextView)findViewById(R.id.TextView2);
        textView3=(TextView)findViewById(R.id.TextView3);
        textView4=(TextView)findViewById(R.id.TextView4);
        textView5=(TextView)findViewById(R.id.Phone);
        button=(Button)findViewById(R.id.button);
        button4=(Button)findViewById(R.id.button4);
        Typeface myCustomFont3 = Typeface.createFromAsset(getAssets(),"fonts/Quicksand-Light.ttf");
        textView1.setTypeface(myCustomFont3);
        textView2.setTypeface(myCustomFont3);
        textView3.setTypeface(myCustomFont3);
        textView4.setTypeface(myCustomFont3);
        textView5.setTypeface(myCustomFont3);
        button.setTypeface(myCustomFont3);
        button4.setTypeface(myCustomFont3);


        Bundle extras = getIntent().getExtras();
        if (extras != null) {

            textView1.setText(textView1.getText()+" "+extras.getString("Name"));
            textView2.setText(textView2.getText()+" "+extras.getString("Speciality"));
            textView4.setText(textView4.getText()+" "+extras.getString("VisitingHours"));
            textView5.setText(textView5.getText()+" "+extras.getString("Phone"));
            textView3.setText(textView3.getText()+" "+extras.getString("Address"));
            puserid=extras.getString("Userid");
        }



    }

    public void onCall(View view)
    {
        String phone=textView5.getText().toString();
        phone="+91"+phone.substring(10);
        if (ActivityCompat.checkSelfPermission(doc_details.this,
                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        startActivity(new Intent(Intent.ACTION_CALL, Uri.fromParts("tel",phone, null)));


    }
    public void onSubmit(View view)
    {



        patient_db backWork = new patient_db(this);
        backWork.execute(pname,page,pgender,pdetails,phone,paddress);


    }


}
