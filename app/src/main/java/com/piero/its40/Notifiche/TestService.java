package com.piero.its40.Notifiche;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.piero.its40.Models.Carreli_Zone;
import com.piero.its40.Models.ZoneNome;
import com.piero.its40.Percorsi.DATI_CORRENTI;
import com.piero.its40.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Random;

public class TestService extends Service {

    private static final String CHANNEL_ID ="RRR" ;
    MyBinder mBinder = new MyBinder();
    ArrayList<Carreli_Zone> arrayListCarrelliZone=new ArrayList<>();
    AsyncTask myAsync;
    boolean control;
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

    public void  getDati() {
        control=true;
        myAsync=new MyAsync();
        myAsync.execute();
        createNotificationChannel();

    }
    public void  noGetDati() {
        control=false;


    }



    public class MyAsync extends AsyncTask<Object, Integer, Object> {

        //  WeakReference<Activity_FiguraB> mActivity;

        //  public MyAsync(Activity_FiguraB aActivity) {
        //    this.mActivity = new WeakReference<>(aActivity);

        // }
        @Override
        protected Object doInBackground(Object... strings) {
            try {
                getJsonObjectRequest("https://its40apiv1.azurewebsites.net/api/cart/o/12");
            }catch (Exception e){
                e.printStackTrace();
            }
            try {
                Thread.sleep(10000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Object aVoid) {
            super.onPostExecute(aVoid);
            if(myAsync !=null){
                myAsync.cancel(true);
                myAsync=null;
            }
           // adapter.aggiorna(arrayListCarrelli_Zone);
if(control){
    myAsync=new TestService.MyAsync();
    myAsync.execute();

}


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
                        String lastResult="Nella zona "+arrayListCarrelliZone.get(arrayListCarrelliZone.size()-1).getNomeZona()+" è passato "
                                + " il carrello " +arrayListCarrelliZone.get(arrayListCarrelliZone.size()-1).getIdCarrello()+ " ora " +
                                arrayListCarrelliZone.get(arrayListCarrelliZone.size()-1).getIdCarrello();
                        Toast.makeText(getApplicationContext(),/* message*/  ""+lastResult, Toast.LENGTH_SHORT).show();
                        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), CHANNEL_ID)
                                .setSmallIcon(R.drawable.coop)
                                .setContentTitle("COOP NOTIFICHE ")
                                .setContentText(lastResult)

                                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
                        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(getApplicationContext());


                        notificationManager.notify(arrayListCarrelliZone.get(1).getIdZona(), builder.build());
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
            Volley.newRequestQueue(getApplication()).add(mJsonObjectRequest);
        }


    }
    private void createNotificationChannel() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "name", importance);
            channel.setDescription("descrizione");

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }





}


