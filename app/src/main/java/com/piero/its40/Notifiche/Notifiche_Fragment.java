package com.piero.its40.Notifiche;

import android.content.Intent;
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

import com.piero.its40.Percorsi.Percorsi_Storico_Fragment;
import com.piero.its40.R;

public class Notifiche_Fragment extends Fragment {
    Button btnRealTime,btnStorico;



    public static Notifiche_Fragment newInstance() {
        return new Notifiche_Fragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

      //  View v=inflater.inflate(R.layout.notifiche_layout,container,false);
        Intent vIntent=new Intent(getContext(),Activity_Notifiche.class);
        startActivity(vIntent);

        return null;
    }


}
