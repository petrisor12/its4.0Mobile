package com.piero.its40.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.piero.its40.Models.Percorsi;
import com.piero.its40.Models.Zone;
import com.piero.its40.R;

import java.util.ArrayList;

public class AdapterDatiZone extends BaseAdapter {
    private ArrayList<Zone> mDati;
    public AdapterDatiZone(ArrayList<Zone> aValue){
        mDati=aValue;
    }
public  void aggiorna(ArrayList<Zone> list){
       mDati.clear();
       mDati.addAll(list);
       notifyDataSetChanged();


}
    @Override
    public int getCount() {
        return mDati.size();
    }

    @Override
    public Zone getItem(int position) {
        return mDati.get(position);
    }

    @Override
    public long getItemId(int position) {
        // ritorna id della tabella
        return mDati.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View vView;
        ViewHolder vHolder;
        if (convertView==null){
            LayoutInflater vInflater = LayoutInflater.from(parent.getContext());

            vView =vInflater.inflate(R.layout.cell_datizone,parent,false);
            vHolder=new ViewHolder();
            vHolder.mtxtId=vView.findViewById(R.id.textView1Z);
            vHolder.mtxtNumCarrelli=vView.findViewById(R.id.textView2Z);
            vHolder.mtxtSpesaTotale =vView.findViewById(R.id.textView3Z);


            vView.setTag(vHolder);

        }
        else{
            vView=convertView;
            vHolder=(ViewHolder)vView.getTag();
        }



        vHolder.mtxtId.setText(""+getItem(position).getNome());
        vHolder.mtxtNumCarrelli.setText(""+getItem(position).getTotalSpending());
        vHolder.mtxtSpesaTotale.setText(""+getItem(position).getNumCarrelli());


        return vView;
    }
    private class ViewHolder{
        public TextView mtxtId, mtxtSpesaTotale,mtxtNumCarrelli;

    }
}
