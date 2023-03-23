package repositories;

import entity.ChucVu;

import java.util.ArrayList;
import java.util.List;

public class ChucVuRepository {
    List<ChucVu> list;

    public ChucVuRepository() {
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

    public void insert(ChucVu kh) {
        list.add(kh);
    }

    public void update(ChucVu kh) {
        int viTri = findMa(kh.getMa());
        list.set(viTri, kh);
    }

    public void delete(ChucVu kh) {
        int viTri = findMa(kh.getMa());
        list.remove(viTri);
    }

    public List<ChucVu> getAll() {
        return list;
    }
    public ChucVu getByMa(String ma){
        int index = findMa(ma);
        if (index==-1)return null;
        return list.get(index);
    }
}
