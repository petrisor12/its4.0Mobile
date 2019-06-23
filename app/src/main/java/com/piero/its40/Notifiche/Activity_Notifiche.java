package com.piero.its40.Notifiche;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.piero.its40.R;

public class Activity_Notifiche extends AppCompatActivity {
    TestService mService;


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
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_activity_notifiche);
        Button btn = findViewById(R.id.btnActivaNotifiche);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bindService();
            }
        });
        Button btnDisaativa = findViewById(R.id.btnD);
        btnDisaativa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // unbind();
                getRandomFromServices();

            }
        });

    }



    private void bindService() {
        bindService(new Intent(Activity_Notifiche.this,TestService.class),mConnection, Context.BIND_AUTO_CREATE);


    }

    private void getRandomFromServices() {
        if(mService !=null){
            int result=mService.getRandom();
            Log.d("TAG","mservice ok");
            Toast.makeText(getApplicationContext(),/* message*/  "tesg"+result, Toast.LENGTH_SHORT).show();

        }else{
            Log.d("TAG","mservice null");
        }

    }

    private void unbind() {
        unbindService(mConnection);
        mService = null;
    }





}
