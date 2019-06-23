package com.piero.its40.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.piero.its40.Models.Carreli_Zone;
import com.piero.its40.R;

import java.util.ArrayList;

public class AdapterDATI_CORRENTI extends BaseAdapter {
    private ArrayList<Carreli_Zone> mDati;
    public AdapterDATI_CORRENTI(ArrayList<Carreli_Zone> aValue){
        mDati=aValue;
    }
public  void aggiorna(ArrayList<Carreli_Zone> list){
       mDati.clear();
       mDati.addAll(list);
       notifyDataSetChanged();


}
    @Override
    public int getCount() {
        return mDati.size();
    }

    @Override
    public Carreli_Zone getItem(int position) {
        return mDati.get(position);
    }

    @Override
    public long getItemId(int position) {

        return mDati.get(position).getIdCarrello();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View vView;
        ViewHolder vHolder;
        if (convertView==null){
            LayoutInflater vInflater = LayoutInflater.from(parent.getContext());

            vView =vInflater.inflate(R.layout.cell_dati_correnti,parent,false);
            vHolder=new ViewHolder();
            vHolder.mtxtId=vView.findViewById(R.id.textView1ps);
            vHolder.mtxtZona=vView.findViewById(R.id.textView2ps);
            vHolder.mtxtTempoMedio =vView.findViewById(R.id.textView3ps);



            vView.setTag(vHolder);

        }
        else{
            vView=convertView;
            vHolder=(ViewHolder)vView.getTag();
        }



        vHolder.mtxtId.setText(""+getItem(position).getIdCarrello());
        vHolder.mtxtZona.setText(""+getItem(position).getNomeZona());
        vHolder.mtxtTempoMedio.setText(""+getItem(position).getTime());


        return vView;
    }
    private class ViewHolder{
        public TextView mtxtId,mtxtZona, mtxtTempoMedio;

    }
}
