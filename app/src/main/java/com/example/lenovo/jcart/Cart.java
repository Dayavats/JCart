package com.example.lenovo.jcart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.app.Dialog;
import android.content.Intent;
import android.renderscript.Sampler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Cart extends AppCompatActivity {ListView listViewArtist;
    List<Cart1> uploads;
    TextView t1,t2;
    EditText e1;
    Dialog View;
    // Button b1,b2;
    String id;
    String price,quantity,total;
    private FirebaseUser current_user;
    private DatabaseReference databaseReference,userdata,cartdata;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        listViewArtist=(ListView)findViewById(R.id.listviewcart);
        uploads=new ArrayList<>();
        listViewArtist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Cart1 artist=uploads.get(i);
                id=uploads.get(i).toString();
                showUpdateDialog(artist.getItem_price());


            }
        });


        mAuth = FirebaseAuth.getInstance();
        current_user = mAuth.getCurrentUser();
        current_user = mAuth.getCurrentUser();
        String email = current_user.getEmail();
        Toast.makeText(getApplicationContext(),email,Toast.LENGTH_LONG).show();
        userdata = FirebaseDatabase.getInstance().getReference().child("Users").child(current_user.getUid());
        cartdata = FirebaseDatabase.getInstance().getReference().child("Cart");


        Query query=FirebaseDatabase.getInstance().getReference("Cart").orderByChild("email").equalTo(email);
        query.addListenerForSingleValueEvent(valueEventListener);


        //  databaseReference= FirebaseDatabase.getInstance().getReference("Cart");


    }


    //    databaseReference.addValueEventListener(new ValueEventListener() {
    ValueEventListener valueEventListener=new ValueEventListener() {

        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            uploads.clear();
            for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

                Cart1 artist1 = postSnapshot.getValue(Cart1.class);
                uploads.add(artist1);
            }
            CartAdapter artistAdapter = new CartAdapter(Cart.this, uploads);
            listViewArtist.setAdapter(artistAdapter);

        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    };





    private void showUpdateDialog(final String item_price) {
        AlertDialog.Builder dialogBuilder=new AlertDialog.Builder(this);
        LayoutInflater inflater=getLayoutInflater();;
        final View view=inflater.inflate(R.layout.dialog_box ,null);
        dialogBuilder.setView(view);

        final Button  b1=(Button) view.findViewById(R.id.button1);
        final Button b2=(Button) view.findViewById(R.id.button2);
        dialogBuilder.setTitle(id);
        final AlertDialog b=dialogBuilder.create();
        b.show();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),Order_page.class);
                i.putExtra("id",item_price);

                startActivity(i);


            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference dR=FirebaseDatabase.getInstance().getReference("Cart").child(id);
                //removing artist
                dR.removeValue();
                Toast.makeText(getApplicationContext(), " deleted", Toast.LENGTH_SHORT).show();
                b.dismiss();


            }
        });


    }
    private boolean deleteArtist(String id) {
        //getting the specified artist reference

        DatabaseReference dR = FirebaseDatabase.getInstance().getReference("Cart").child(id);

        //removing artist
        dR.removeValue();

        //getting the tracks reference for the specified artist

        Toast.makeText(getApplicationContext(), "Artist Deleted", Toast.LENGTH_LONG).show();

        return true;
    }



}

