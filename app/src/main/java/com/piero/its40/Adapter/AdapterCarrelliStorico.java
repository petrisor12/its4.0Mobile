package com.piero.its40.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.piero.its40.Models.Carrelli;
import com.piero.its40.Models.Percorsi;
import com.piero.its40.R;

import java.util.ArrayList;

public class AdapterCarrelliStorico extends BaseAdapter {
    private ArrayList<Carrelli> mDati;
    public AdapterCarrelliStorico(ArrayList<Carrelli> aValue){
        mDati=aValue;
    }
public  void aggiorna(ArrayList<Carrelli> list){
       mDati.clear();
       mDati.addAll(list);
       notifyDataSetChanged();


}
    @Override
    public int getCount() {
        return mDati.size();
    }

    @Override
    public Carrelli getItem(int position) {
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

            vView =vInflater.inflate(R.layout.cell_carrelli,parent,false);
            vHolder=new ViewHolder();
            vHolder.mtxtId=vView.findViewById(R.id.textView1C);
            vHolder.mtxtTotSpesa=vView.findViewById(R.id.textView2C);
            vHolder.mtxtData =vView.findViewById(R.id.textView3C);



            vView.setTag(vHolder);

        }
        else{
            vView=convertView;
            vHolder=(ViewHolder)vView.getTag();
        }



        vHolder.mtxtId.setText(""+getItem(position).getId());
        vHolder.mtxtTotSpesa.setText(""+getItem(position).getTotSpesa());
        vHolder.mtxtData.setText(""+getItem(position).getData());


        return vView;
    }
    private class ViewHolder{
        public TextView mtxtId,mtxtTotSpesa, mtxtData;

    }
}
