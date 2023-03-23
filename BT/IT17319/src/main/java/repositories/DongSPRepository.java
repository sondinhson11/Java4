package repositories;

import entity.DongSP;

import java.util.ArrayList;
import java.util.List;

public class DongSPRepository {
    List<DongSP> list;

    public DongSPRepository() {
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

    public void insert(DongSP dongSP) {
        list.add(dongSP);
    }

    public void update(DongSP dongSP) {
        int viTri = findMa(dongSP.getMa());
        list.set(viTri, dongSP);
    }

    public void delete(DongSP dongSP) {
        int viTri = findMa(dongSP.getMa());
        list.remove(viTri);
    }

    public List<DongSP> getAll() {
        return list;
    }
    public DongSP getByMa(String ma){
        int index = findMa(ma);
        if (index==-1)return null;
        return list.get(index);
    }
}
