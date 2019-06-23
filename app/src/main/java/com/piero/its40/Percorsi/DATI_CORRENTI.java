package com.piero.its40.Percorsi;


import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.piero.its40.Adapter.AdapterDATI_CORRENTI;
import com.piero.its40.Models.Carreli_Zone;
import com.piero.its40.Models.ZoneNome;
import com.piero.its40.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class DATI_CORRENTI extends Fragment  {

    private AdapterDATI_CORRENTI adapter;
    AsyncTask myAsync;

    private ListView listView;
    private ArrayList<Carreli_Zone> arrayListCarrelli_Zone;





    public DATI_CORRENTI() {
        arrayListCarrelli_Zone=new ArrayList<>();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


       View v=inflater.inflate(R.layout.fragment_dati_correnti, container, false);

       listView=v.findViewById(R.id.listViewDatiCorrenti);
adapter =new AdapterDATI_CORRENTI(new ArrayList<Carreli_Zone>());
listView.setAdapter(adapter);


myAsync=new MyAsync();
myAsync.execute();

            return v;
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
                Thread.sleep(2000);

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
            adapter.aggiorna(arrayListCarrelli_Zone);

            myAsync=new MyAsync();
            myAsync.execute();

        }
        private void getJsonObjectRequest(String url){

            final JsonObjectRequest mJsonObjectRequest =new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        JSONArray mJsonArray = response.getJSONArray("list");
                        Log.d("dati"," "+ mJsonArray.toString());
                        arrayListCarrelli_Zone.clear();
                        for (int i=0;i<mJsonArray.length();i++){
                            JSONObject item=mJsonArray.getJSONObject(i);
                            Carreli_Zone vCarZone = new Carreli_Zone();

                            vCarZone.setNomeZona(ZoneNome.nomeZona(item.getInt("zoneId")));
                            vCarZone.setIdCarrello(item.getInt("cartId"));

                            vCarZone.setTime((item.getString("timeStamp").substring(11,19)));

                            arrayListCarrelli_Zone.add(vCarZone);

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
            Volley.newRequestQueue(getContext()).add(mJsonObjectRequest);
        }


    }




    }



