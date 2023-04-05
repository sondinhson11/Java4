package repository;

import view_model.QLChiTietSP;
import view_model.QLChucVu;

import java.util.ArrayList;

public class ChiTietSPRepository {
    private ArrayList<QLChiTietSP> list;

    public ChiTietSPRepository() {
        this.list = new ArrayList<>();
    }
    public void insert(QLChiTietSP ctsp){
        this.list.add(ctsp);
    }
    public void update(QLChiTietSP ctsp){
        for (int i = 0; i < this.list.size(); i++) {
            QLChiTietSP item = this.list.get(i);
            if(item.getMa().equals(ctsp.getMa())){
                this.list.set(i,ctsp);
            }
        }
    }
    public void delete(QLChiTietSP ctsp){
        for (int i = 0; i < this.list.size(); i++) {
            QLChiTietSP item = this.list.get(i);
            if(item.getMa().equals(ctsp.getMa())){
                this.list.remove(i);
            }
        }
    }
    public ArrayList<QLChiTietSP> findAll(){
        return this.list;
    }
    public QLChiTietSP findByMa(String ma){
        for (int i = 0; i < this.list.size(); i++) {
            QLChiTietSP item = this.list.get(i);
            if(item.getMa().equals(ma)){
                return this.list.get(i);
            }
        }
        return null;
    }
}
