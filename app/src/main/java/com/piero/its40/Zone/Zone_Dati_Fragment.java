package com.piero.its40.Zone;


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
import com.piero.its40.Adapter.AdapterDatiZone;
import com.piero.its40.Models.Zone;
import com.piero.its40.Models.ZoneNome;
import com.piero.its40.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class Zone_Dati_Fragment extends Fragment  {

   private AdapterDatiZone adapter;

    private ListView listView;
    private ArrayList<Zone> arrayListZone;


    public Zone_Dati_Fragment() {
        arrayListZone=new ArrayList<>();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


       View v=inflater.inflate(R.layout.fragment_zone__dati, container, false);

       listView=v.findViewById(R.id.listViewZoneDati);
adapter =new AdapterDatiZone(new ArrayList<Zone>());
listView.setAdapter(adapter);


        getJsonObjectRequest("https://its40apiv1.azurewebsites.net/api/zoneperformance/o/12");



            return v;
    }
    private void getJsonObjectRequest(String url){

        final JsonObjectRequest mJsonObjectRequest =new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray mJsonArray = response.getJSONArray("list");
                    Log.d("dati"," "+ mJsonArray.toString());

                    for (int i=0;i<mJsonArray.length();i++){
                        JSONObject item=mJsonArray.getJSONObject(i);
                            Zone vZone = new Zone();

                        vZone.setNome(ZoneNome.nomeZona(item.getInt("previousZoneId")));
                        vZone.setTotalSpending(item.getString("totalSpending"));
                        vZone.setNumCarrelli(item.getString("numCarts"));

                            arrayListZone.add(vZone);

                        Log.d("datorie"," "+ item.getString("totalSpending").toString());
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                adapter.aggiorna(arrayListZone);

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
