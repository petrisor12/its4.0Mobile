package com.piero.its40.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.piero.its40.Models.Carreli_Zone;
import com.piero.its40.Models.Percorsi;
import com.piero.its40.R;

import java.util.ArrayList;

public class AdapterPercorsiStorico extends BaseAdapter {
    private ArrayList<Percorsi> mDati;
    public AdapterPercorsiStorico(ArrayList<Percorsi> aValue){
        mDati=aValue;
    }
public  void aggiorna(ArrayList<Percorsi> list){
       mDati.clear();
       mDati.addAll(list);
       notifyDataSetChanged();


}
    @Override
    public int getCount() {
        return mDati.size();
    }

    @Override
    public Percorsi getItem(int position) {
        return mDati.get(position);
    }

    @Override
    public long getItemId(int position) {

        return mDati.get(position).getRank();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View vView;
        ViewHolder vHolder;
        if (convertView==null){
            LayoutInflater vInflater = LayoutInflater.from(parent.getContext());

            vView =vInflater.inflate(R.layout.cell_percorsi,parent,false);
            vHolder=new ViewHolder();
            vHolder.mtxtRank=vView.findViewById(R.id.textView1);
            vHolder.mtxtSequenze=vView.findViewById(R.id.textView2);
            vHolder.mtxtTempoMedio =vView.findViewById(R.id.textView3);
            vHolder.mtxtNumCarrelli =vView.findViewById(R.id.textView4);



            vView.setTag(vHolder);

        }
        else{
            vView=convertView;
            vHolder=(ViewHolder)vView.getTag();
        }



        vHolder.mtxtRank.setText(""+getItem(position).getRank());
        vHolder.mtxtSequenze.setText(""+getItem(position).getZoneSeguense());
        vHolder.mtxtTempoMedio.setText(""+getItem(position).getNumCarts());
        vHolder.mtxtNumCarrelli.setText(""+getItem(position).getAvgTime());


        return vView;
    }
    private class ViewHolder{
        public TextView mtxtRank,mtxtSequenze, mtxtTempoMedio,mtxtNumCarrelli;

    }
}
