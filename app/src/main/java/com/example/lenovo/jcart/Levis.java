package com.example.lenovo.jcart;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.squareup.picasso.Picasso;

public class Levis extends AppCompatActivity {
    private RecyclerView list;
    private Query mref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levis);
        list=(RecyclerView)findViewById(R.id.rv);
        list.setHasFixedSize(true);
        list.setLayoutManager(new LinearLayoutManager(this));
        mref= FirebaseDatabase.getInstance().getReference().child("Items").orderByChild("brand").equalTo("LEVIS");

    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<Jeans,Levis.ItemViewHolder> FBRA=new FirebaseRecyclerAdapter<Jeans,Levis.ItemViewHolder>(
                Jeans.class,
                R.layout.view_layout,
                Levis.ItemViewHolder.class,
                mref
        ) {
            @Override
            protected void populateViewHolder(Levis.ItemViewHolder viewHolder, Jeans model, int position) {
                // viewHolder.setpr(model.name);
                viewHolder.setName(model.name);
                viewHolder.setPrice(model.price);
                viewHolder.setImage(getApplicationContext(),model.getImage());
                final String item_key=getRef(position).getKey().toString();
                viewHolder.mView.setOnClickListener(new View.OnClickListener(){
                    @Override
                            public void onClick(View v){

                        Intent i = new Intent(getApplicationContext(), Specification.class);
                    i.putExtra("itemid",item_key);

                        startActivity(i);
                    }
                });
            }
        };
        list.setAdapter(FBRA);

    }
    public static class ItemViewHolder extends RecyclerView.ViewHolder{
        View mView;
        public ItemViewHolder(View itemView) {
            super(itemView);
            mView=itemView;
        }
        /*  public void setGender(String gender){
              TextView b_gender=(TextView)mView.findViewById(R.id.textView);
              b_gender.setText(gender);
          }*/
        public void setName(String name){
            TextView b_name=(TextView)mView.findViewById(R.id.nt1);
            b_name.setText(name);
        }
        public void setPrice(String price){
            TextView b_price=(TextView)mView.findViewById(R.id.pt1);
            b_price.setText(price);
        }
        public void setImage(Context ctx, String image){
            ImageView b_image=(ImageView)mView.findViewById(R.id.im1);
            //Picasso.With(ctx).load(image).into(b_image);
            Picasso.with(ctx).load(image).into(b_image);
        }
    }
}


