package com.piero.its40.Percorsi;


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
import com.piero.its40.Adapter.AdapterPercorsiStorico;
import com.piero.its40.R;
import com.piero.its40.Models.Percorsi;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class Percorsi_Storico_Fragment extends Fragment  {

   private AdapterPercorsiStorico adapter;

    private ListView listView;
    private ArrayList<Percorsi> arrayListPercorsi;


    public Percorsi_Storico_Fragment() {
        arrayListPercorsi=new ArrayList<>();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


       View v=inflater.inflate(R.layout.fragment_percorsi__storico_, container, false);





listView=v.findViewById(R.id.listViewZoneStorico);
adapter =new AdapterPercorsiStorico(new ArrayList<Percorsi>());
listView.setAdapter(adapter);


        getJsonObjectRequest("https://its40apiv1.azurewebsites.net/api/cartpath/o/12");



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
                            Percorsi vPercorsi = new Percorsi();

                            vPercorsi.setRank(item.getInt("rank"));
                            vPercorsi.setZoneSeguense(item.getString("zoneSequence"));
                            vPercorsi.setAvgTime(item.getString("avgTime"));
                            vPercorsi.setNumCarts(item.getInt("numCarts"));
                            arrayListPercorsi.add(vPercorsi);

                       // Log.d("datorie"," "+ item.getString("zoneSequence").toString());
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                adapter.aggiorna(arrayListPercorsi);

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
