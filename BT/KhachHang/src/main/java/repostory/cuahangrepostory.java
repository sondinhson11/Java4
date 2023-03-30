package repostory;


import view_model.QLCuaHang;

import java.util.ArrayList;

public class cuahangrepostory {
    private ArrayList<QLCuaHang> list;
    public cuahangrepostory(){
        this.list=new ArrayList<>();
    }
    public  void insert(QLCuaHang qlch){
        this.list.add(qlch);
    }
    public void update(QLCuaHang qlch){
        for(int i = 0;i<this.list.size();i++){
            QLCuaHang vm= this.list.get(i);
            if(vm.getMa().equals(qlch.getMa())){
                this.list.set(i,qlch);
            }
        }
    }
    public void delete(QLCuaHang qlch){
        for(int i = 0;i<this.list.size();i++){
            QLCuaHang vm= this.list.get(i);
            if(vm.getMa().equals(qlch.getMa())){
                this.list.remove(i);
            }
        }
    }
    public ArrayList<QLCuaHang> findAll(){
        return this.list;
    }
    public QLCuaHang findByMa(String ma){
        for (int i = 0; i < this.list.size(); i++) {
            QLCuaHang vm = this.list.get(i);
            if (vm.getMa().equals(ma)) {
                return this.list.get(i);
            }
        }

        return null;
    }
}
