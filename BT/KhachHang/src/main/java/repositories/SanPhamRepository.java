package repositories;

import view_model.QLMauSac;
import view_model.QLSanPham;

import java.util.ArrayList;

public class SanPhamRepository {
   private ArrayList<QLSanPham> litsSanPhams ;
   public SanPhamRepository() {
       litsSanPhams = new ArrayList<>();
   }
   public  void insert(QLSanPham sp){
       litsSanPhams.add(sp);
   }

   public void update(QLSanPham sp){
       for (int i = 0; i < litsSanPhams.size(); i++) {
           QLSanPham item = litsSanPhams.get(i);
           if(item.getMa().equals(sp.getMa())){
               litsSanPhams.set(i,sp);
           }
       }
   }
    public void delete(QLSanPham sp){
        for (int i = 0; i < litsSanPhams.size(); i++) {
            QLSanPham item = litsSanPhams.get(i);
            if(item.getMa().equals(sp.getMa())){
                litsSanPhams.remove(i);
            }
        }
    }
    public  ArrayList<QLSanPham > findAll(){
       return litsSanPhams;
    }
    public  QLSanPham findByMa(String ma){
       for (int i = 0; i < litsSanPhams.size(); i++) {
           QLSanPham item = litsSanPhams.get(i);
           if(item.getMa().equals(ma)){
               return litsSanPhams.get(i);
           }
       }
       return null;
    }
}
