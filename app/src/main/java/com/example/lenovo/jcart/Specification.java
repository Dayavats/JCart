package com.example.lenovo.jcart;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

public class Specification extends AppCompatActivity {
    private String item_key = null;
    private DatabaseReference mRef, userdata;
    private TextView e1, e2, e3;
    private ImageView image;
    private Button order;
    private DatabaseReference mRef1;
    private FirebaseAuth mAuth;
    private FirebaseUser current_user;
    private Uri uri = null;
    private StorageReference storageReference;
    private DatabaseReference databaseReference;
    String  item_price, item_image,brand,name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specification);

        item_key = getIntent().getExtras().getString("itemid");
        mRef = FirebaseDatabase.getInstance().getReference().child("Items");
        mRef1 = FirebaseDatabase.getInstance().getReference().child("Cart");
        e1 = (TextView) findViewById(R.id.t1s);
        e2 =(TextView) findViewById(R.id.t2s);
        e3 = (TextView) findViewById(R.id.t3s);
        image = (ImageView) findViewById(R.id.images);
        order = (Button) findViewById(R.id.button1);
        mAuth = FirebaseAuth.getInstance();
        current_user = mAuth.getCurrentUser();


        userdata = FirebaseDatabase.getInstance().getReference().child("Users").child(current_user.getUid());
        mRef.child(item_key).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                item_price = (String) dataSnapshot.child("price").getValue();
                item_image = (String) dataSnapshot.child("image").getValue();
                brand=(String)dataSnapshot.child("brand").getValue();
                name=(String)dataSnapshot.child("name").getValue();
                e1.setText(name);
                e2.setText(brand);
                e3.setText(item_price);

                Picasso.with(getApplicationContext()).load(item_image).into(image);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    public void oder(View view) {
        final DatabaseReference newOrder = mRef1.push();
        userdata.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                newOrder.child("item_price").setValue(item_price);
                newOrder.child("brand").setValue(brand);
                newOrder.child("name").setValue(name);
                current_user = FirebaseAuth.getInstance().getCurrentUser();
                String email = current_user.getEmail();
                newOrder.child("email").setValue(email);


                newOrder.child("username").setValue(dataSnapshot.child("Name").getValue()).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        startActivity(new Intent(getApplicationContext(),Cart.class));

                    }
                });
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }}


