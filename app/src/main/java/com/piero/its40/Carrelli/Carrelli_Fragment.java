package com.piero.its40.Carrelli;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.piero.its40.R;

public class Carrelli_Fragment extends Fragment {


    public static Carrelli_Fragment newInstance() {
        return new Carrelli_Fragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

       View v=inflater.inflate(R.layout.carrelli_layout,container,false);
        FragmentTransaction vtF =getFragmentManager().beginTransaction();

        Carrelli_Storico_Fragment carrelli_storico_fragment=new Carrelli_Storico_Fragment();
        vtF.replace(R.id.containerCarrelli,carrelli_storico_fragment);
        vtF.commit();

        return v;
    }


}
