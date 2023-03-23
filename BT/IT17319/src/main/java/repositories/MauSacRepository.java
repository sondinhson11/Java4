package repositories;

import entity.MauSac;

import java.util.ArrayList;
import java.util.List;

public class MauSacRepository {
    List<MauSac> list;

    public MauSacRepository() {
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

    public void insert(MauSac mauSac) {
        list.add(mauSac);
    }

    public void update(MauSac mauSac) {
        int viTri = findMa(mauSac.getMa());
        list.set(viTri, mauSac);
    }

    public void delete(MauSac mauSac) {
        int viTri = findMa(mauSac.getMa());
        list.remove(viTri);
    }

    public List<MauSac> getAll() {
        return list;
    }
    public MauSac getByMa(String ma){
        int index = findMa(ma);
        if (index==-1)return null;
        return list.get(index);
    }
}
