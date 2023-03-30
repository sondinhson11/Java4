package repostory;

import view_model.QLDongSP;


import java.util.ArrayList;

public class dongsprepostory {
    private ArrayList<QLDongSP> list;
    public dongsprepostory(){
        this.list=new ArrayList<>();
    }
    public  void insert(QLDongSP qldsp){
        this.list.add(qldsp);
    }
    public void update(QLDongSP qldsp){
        for(int i = 0;i<this.list.size();i++){
            QLDongSP vm= this.list.get(i);
            if(vm.getMa().equals(qldsp.getMa())){
                this.list.set(i,qldsp);
            }
        }
    }
    public void delete(QLDongSP qldsp){
        for(int i = 0;i<this.list.size();i++){
            QLDongSP vm= this.list.get(i);
            if(vm.getMa().equals(qldsp.getMa())){
                this.list.remove(i);
            }
        }
    }
    public ArrayList<QLDongSP> findAll(){
        return this.list;
    }
    public QLDongSP findByMa(String ma){
        for (int i = 0; i < this.list.size(); i++) {
            QLDongSP vm = this.list.get(i);
            if (vm.getMa().equals(ma)) {
                return this.list.get(i);
            }
        }

        return null;
    }
}
