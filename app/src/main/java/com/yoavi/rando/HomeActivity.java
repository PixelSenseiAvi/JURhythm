
package com.yoavi.rando;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toast;

import Fragments.FragmentAboutJU;
import Fragments.FragmentContactUs;
import Fragments.FragmentDev;
import Fragments.FragmentEvents;
import Fragments.FragmentHome;
import Fragments.FragmentMaps;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if(getSupportActionBar()!=null)
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        SharedPreferences sp = this.getSharedPreferences("yoursharedprefs", 0);
        boolean isFirstStart = sp.getBoolean("key", true);

        if(isFirstStart) {

            drawer.openDrawer(Gravity.LEFT);
            SharedPreferences.Editor e = sp.edit();
            e.putBoolean("key", false);
            e.apply();
        }


        android.app.FragmentManager fm = getFragmentManager();
        fm.beginTransaction().replace(R.id.content_home,new FragmentHome()).commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        int count = getFragmentManager().getBackStackEntryCount();

        if(count==0) {
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START);
            } else {
                super.onBackPressed();
            }
        }else{
            toolbar.setTitle("JU Rhythm 2017");
            getFragmentManager().popBackStack();
        }
    }

    public void setActionBarTitle(String Title){
        toolbar.setTitle(Title);
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        android.app.FragmentManager fm = getFragmentManager();
        int id = item.getItemId();

        if (id == R.id.home) {
            fm.beginTransaction().replace(R.id.content_home,new FragmentHome()).commit();
        } else if (id == R.id.events) {
            fm.beginTransaction().replace(R.id.content_home,new FragmentEvents()).commit();
        } else if (id == R.id.maps) {
            fm.beginTransaction().replace(R.id.content_home,new FragmentMaps()).commit();
        } else if (id == R.id.contactUs) {
            fm.beginTransaction().replace(R.id.content_home,new FragmentContactUs()).commit();
        } else if (id == R.id.developers) {
            fm.beginTransaction().replace(R.id.content_home,new FragmentDev()).commit();
        }else if (id == R.id.nav_share) {

            try {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_SUBJECT, "JU Rhythm");
                String sAux = "\nLet me recommend you this cool application\n\n";
                sAux = sAux + "https://play.google.com/store/apps/details?id=com.yoavi.rando \n\n";
                i.putExtra(Intent.EXTRA_TEXT, sAux);
                startActivity(Intent.createChooser(i, "choose one"));
            } catch(Exception e) {
                Toast.makeText(this,"OOPs something went wrong",Toast.LENGTH_SHORT).show();
            }

        }else if(id == R.id.about){
            fm.beginTransaction().replace(R.id.content_home,new FragmentAboutJU()).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
