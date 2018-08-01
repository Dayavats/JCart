package com.example.lenovo.jcart;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.widget.Toast;

public class LOGIN extends AppCompatActivity {
    private EditText ed1,ed2;
    private FirebaseAuth mAuth;
    String answer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ed1=(EditText)findViewById(R.id.ed1);
        ed2=(EditText)findViewById(R.id.ed2);
        mAuth=FirebaseAuth.getInstance();
    }

    public void LOGIN(View view) {
        String email=ed1.getText().toString();
        String password=ed2.getText().toString();
        if(email.equals("daya23vats@gmail.com")&&password.equals("bhumika"))
        {
            Intent i=new Intent(getApplicationContext(),Admin.class);
            startActivity(i);

        }

        Task<AuthResult> authResultTask = mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        ConnectivityManager cm = (ConnectivityManager) getApplicationContext()
                            .getSystemService(Context.CONNECTIVITY_SERVICE);
                        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
                        if (null != activeNetwork) {
                            if(activeNetwork.getType() == ConnectivityManager.TYPE_WIFI)
                                answer="You are connected to a WiFi Network";
                            if(activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE)
                                answer="You are connected to a Mobile Network";
                        }
                        else
                            answer = "No internet Connectivity";
                        Toast.makeText(getApplicationContext(), answer, Toast.LENGTH_LONG).show();


                        if (task.isSuccessful()) {
                            Intent i=new Intent(getApplicationContext(),MainActivity.class);
                            startActivity(i);

                    }
                        else{
                            Toast.makeText(getApplicationContext(),"wrong password",Toast.LENGTH_LONG).show();
                        }
                        //
                    }
                });
    }


    public void REGISTER(View view) {
        Intent intent=new Intent(getApplicationContext(),Registration.class);
        startActivity(intent);
    }

    public void FORGET(View view) {
        Intent intent=  new Intent(getApplicationContext(),Forget_password.class);
        startActivity(intent);
    }
}
