package repositories;

import view_model.QLDongSP;

import java.util.ArrayList;

public class DongSPRepository {
   private ArrayList<QLDongSP> listDongSP ;
    public DongSPRepository(){
       listDongSP = new ArrayList<>();
    }

    public void insert(QLDongSP dsp){
        listDongSP.add(dsp);
    }
    public void update(QLDongSP dsp){
        for (int i = 0; i < listDongSP.size(); i++) {
            QLDongSP item = listDongSP.get(i);
            if(item.getMa().equals(dsp.getMa())){
                listDongSP.set(i, dsp);
            }
        }
    }
    public void delete(QLDongSP dsp){
        for (int i = 0; i < listDongSP.size(); i++) {
            QLDongSP item = listDongSP.get(i);
            if(item.getMa().equals(dsp.getMa())){
                listDongSP.remove(i);
            }
        }
    }
    public ArrayList<QLDongSP> findAll(){
        return listDongSP;
    }

    public QLDongSP findByMa(String ma){
        for (int i = 0; i < listDongSP.size(); i++) {
            QLDongSP item = listDongSP.get(i);
            if(item.getMa().equals(ma)){
                return listDongSP.get(i);
            }
        }
        return null;
    }
}
