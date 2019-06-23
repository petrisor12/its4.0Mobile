package com.piero.its40;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.piero.its40.Carrelli.Carrelli_Fragment;
import com.piero.its40.Home.Home_Fragment;
import com.piero.its40.Notifiche.Notifiche_Fragment;
import com.piero.its40.Percorsi.Percorsi_Fragment;
import com.piero.its40.Zone.Zone_Fragment;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    Toolbar toolbar;
BottomNavigationView bottomNavigationView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=findViewById(R.id.toolbar_MainActivity);
        setSupportActionBar(toolbar);

        bottomNavigationView=findViewById(R.id.navigationButton);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);





        if (savedInstanceState == null){
            launchFragment("ITS 4.0 Dashboard", Home_Fragment.newInstance());
        }
        else {

        }


    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu,menu);

        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id=item.getItemId();
        switch (id){
            case R.id.item_percorsi:
                Toast.makeText(getApplicationContext(),/* message*/  "hai clicato su  add" +item.getItemId(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.item_Zone:
                Toast.makeText(getApplicationContext(),/* message*/  "hai clicato su  setting" +item.getItemId(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.item_Carrelli:
                Toast.makeText(getApplicationContext(),/* message*/  "hai clicato su  setting" +item.getItemId(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.item_Notifiche:
                Toast.makeText(getApplicationContext(),/* message*/  "hai clicato su  setting" +item.getItemId(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.item_Logout:
                Toast.makeText(getApplicationContext(),/* message*/  "hai clicato su  setting" +item.getItemId(), Toast.LENGTH_SHORT).show();
                break;

        }



        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected( MenuItem item) {
        int id=item.getItemId();

        switch (id){
            case R.id.zone:

                launchFragment("ITS 4.0 Zone", Zone_Fragment.newInstance());

                return true;
            case R.id.percorsi:
                launchFragment("ITS 4.0 Percorsi", Percorsi_Fragment.newInstance());
                return true;
            case R.id.notifiche:
                launchFragment("ITS 4.0 Notifiche", Notifiche_Fragment.newInstance());
                return true;
            case R.id.carrelli:
                launchFragment("ITS 4.0 Carrelli", Carrelli_Fragment.newInstance());
                return true;
            case R.id.home:
                launchFragment("ITS 4.0 Dashboard", Home_Fragment.newInstance());
                return true;
        }
        return false;
    }
    private void launchFragment(String tag, Fragment aFragment){
        Log.d("TAm","tam");


        getSupportActionBar().setTitle(tag);


        FragmentTransaction vFT = getSupportFragmentManager().beginTransaction();
        vFT.replace(R.id.main_container, aFragment, tag);
        vFT.commit();
    }

    }




