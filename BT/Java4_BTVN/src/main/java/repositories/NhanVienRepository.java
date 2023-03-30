package repositories;

import ViewModel.QLNhanVien;

import java.util.ArrayList;

public class NhanVienRepository {
    private ArrayList<QLNhanVien> list = new ArrayList<>();
    public NhanVienRepository(){
        this.list=new ArrayList<>();
    }
    public void insert(QLNhanVien qlnv ){
        this.list.add(qlnv);
    }
    public void update(QLNhanVien qlnv){
        for (int i =0 ;i< this.list.size();i++){
        QLNhanVien ql = this.list.get(i);
        if(ql.getMa().equals(qlnv.getMa())){
            this.list.set(i,qlnv);
        }
        }
    }
    public void delete(QLNhanVien qlnv){
        for (int i =0 ;i< this.list.size();i++){
            QLNhanVien ql = this.list.get(i);
            if(ql.getMa().equals(qlnv.getMa())){
                this.list.remove(i);
            }
        }
    }
    public ArrayList<QLNhanVien> findALL(){
       return this.list;
    }
    public QLNhanVien findMa(String ma){
        for (int i =0 ;i< this.list.size();i++){
            QLNhanVien ql = this.list.get(i);
            if(ql.getMa().equals(ma)){
                return ql;
            }
        }
        return null;
    }


}
