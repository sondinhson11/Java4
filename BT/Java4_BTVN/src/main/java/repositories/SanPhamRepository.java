package repositories;

import ViewModel.SanPham;

import java.util.ArrayList;

public class SanPhamRepository {
    private ArrayList<SanPham> list = new ArrayList<>();
    public SanPhamRepository(){
        this.list=new ArrayList<>();
    }
    public void insert(SanPham sp ){
        this.list.add(sp);
    }
    public void update(SanPham sp){
        for (int i =0 ;i< this.list.size();i++){
        SanPham ql = this.list.get(i);
        if(ql.getMa().equals(sp.getMa())){
            this.list.set(i,sp);
        }
        }
    }
    public void delete(SanPham sp){
        for (int i =0 ;i< this.list.size();i++){
            SanPham ql = this.list.get(i);
            if(ql.getMa().equals(sp.getMa())){
                this.list.remove(i);
            }
        }
    }
    public ArrayList<SanPham> findALL(){
       return this.list;
    }
    public SanPham findMa(String ma){
        for (int i =0 ;i< this.list.size();i++){
            SanPham ql = this.list.get(i);
            if(ql.getMa().equals(ma)){
                return ql;
            }
        }
        return null;
    }


}
