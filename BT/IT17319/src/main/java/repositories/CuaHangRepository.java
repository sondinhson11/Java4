package repositories;

import entity.CuaHang;

import java.util.ArrayList;
import java.util.List;

public class CuaHangRepository {
    List<CuaHang> list;

    public CuaHangRepository() {
        list = new ArrayList<>();
    }

    private int findMa(String ma) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getMa().equals(ma)) {
                return i;
            }
        }
        return -1;
    }

    public void insert(CuaHang ch) {
        list.add(ch);
    }

    public void update(CuaHang ch) {
        int viTri = findMa(ch.getMa());
        list.set(viTri, ch);
    }

    public void delete(CuaHang ch) {
        int viTri = findMa(ch.getMa());
        list.remove(viTri);
    }

    public List<CuaHang> getAll() {
        return list;
    }
    public CuaHang getByMa(String ma){
        int index = findMa(ma);
        if (index==-1)return null;
        return list.get(index);
    }
    
}
