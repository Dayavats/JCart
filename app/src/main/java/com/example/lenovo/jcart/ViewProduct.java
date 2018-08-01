package com.example.lenovo.jcart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ViewProduct extends AppCompatActivity {
    private ListView listview;
    DatabaseReference databaseReference;
    List<Jeans> jeans;
 //   Integer[]imageid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_product);
        databaseReference= FirebaseDatabase.getInstance().getReference("Items");
        listview=(ListView)findViewById(R.id.lstvw);
        jeans=new ArrayList<>();
    }

    @Override
    protected void onStart() {
        super.onStart();
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                jeans.clear();
                for (DataSnapshot snapshot:dataSnapshot.getChildren())
                {
                    Jeans jean=snapshot.getValue(Jeans.class);
                    jeans.add(jean);
                }
                JeansAdapter jeansAdapter=new JeansAdapter(ViewProduct.this,jeans);
                listview.setAdapter(jeansAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}

