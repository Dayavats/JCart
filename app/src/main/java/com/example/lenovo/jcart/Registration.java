package com.example.lenovo.jcart;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class Registration extends AppCompatActivity {
   private FirebaseAuth  mAuth;
    private EditText e1,e2,e3,e4,e5,e6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        mAuth=FirebaseAuth.getInstance();
        e1=(EditText)findViewById(R.id.e1);
        e2=(EditText)findViewById(R.id.e2);
        e3=(EditText)findViewById(R.id.e3);
        e4=(EditText)findViewById(R.id.e4);
        e5=(EditText)findViewById(R.id.e5);
        e6=(EditText)findViewById(R.id.e6);


    }


    public void regisr(View view) {
        final String name=e1.getText().toString();
        final String Emailid=e2.getText().toString();
        final String password=e3.getText().toString();
        final String mobile=e4.getText().toString();
        final String city=e5.getText().toString();
        final String pincode=e6.getText().toString();

        mAuth.createUserWithEmailAndPassword(Emailid,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(getApplicationContext(),"Registered succesfully",Toast.LENGTH_LONG).show();
                            Intent i=new Intent(getApplicationContext(),LOGIN.class);
                            startActivity(i);
                        }
                        else{

                        }
                    }
                });

    }


}
