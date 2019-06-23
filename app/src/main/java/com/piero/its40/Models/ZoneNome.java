package com.piero.its40.Models;


import com.piero.its40.Adapter.AdapterDatiZone;

import java.util.ArrayList;

public class ZoneNome  {
    private int id;
    private String name;
    ArrayList<ZoneNome> zoneNomes;

    public ArrayList<ZoneNome> getZoneNomes() {
        return zoneNomes;
    }

    public void setZoneNomes(ArrayList<ZoneNome> zoneNomes) {
        this.zoneNomes = zoneNomes;
    }

    public ZoneNome() {
        zoneNomes =new ArrayList<>();
        zoneNomes.add(new ZoneNome(1,"Banco Formaggi"));
        zoneNomes.add(new ZoneNome(3,"Formaggi 1"));
        zoneNomes.add(new ZoneNome(4,"Alimentari"));
        zoneNomes.add(new ZoneNome(6,"Serv.Carni 1"));
        zoneNomes.add(new ZoneNome(7,"Prodotti-frigo"));
        zoneNomes.add(new ZoneNome(8,"Detersivi"));
        zoneNomes.add(new ZoneNome(9,"Bibite"));
        zoneNomes.add(new ZoneNome(10,"Scaffale 2"));
        zoneNomes.add(new ZoneNome(12 ,"Formaggi 2"));
        zoneNomes.add(new ZoneNome(13 ," Banco Carni"));
        zoneNomes.add(new ZoneNome(14 ," Scaffale1"));
        zoneNomes.add(new ZoneNome(15 ,"Prodotti-forno"));
        zoneNomes.add(new ZoneNome(16 ,"Promo"));
        zoneNomes.add(new ZoneNome(17 ,"Serv.Carni 2"));
        zoneNomes.add(new ZoneNome(18 ,"Verdure"));
    }

    public ZoneNome(int id, String name) {
        this.id = id;
        this.name = name;

    }



   public static String nomeZona(int id){
        ZoneNome zoneNome=new ZoneNome();
        ArrayList<ZoneNome> arrayList=zoneNome.getZoneNomes();
       for (int i=0;i<arrayList.size();i++){
           if (id==arrayList.get(i).getId()){
               return arrayList.get(i).getName();
           }

       }
       return "Zona E";

   }

    public int getId() {
        return id;
    }




    public String getName() {
        return name;
    }


}
