package com.example.lenovo.jcart;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.google.firebase.auth.FirebaseAuth;

import java.io.File;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.Men) {
            Intent intent=new Intent(getApplicationContext(),Men.class);
            startActivity(intent);
            // Handle the camera action
        } else if (id == R.id.Women) {
            Intent intent=new Intent(getApplicationContext(),Women.class);
            startActivity(intent);

        } else if (id == R.id.kids) {
            Intent intent=new Intent(getApplicationContext(),Kids.class);
            startActivity(intent);

        }
        else if(id==R.id.Logout){
            FirebaseAuth.getInstance().signOut();
            Intent intent = new Intent(getApplicationContext(), LOGIN.class);
            startActivity(intent);

        }
        else if(id==R.id.Cart)
        {
            Intent intent=new Intent(getApplicationContext(),Cart.class);
            startActivity(intent);


        }
        else if (id == R.id.nav_share) {
            ApplicationInfo app = getApplicationContext().getApplicationInfo();
            String filePath = app.sourceDir;
            Intent intent = new Intent(Intent.ACTION_SEND);

// but Bluetooth does not accept this. Let’s use “*/*” instead.
            intent.setType("application/vnd.android.package-archive");

// Append file and send Intent
            intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(new File(filePath)));
            startActivity(Intent.createChooser(intent,"share app using"));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
public  void levis(View view){
    Intent intent =new Intent(getApplicationContext(),Levis.class);
    startActivity(intent);
}
    public  void mufti(View view){
        Intent intent =new Intent(getApplicationContext(),Mufti.class);
        startActivity(intent);
    }
    public  void gucci(View view){
        Intent intent =new Intent(getApplicationContext(),Gucci.class);
        startActivity(intent);
    }
    public  void zara(View view){
        Intent intent =new Intent(getApplicationContext(),Zara.class);
        startActivity(intent);
    }
    public  void spykar(View view){
        Intent intent =new Intent(getApplicationContext(),Spykar.class);
        startActivity(intent);
    }
    public  void tommy(View view){
        Intent intent =new Intent(getApplicationContext(),Tommy.class);
        startActivity(intent);
    }
    public  void vintage(View view){
        Intent intent =new Intent(getApplicationContext(),Vintage.class);
        startActivity(intent);
    }
    public  void wrangler(View view){
        Intent intent =new Intent(getApplicationContext(),Wrangler.class);
        startActivity(intent);
    }
    public  void roadster(View view){
        Intent intent =new Intent(getApplicationContext(),Roadster.class);
        startActivity(intent);
    }
    public  void reebok(View view){
        Intent intent =new Intent(getApplicationContext(),Reebok.class);
        startActivity(intent);
    }
    public  void redtape(View view){
        Intent intent =new Intent(getApplicationContext(),Redtape.class);
        startActivity(intent);
    }
    public  void pepe(View view){
        Intent intent =new Intent(getApplicationContext(),Pepe.class);
        startActivity(intent);
    }
    public  void madame(View view){
        Intent intent =new Intent(getApplicationContext(),Madame.class);
        startActivity(intent);
    }
    public  void louis(View view){
        Intent intent =new Intent(getApplicationContext(),Louis.class);
        startActivity(intent);
    }
    public  void lacoste(View view){
        Intent intent =new Intent(getApplicationContext(),Lacoste.class);
        startActivity(intent);
    }
    public  void killer(View view){
        Intent intent =new Intent(getApplicationContext(),Levis.class);
        startActivity(intent);
    }
    public  void johnplayers(View view){
        Intent intent =new Intent(getApplicationContext(),Killer.class);
        startActivity(intent);
    }
    public  void jackjohn(View view){
        Intent intent =new Intent(getApplicationContext(),Jack.class);
        startActivity(intent);
    }
    public  void denizen(View view){
        Intent intent =new Intent(getApplicationContext(),Denizen.class);
        startActivity(intent);
    }
    public  void celvin(View view){
        Intent intent =new Intent(getApplicationContext(),Celvin.class);
        startActivity(intent);
    }
    public  void fly(View view){
        Intent intent =new Intent(getApplicationContext(),Fly.class);
        startActivity(intent);
    }
    public  void numero(View view){
        Intent intent =new Intent(getApplicationContext(),Numero.class);
        startActivity(intent);
    }
    public  void adidas(View view){
        Intent intent =new Intent(getApplicationContext(),Adidas.class);
        startActivity(intent);
    }
    public  void lee(View view){
        Intent intent =new Intent(getApplicationContext(),Lee.class);
        startActivity(intent);
    }
    public  void diesel(View view){
        Intent intent =new Intent(getApplicationContext(),Diesel.class);
        startActivity(intent);
    }
    public  void hudson(View view){
        Intent intent =new Intent(getApplicationContext(),Hudson.class);
        startActivity(intent);
    }
    public  void armani(View view){
        Intent intent =new Intent(getApplicationContext(),Armani.class);
        startActivity(intent);
    }
    public  void cantabil(View view){
        Intent intent =new Intent(getApplicationContext(),Cantabil.class);
        startActivity(intent);
    }
    public  void duke(View view){
        Intent intent =new Intent(getApplicationContext(),Duke.class);
        startActivity(intent);
    }
}
