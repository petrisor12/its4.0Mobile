package com.piero.its40.Notifiche;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.piero.its40.Models.Carreli_Zone;
import com.piero.its40.Models.ZoneNome;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Random;

public class TestService extends Service {
    MyBinder mBinder = new MyBinder();
    ArrayList<Carreli_Zone> arrayListCarrelliZone=new ArrayList<>();

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_NOT_STICKY;
    }

    public class MyBinder extends Binder {
        public TestService getService() {
            return TestService.this;
        }
    }

    public ArrayList<Carreli_Zone>  getDati() {


    getJsonObjectRequest("https://its40apiv1.azurewebsites.net/api/cart/o/12");
    return null;

    }
    private void getJsonObjectRequest(String url){


        final JsonObjectRequest mJsonObjectRequest =new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray mJsonArray = response.getJSONArray("list");
                    Log.d("dati"," "+ mJsonArray.toString());
                    arrayListCarrelliZone.clear();
                    for (int i=0;i<mJsonArray.length();i++){
                        JSONObject item=mJsonArray.getJSONObject(i);
                        Carreli_Zone vCarZone = new Carreli_Zone();

                        vCarZone.setNomeZona(ZoneNome.nomeZona(item.getInt("zoneId")));
                        vCarZone.setIdCarrello(item.getInt("cartId"));

                        vCarZone.setTime((item.getString("timeStamp").substring(11,19)));

                        arrayListCarrelliZone.add(vCarZone);

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("main","errore");

            }
        });
        Volley.newRequestQueue(this).add(mJsonObjectRequest);

//Log.d("TAG",""+arrayListCarrelliZone.toString());
    }



    public int getRandom(){
        Random vRandom=new Random();
        return vRandom.nextInt();

    }


}


