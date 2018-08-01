package com.example.lenovo.jcart;

import android.app.Activity;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Lenovo on 6/17/2018.
 */

public class JeansAdapter extends ArrayAdapter<Jeans> {
    private Activity context;
 //   private final Integer[] imageid;
    List<Jeans> jeans;

    public JeansAdapter( Activity context, List<Jeans> jeans) {
        super(context, R.layout.list_layout,jeans);
        this.context=context;
        this.jeans=jeans;
   //     this.imageid=imageid;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View listView=inflater.inflate(R.layout.list_layout,null,true);
        ImageView imageView= (ImageView) listView.findViewById(R.id.Imglll);
        TextView t1= (TextView) listView.findViewById(R.id.t1);
        TextView t2= (TextView) listView.findViewById(R.id.t2);
        TextView t3= (TextView) listView.findViewById(R.id.t3);
        TextView t4= (TextView) listView.findViewById(R.id.t4);
        TextView t5= (TextView) listView.findViewById(R.id.t5);
        Jeans jeans1=jeans.get(position);
        String im=jeans1.getImage().toString();
        Picasso.with(context).load(im).into(imageView);
        t1.setText(jeans1.category);
        t2.setText(jeans1.brand);
        t3.setText(jeans1.name);
        t4.setText(jeans1.size);
        t5.setText(jeans1.price);



        return listView;
    }

}
