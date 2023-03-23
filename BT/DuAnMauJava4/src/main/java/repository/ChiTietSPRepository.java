package repository;

import viewmodel.QLChiTietSP;

import java.util.ArrayList;

public class ChiTietSPRepository {
   private ArrayList<QLChiTietSP> litsSanPhams ;
   public ChiTietSPRepository() {
       litsSanPhams = new ArrayList<>();
   }
   public  void insert(QLChiTietSP sp){
       litsSanPhams.add(sp);
   }

   public void update(QLChiTietSP sp){
       for (int i = 0; i < litsSanPhams.size(); i++) {
           QLChiTietSP item = litsSanPhams.get(i);
           if(item.getMa().equals(sp.getMa())){
               litsSanPhams.set(i,sp);
           }
       }
   }
    public void delete(QLChiTietSP sp){
        for (int i = 0; i < litsSanPhams.size(); i++) {
            QLChiTietSP item = litsSanPhams.get(i);
            if(item.getMa().equals(sp.getMa())){
                litsSanPhams.remove(i);
            }
        }
    }
    public  ArrayList<QLChiTietSP > findAll(){
       return litsSanPhams;
    }
    public  QLChiTietSP findByMa(String ma){
       for (int i = 0; i < litsSanPhams.size(); i++) {
           QLChiTietSP item = litsSanPhams.get(i);
           if(item.getMa().equals(ma)){
               return litsSanPhams.get(i);
           }
       }
       return null;
    }
}
