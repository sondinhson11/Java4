package repostory;


import view_model.QLNhanVien;

import java.util.ArrayList;

public class nhanvienrepostory {
    private ArrayList<QLNhanVien> list;
    public nhanvienrepostory(){
        this.list=new ArrayList<>();
    }
    public  void insert(QLNhanVien nv){
        this.list.add(nv);
    }
    public void update(QLNhanVien nv){
        for(int i = 0;i<this.list.size();i++){
            QLNhanVien vm= this.list.get(i);
            if(vm.getMa().equals(nv.getMa())){
                this.list.set(i,nv);
            }
        }
    }
    public void delete(QLNhanVien nv){
        for(int i = 0;i<this.list.size();i++){
            QLNhanVien vm= this.list.get(i);
            if(vm.getMa().equals(nv.getMa())){
                this.list.remove(i);
            }
        }
    }
    public ArrayList<QLNhanVien> findAll(){
        return this.list;
    }
    public QLNhanVien findByMa(String ma){
        for (int i = 0; i < this.list.size(); i++) {
            QLNhanVien vm = this.list.get(i);
            if (vm.getMa().equals(ma)) {
                return this.list.get(i);
            }
        }

        return null;
    }
}
