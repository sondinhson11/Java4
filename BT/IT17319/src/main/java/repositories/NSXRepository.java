package repositories;

import entity.NSX;

import java.util.ArrayList;
import java.util.List;

public class NSXRepository {
    List<NSX> list;

    public NSXRepository() {
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

    public void insert(NSX nsx) {
        list.add(nsx);
    }

    public void update(NSX nsx) {
        int viTri = findMa(nsx.getMa());
        list.set(viTri, nsx);
    }

    public void delete(NSX nsx) {
        int viTri = findMa(nsx.getMa());
        list.remove(viTri);
    }

    public List<NSX> getAll() {
        return list;
    }
    public NSX getByMa(String ma){
        int index = findMa(ma);
        if (index==-1)return null;
        return list.get(index);
    }
}
