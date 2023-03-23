package repository;


import viewmodel.QLHoaDon;

import java.util.ArrayList;

public class HoaDonRepository {
   private ArrayList<QLHoaDon> litsSanPhams ;
   public HoaDonRepository() {
       litsSanPhams = new ArrayList<>();
   }
   public  void insert(QLHoaDon sp){
       litsSanPhams.add(sp);
   }

   public void update(QLHoaDon sp){
       for (int i = 0; i < litsSanPhams.size(); i++) {
           QLHoaDon item = litsSanPhams.get(i);
           if(item.getMa().equals(sp.getMa())){
               litsSanPhams.set(i,sp);
           }
       }
   }
    public void delete(QLHoaDon sp){
        for (int i = 0; i < litsSanPhams.size(); i++) {
            QLHoaDon item = litsSanPhams.get(i);
            if(item.getMa().equals(sp.getMa())){
                litsSanPhams.remove(i);
            }
        }
    }
    public  ArrayList<QLHoaDon > findAll(){
       return litsSanPhams;
    }
    public  QLHoaDon findByMa(String ma){
       for (int i = 0; i < litsSanPhams.size(); i++) {
           QLHoaDon item = litsSanPhams.get(i);
           if(item.getMa().equals(ma)){
               return litsSanPhams.get(i);
           }
       }
       return null;
    }
}
