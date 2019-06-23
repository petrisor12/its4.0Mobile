package com.piero.its40.Percorsi;

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

public class Percorsi_Fragment extends Fragment {
    Button btnRealTime,btnStorico;



    public static Percorsi_Fragment newInstance() {
        return new Percorsi_Fragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v=inflater.inflate(R.layout.percorsi_layout,container,false);
        btnRealTime=v.findViewById(R.id.btnRealTimePercorsi);
        btnStorico=v.findViewById(R.id.btnStoricoPercorsi);

        FragmentTransaction vtF =getFragmentManager().beginTransaction();

        Percorsi_Storico_Fragment percorsi_realTime_fragment=new Percorsi_Storico_Fragment();
        vtF.replace(R.id.containerPercorsi,percorsi_realTime_fragment);
        vtF.commit();
        btnRealTime.setTextColor(Color.DKGRAY);
        btnStorico.setTextColor(Color.WHITE);
        btnRealTime.setBackgroundColor(Color.RED);
        btnStorico.setBackgroundColor(Color.TRANSPARENT);

        btnStorico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction vtF =getFragmentManager().beginTransaction();
                Percorsi_Storico_Fragment percorsiRealTimeFragment =new Percorsi_Storico_Fragment();
                vtF.replace(R.id.containerPercorsi,percorsiRealTimeFragment);
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
                Percorsi_Storico_Fragment percorsi_storico_fragment=new Percorsi_Storico_Fragment();

                vtF.replace(R.id.containerPercorsi, percorsi_storico_fragment);
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
