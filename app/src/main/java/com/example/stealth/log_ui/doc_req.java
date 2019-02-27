package com.example.stealth.log_ui;



import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class doc_req extends AppCompatActivity {
    EditText name,age,details;
    Spinner patient,gender,issue;
    TextView t1,t2,t3,t4,t5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_req);

        t1=(TextView)findViewById(R.id.textView4);
        t2=(TextView)findViewById(R.id.textView5);
        t3=(TextView)findViewById(R.id.textView8);
        t4=(TextView)findViewById(R.id.textView7);
        t5=(TextView)findViewById(R.id.textView);



        gender= (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.spinner_array2, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gender.setAdapter(adapter1);


        issue= (Spinner) findViewById(R.id.spinner3);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.spinner_array, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        issue.setAdapter(adapter2);


        name=(EditText)findViewById(R.id.editText);
        age=(EditText)findViewById(R.id.editText2);
        details=(EditText)findViewById(R.id.editText3);

        Typeface myCustomFont3 = Typeface.createFromAsset(getAssets(),"fonts/Quicksand-Light.ttf");
        name.setTypeface(myCustomFont3);
        age.setTypeface(myCustomFont3);
        details.setTypeface(myCustomFont3);
        t1.setTypeface(myCustomFont3);
        t2.setTypeface(myCustomFont3);
        t3.setTypeface(myCustomFont3);
        t4.setTypeface(myCustomFont3);
        t5.setTypeface(myCustomFont3);




    }

    public void onsearch(View v)
    {


        if(name.length()==0||age.length()==0)
        {
            Toast.makeText(this,"Please Fillup Total Details",Toast.LENGTH_LONG).show();

        }
        else
        {
            Intent intent = new Intent(getBaseContext(), doc_req_rec.class);
            //  intent.putExtra("Name", name.getText().toString());
            intent.putExtra("Name", name.getText().toString());
            intent.putExtra("age", age.getText().toString());
            intent.putExtra("details", details.getText().toString());
            intent.putExtra("patient", gender.getSelectedItem().toString());
            intent.putExtra("issue", issue.getSelectedItem().toString());

            startActivity(intent);
        }
    }
}
