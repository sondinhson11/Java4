package repositories;

import view_model.QLNhanVien;

import java.util.ArrayList;

public class NhanVienRepository {
    ArrayList<QLNhanVien> listNhanVien ;

    public NhanVienRepository(){
        listNhanVien = new ArrayList<>();
    }
    public void insert(QLNhanVien nv){
        listNhanVien.add(nv);
    }
    public void update(QLNhanVien nv){

    }

}
