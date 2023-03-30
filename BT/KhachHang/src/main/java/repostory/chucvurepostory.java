package repostory;

import view_model.QLChucVu;

import java.util.ArrayList;

public class chucvurepostory {
    private ArrayList<QLChucVu> list;
    public chucvurepostory(){
        this.list=new ArrayList<>();
    }
    public  void insert(QLChucVu qlcv){
        this.list.add(qlcv);
    }
    public void update(QLChucVu qlcv){
        for(int i = 0;i<this.list.size();i++){
            QLChucVu vm= this.list.get(i);
            if(vm.getMa().equals(qlcv.getMa())){
                this.list.set(i,qlcv);
            }
        }
    }
    public void delete(QLChucVu qlcv){
        for(int i = 0;i<this.list.size();i++){
            QLChucVu vm= this.list.get(i);
            if(vm.getMa().equals(qlcv.getMa())){
                this.list.remove(i);
            }
        }
    }
    public ArrayList<QLChucVu> findAll(){
        return this.list;
    }
    public QLChucVu findByMa(String ma){
        for (int i = 0; i < this.list.size(); i++) {
            QLChucVu vm = this.list.get(i);
            if (vm.getMa().equals(ma)) {
                return this.list.get(i);
            }
        }

        return null;
    }
}
