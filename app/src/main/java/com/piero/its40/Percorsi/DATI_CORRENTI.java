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


//myAsync=new MyAsync();
//myAsync.execute();

            return v;
    }



    }



