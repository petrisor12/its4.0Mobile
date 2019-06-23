package com.piero.its40.Notifiche;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Color;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.piero.its40.MainActivity;
import com.piero.its40.Models.Carreli_Zone;
import com.piero.its40.R;

import java.util.ArrayList;

public class Activity_Notifiche extends AppCompatActivity {
    TestService mService;
    Button btnDisaativa,btnAttiva;
    TextView textView;


    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mService = ((TestService.MyBinder) service).getService();

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        bindService();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifiche);
        textView=findViewById(R.id.textViewNotifica);
         btnAttiva = findViewById(R.id.btnActiva);
        btnDisaativa = findViewById(R.id.btnDisativa);
        btnAttiva.setTextColor(Color.RED);
        btnDisaativa.setTextColor(Color.GRAY);
        textView.setText("Notifiche disattivate");

        btnAttiva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getRandomFromServices();
                btnAttiva.setTextColor(Color.GRAY);
                btnDisaativa.setTextColor(Color.RED);
                textView.setText("Notifiche attivate");


            }
        });

        btnDisaativa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btnAttiva.setTextColor(Color.RED);
                btnDisaativa.setTextColor(Color.GRAY);
                textView.setText("Notifiche disattivate");
                stopGetRandomFromServices();
              //  unbind();

            }
        });

    }




    private void bindService() {
        bindService(new Intent(Activity_Notifiche.this,TestService.class),mConnection, Context.BIND_AUTO_CREATE);


    }
    private void stopGetRandomFromServices() {
        if(mService !=null){
            mService.noGetDati();}
    }

    private void getRandomFromServices() {
        if(mService !=null){
        mService.getDati();
          //  Log.d("TAG","mservice Ok" +arrayList.get(1)+"nnnhh");



//            Log.d("TAG","mservice ok");
//            int result=mService.getRandom();
//            Toast.makeText(getApplicationContext(),/* message*/  "tesg"+result, Toast.LENGTH_SHORT).show();

        }else{
            Log.d("TAG","mservice null");
    }

    }

    private void unbind() {
        unbindService(mConnection);
        mService = null;
    }

    @Override
    public void onBackPressed() {
        Intent vIntent=new Intent(getApplicationContext(), MainActivity.class);
        startActivity(vIntent);

    }
}
