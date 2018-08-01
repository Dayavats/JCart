package com.example.lenovo.jcart;

/**
 * Created by Lenovo on 7/12/2018.
 */

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;


public class CartAdapter extends ArrayAdapter<Cart1>{
    private Activity context;
    List<Cart1> uploads;

    TextView t1,t2,t3,t4;
    public CartAdapter(Activity context, List<Cart1> uploads)
    {
        super(context,R.layout.cart_layout,uploads);
        this.context=context;
        this.uploads=uploads;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View listViewItem=inflater.inflate(R.layout.cart_layout,null,true);

        t1=(TextView)listViewItem.findViewById(R.id.emailc);
        t2=(TextView)listViewItem.findViewById(R.id.namec);
        t3=(TextView)listViewItem.findViewById(R.id.brandc);
        t4=(TextView)listViewItem.findViewById(R.id.pricec);


        Cart1 artist=uploads.get(position);
        t1.setText(artist.getEmail());
        t2.setText(artist.getItem_name());
        t3.setText(artist.getItem_brand());
        t4.setText(artist.getItem_price());

        return listViewItem;

    }
}


