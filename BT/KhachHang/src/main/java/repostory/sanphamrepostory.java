package repostory;

import view_model.QLMauSac;
import view_model.QLSanPham;

import java.util.ArrayList;

public class sanphamrepostory {
    private ArrayList<QLSanPham> list;
    public sanphamrepostory(){
        this.list=new ArrayList<>();
    }
    public  void insert(QLSanPham qlsp){
        this.list.add(qlsp);
    }
    public void update(QLSanPham qlsp){
        for(int i = 0;i<this.list.size();i++){
            QLSanPham vm= this.list.get(i);
            if(vm.getMa().equals(qlsp.getMa())){
                this.list.set(i,qlsp);
            }
        }
    }
    public void delete(QLSanPham qlsp){
        for(int i = 0;i<this.list.size();i++){
            QLSanPham vm= this.list.get(i);
            if(vm.getMa().equals(qlsp.getMa())){
                this.list.remove(i);
            }
        }
    }
    public ArrayList<QLSanPham> findAll(){
        return this.list;
    }
    public QLSanPham findByMa(String ma){
        for (int i = 0; i < this.list.size(); i++) {
            QLSanPham vm = this.list.get(i);
            if (vm.getMa().equals(ma)) {
                return this.list.get(i);
            }
        }

        return null;
    }
}
