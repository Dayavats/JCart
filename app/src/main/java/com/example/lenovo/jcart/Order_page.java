package com.example.lenovo.jcart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;



public class Order_page extends AppCompatActivity {
    private String item_key= null;
    TextView t1,t2;
    EditText e1,e2,e3,e4,e5;
    DatabaseReference databaseReference;
    //  ProgressDialog progressDialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_page);
        item_key = getIntent().getExtras().getString("id");
        t1=(TextView) findViewById(R.id.tc1);
        t2=(TextView) findViewById(R.id.tc2);
        e1=(EditText)findViewById(R.id.ec1);
        e2= (EditText) findViewById(R.id.ec2);
        e3= (EditText) findViewById(R.id.ec3);
        e4= (EditText) findViewById(R.id.ec4);
        e5= (EditText) findViewById(R.id.ec5);
        t1.setText(item_key);
        databaseReference= FirebaseDatabase.getInstance().getReference("Order");
        //  progressDialog=new ProgressDialog(this);

        /*
         */
    }

    public void update(View view) {

        double a=Double.parseDouble(item_key);
        String e=e1.getText().toString();
        Double f=Double.parseDouble(e);
        Double n=a*f;
        String result=String.valueOf(n);
        t2.setText(result);
    }

    public void delete(View view) {

    }

    public void Order(View view) {

        //progressDialog.setMessage("uploading.....");
        // progressDialog.show();
        String name = e2.getText().toString().trim();
        String phone = e3.getText().toString().trim();
        String email = e4.getText().toString().trim();
        String address = e5.getText().toString().trim();
        String quantity = e1.getText().toString().trim();
        String price=t1.getText().toString().trim();
        String total=t2.getText().toString().trim();
        String id=databaseReference.push().getKey();


        if(TextUtils.isEmpty(name))
        {
            e2.setError("Required!!!");
        }
        if(TextUtils.isEmpty(phone))
        {
            e3.setError("Required!!!");
        }
        if(TextUtils.isEmpty(email))
        {
            e4.setError("Required!!!");
        }
        if(TextUtils.isEmpty(address))
        {
            e5.setError("Required!!!");
        }

        else {


            Details detail = new Details(id, name, phone, email, address, price, quantity, total);
            databaseReference.child(id).setValue(detail);
            // progressDialog.dismiss();
            Uri uri = Uri.parse("https://www.payumoney.com/paybypayumoney/#/308D99EC26DEF17E9B1C884D00591D7A");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);

        }



    }


}

