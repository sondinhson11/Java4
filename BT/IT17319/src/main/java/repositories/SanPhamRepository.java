package repositories;

import entity.SanPham;

import java.util.ArrayList;
import java.util.List;

public class SanPhamRepository {
    List<SanPham> list;

    public SanPhamRepository() {
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

    public void insert(SanPham sanPham) {
        list.add(sanPham);
    }

    public void update(SanPham sanPham) {
        int viTri = findMa(sanPham.getMa());
        list.set(viTri, sanPham);
    }

    public void delete(SanPham sanPham) {
        int viTri = findMa(sanPham.getMa());
        list.remove(viTri);
    }

    public List<SanPham> getAll() {
        return list;
    }
    public SanPham getByMa(String ma){
        int index = findMa(ma);
        if (index==-1)return null;
        return list.get(index);
    }
}
