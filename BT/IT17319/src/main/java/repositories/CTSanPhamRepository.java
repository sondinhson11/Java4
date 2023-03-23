package repositories;

import entity.CTSanPham;

import java.util.ArrayList;
import java.util.List;

public class CTSanPhamRepository {
    List<CTSanPham> list;

    public CTSanPhamRepository(){
        list = new ArrayList<>();
    }
    private int findMa(String ma) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(ma)) {
                return i;
            }
        }
        return -1;
    }

    public void insert(CTSanPham ctsp) {
        list.add(ctsp);
    }

    public void update(CTSanPham ctsp) {
        int viTri = findMa(ctsp.getId());
        list.set(viTri,ctsp);
    }

    public void delete(CTSanPham ctsp) {
        int viTri = findMa(ctsp.getId());
        list.remove(viTri);
    }

    public List<CTSanPham> getAll(){
        return list;
    }
    public CTSanPham getByMa(String ma){
        return list.get(findMa(ma));
    }
}
