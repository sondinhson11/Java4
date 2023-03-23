package repository;



import viewmodel.QLGioHangChiTiet;

import java.util.ArrayList;

public class GioHangCTRepository {
   private ArrayList<QLGioHangChiTiet> litsSanPhams ;
   public GioHangCTRepository() {
       litsSanPhams = new ArrayList<>();
   }
   public  void insert(QLGioHangChiTiet sp){
       litsSanPhams.add(sp);
   }

   public void update(QLGioHangChiTiet sp){
       for (int i = 0; i < litsSanPhams.size(); i++) {
           QLGioHangChiTiet item = litsSanPhams.get(i);
           if(item.getIdGioHang().equals(sp.getIdGioHang())){
               litsSanPhams.set(i,sp);
           }
       }
   }
    public void delete(QLGioHangChiTiet sp){
        for (int i = 0; i < litsSanPhams.size(); i++) {
            QLGioHangChiTiet item = litsSanPhams.get(i);
            if(item.getIdGioHang().equals(sp.getIdGioHang())){
                litsSanPhams.remove(i);
            }
        }
    }
    public  ArrayList<QLGioHangChiTiet > findAll(){
       return litsSanPhams;
    }
    public  QLGioHangChiTiet findByMa(String ma){
       for (int i = 0; i < litsSanPhams.size(); i++) {
           QLGioHangChiTiet item = litsSanPhams.get(i);
           if(item.getIdGioHang().equals(ma)){
               return litsSanPhams.get(i);
           }
       }
       return null;
    }
}
