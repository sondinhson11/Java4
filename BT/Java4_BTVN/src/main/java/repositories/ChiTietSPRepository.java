package repositories;

import ViewModel.ChiTietSP;
import java.util.ArrayList;

public class ChiTietSPRepository {
    private ArrayList<ChiTietSP> list1 = new ArrayList<>();
    public ChiTietSPRepository(){
        this.list1=new ArrayList<>();
    }
    public void insert(ChiTietSP ctsp ){


        this.list1.add(ctsp);
    }
    public void update(ChiTietSP ctsp){
        for (int i =0 ;i< this.list1.size();i++){
        ChiTietSP ctsps = this.list1.get(i);
        if(ctsps.getTen_sp().equals(ctsp.getTen_sp())){
            this.list1.set(i,ctsp);
        }
        }
    }
    public void delete(ChiTietSP ct){
        for (int i =0 ;i< this.list1.size();i++){
            ChiTietSP ctsp = this.list1.get(i);
            if(ctsp.getTen_sp().equals(ct.getTen_sp())){
                this.list1.remove(i);
            }
        }
    }
    public ArrayList<ChiTietSP> findALL(){
       return this.list1;
    }
    public ChiTietSP findMa(String ten_sp){
        for (int i =0 ;i< this.list1.size();i++){
            ChiTietSP ctsp = this.list1.get(i);
            if(ctsp.getTen_sp().equals(ten_sp)){
                return ctsp;
            }
        }
        return null;
    }


}
