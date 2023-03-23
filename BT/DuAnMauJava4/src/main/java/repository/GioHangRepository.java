package repository;



import viewmodel.QLGioHang;

import java.util.ArrayList;

public class GioHangRepository {
   private ArrayList<QLGioHang> litsSanPhams ;
   public GioHangRepository() {
       litsSanPhams = new ArrayList<>();
   }
   public  void insert(QLGioHang sp){
       litsSanPhams.add(sp);
   }

   public void update(QLGioHang sp){
       for (int i = 0; i < litsSanPhams.size(); i++) {
           QLGioHang item = litsSanPhams.get(i);
           if(item.getMa().equals(sp.getMa())){
               litsSanPhams.set(i,sp);
           }
       }
   }
    public void delete(QLGioHang sp){
        for (int i = 0; i < litsSanPhams.size(); i++) {
            QLGioHang item = litsSanPhams.get(i);
            if(item.getMa().equals(sp.getMa())){
                litsSanPhams.remove(i);
            }
        }
    }
    public  ArrayList<QLGioHang > findAll(){
       return litsSanPhams;
    }
    public  QLGioHang findByMa(String ma){
       for (int i = 0; i < litsSanPhams.size(); i++) {
           QLGioHang item = litsSanPhams.get(i);
           if(item.getMa().equals(ma)){
               return litsSanPhams.get(i);
           }
       }
       return null;
    }
}
