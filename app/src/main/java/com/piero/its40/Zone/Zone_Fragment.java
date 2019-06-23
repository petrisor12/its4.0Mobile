package com.piero.its40.Zone;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.piero.its40.R;

public class Zone_Fragment extends Fragment {

    Button btnRealTime,btnStorico;


    public static Zone_Fragment newInstance() {
        return new Zone_Fragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v=inflater.inflate(R.layout.zone_layout,container,false);
        btnRealTime=v.findViewById(R.id.btnRealTimeZone);
        btnStorico=v.findViewById(R.id.btnStoricoZone);

        FragmentTransaction vtF =getFragmentManager().beginTransaction();

        Zone_Dati_Fragment zone_dati_fragment=new Zone_Dati_Fragment();
        vtF.replace(R.id.containerZone,zone_dati_fragment);
        vtF.commit();
        btnRealTime.setTextColor(Color.DKGRAY);
        btnStorico.setTextColor(Color.WHITE);
        btnRealTime.setBackgroundColor(Color.RED);
        btnStorico.setBackgroundColor(Color.TRANSPARENT);

        btnStorico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction vtF =getFragmentManager().beginTransaction();
               Zone_DatiStatistica_Fragment zone_statistiche_fragment=new Zone_DatiStatistica_Fragment();

               vtF.replace(R.id.containerZone,zone_statistiche_fragment);
                vtF.commit();
                btnStorico.setTextColor(Color.DKGRAY);
                btnRealTime.setTextColor(Color.WHITE);
                btnStorico.setBackgroundColor(Color.RED);
                btnRealTime.setBackgroundColor(Color.TRANSPARENT);



            }
        });
        btnRealTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction vtF =getFragmentManager().beginTransaction();

                Zone_Dati_Fragment zone_dati_fragment=new Zone_Dati_Fragment();
                vtF.replace(R.id.containerZone,zone_dati_fragment);
                vtF.commit();
                btnStorico.setTextColor(Color.WHITE);
                btnRealTime.setTextColor(Color.DKGRAY);
                btnRealTime.setBackgroundColor(Color.RED);
                btnStorico.setBackgroundColor(Color.TRANSPARENT);





            }
        });


        return v;
    }




}
