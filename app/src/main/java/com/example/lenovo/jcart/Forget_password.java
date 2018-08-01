package com.example.lenovo.jcart;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class Forget_password extends AppCompatActivity {
    EditText ed1;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        ed1=(EditText)findViewById(R.id.fged);
        mAuth=FirebaseAuth.getInstance();
    }

    public void forgot(View view) {
        String email=ed1.getText().toString();
        mAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

                if(task.isComplete())
                {
                    Toast.makeText(getApplicationContext(),"your reset password request has sent",Toast.LENGTH_LONG).show();

            }
            else {
                    Toast.makeText(getApplicationContext(), "invalid email id", Toast.LENGTH_LONG).show();

                }    }
        });


    }
    }