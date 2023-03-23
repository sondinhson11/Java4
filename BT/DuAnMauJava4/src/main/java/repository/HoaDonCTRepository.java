package repository;


import viewmodel.QLHoaDonChiTiet;

import java.util.ArrayList;

public class HoaDonCTRepository {
   private ArrayList<QLHoaDonChiTiet> litsSanPhams ;
   public HoaDonCTRepository() {
       litsSanPhams = new ArrayList<>();
   }
   public  void insert(QLHoaDonChiTiet sp){
       litsSanPhams.add(sp);
   }

   public void update(QLHoaDonChiTiet sp){
       for (int i = 0; i < litsSanPhams.size(); i++) {
           QLHoaDonChiTiet item = litsSanPhams.get(i);
           if(item.getIdHoaDon().equals(sp.getIdHoaDon())){
               litsSanPhams.set(i,sp);
           }
       }
   }
    public void delete(QLHoaDonChiTiet sp){
        for (int i = 0; i < litsSanPhams.size(); i++) {
            QLHoaDonChiTiet item = litsSanPhams.get(i);
            if(item.getIdHoaDon().equals(sp.getIdHoaDon())){
                litsSanPhams.remove(i);
            }
        }
    }
    public  ArrayList<QLHoaDonChiTiet > findAll(){
       return litsSanPhams;
    }
    public  QLHoaDonChiTiet findByMa(String ma){
       for (int i = 0; i < litsSanPhams.size(); i++) {
           QLHoaDonChiTiet item = litsSanPhams.get(i);
           if(item.getIdHoaDon().equals(ma)){
               return litsSanPhams.get(i);
           }
       }
       return null;
    }
}
