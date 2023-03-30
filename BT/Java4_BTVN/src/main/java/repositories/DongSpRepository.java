package repositories;

import ViewModel.DongSP;

import java.util.ArrayList;

public class DongSpRepository {
    private ArrayList<DongSP> list = new ArrayList<>();
    public DongSpRepository(){
        this.list=new ArrayList<>();
    }
    public void insert(DongSP dsp ){
        this.list.add(dsp);
    }
    public void update(DongSP dsp){
        for (int i =0 ;i< this.list.size();i++){
            DongSP dsps = this.list.get(i);
        if(dsps.getMa().equals(dsp.getMa())){
            this.list.set(i,dsp);
        }
        }
    }
    public void delete(DongSP dsp){
        for (int i =0 ;i< this.list.size();i++){
            DongSP dsps = this.list.get(i);
            if(dsps.getMa().equals(dsp.getMa())){
                this.list.remove(i);
            }
        }
    }
    public ArrayList<DongSP> findALL(){
       return this.list;
    }
    public DongSP findMa(String ma){
        for (int i =0 ;i< this.list.size();i++){
            DongSP dsps = this.list.get(i);
            if(dsps.getMa().equals(ma)){
                return dsps;
            }
        }
        return null;
    }


}
