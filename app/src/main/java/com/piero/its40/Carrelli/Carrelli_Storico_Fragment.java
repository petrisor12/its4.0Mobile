package com.piero.its40.Carrelli;


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
import com.piero.its40.Adapter.AdapterCarrelliStorico;
import com.piero.its40.Models.Carrelli;
import com.piero.its40.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class Carrelli_Storico_Fragment extends Fragment  {
    private static final String SAVE_LIST_ARRAY ="SAVE_LIST_ARRAY" ;
    private static final String DATI ="DATI" ;
   private AdapterCarrelliStorico adapter;

    private ListView listView;
    private ArrayList<Carrelli> arrayListCarrelli;


    public Carrelli_Storico_Fragment() {
        arrayListCarrelli=new ArrayList<>();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


       View v=inflater.inflate(R.layout.fragment_carrellistorico_, container, false);





listView=v.findViewById(R.id.listViewCarrelliStorico);
adapter =new AdapterCarrelliStorico(new ArrayList<Carrelli>());
listView.setAdapter(adapter);


        getJsonObjectRequest("https://its40apiv1.azurewebsites.net/api/receipt/o/12");



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
                            Carrelli vCarrelli = new Carrelli();

                        vCarrelli.setId(item.getInt("cartId"));
                        vCarrelli.setTotSpesa(item.getString("totalSpending"));
                        vCarrelli.setData(item.getString("timeStamp"));

                            arrayListCarrelli.add(vCarrelli);

                        Log.d("datorie"," "+ item.getString("timeStamp").toString());
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                adapter.aggiorna(arrayListCarrelli);

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
