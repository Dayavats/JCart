package com.example.lenovo.jcart;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class Special_offers extends AppCompatActivity {
    private ImageButton ib;
    private Uri uri;
    private static final int GALLREQ = 1;
    DatabaseReference databaseReference;
    StorageReference storageReference;
    private EditText e1, e2;
    private Spinner s1, s2, s3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        databaseReference = FirebaseDatabase.getInstance().getReference("specialoffer");
        storageReference = FirebaseStorage.getInstance().getReference();
        e1 = (EditText) findViewById(R.id.product);
        e2 = (EditText) findViewById(R.id.price);
        s1 = (Spinner) findViewById(R.id.category);
        s2 = (Spinner) findViewById(R.id.brandname);
        s3 = (Spinner) findViewById(R.id.size);


    }

    public void view(View view) {
        Intent i = new Intent(Intent.ACTION_GET_CONTENT);
        i.setType("image/*");
        startActivityForResult(i, GALLREQ);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == GALLREQ && resultCode == RESULT_OK) {
            uri = data.getData();
            ib = (ImageButton) findViewById(R.id.img);
            ib.setImageURI(uri);
        }
    }

    public void save(View view) {

        final String category = s1.getSelectedItem().toString();
        final String brand = s2.getSelectedItem().toString();
        final String size = s3.getSelectedItem().toString();
        final String name = e1.getText().toString();
        final String price = e2.getText().toString();
        StorageReference filepath = storageReference.child(uri.getLastPathSegment());
        filepath.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                @SuppressWarnings("VisibleForTests") Uri downloadUrl = taskSnapshot.getDownloadUrl();
                Toast.makeText(getApplicationContext(), "uploaded", Toast.LENGTH_SHORT).show();
                final DatabaseReference newPost = databaseReference.push();

                newPost.child("category").setValue(category);
                newPost.child("brand").setValue(brand);
                newPost.child("size").setValue(size);
                newPost.child("name").setValue(name);
                newPost.child("price").setValue(price);
                newPost.child("image").setValue(downloadUrl.toString());
            }
        });
    }
}

