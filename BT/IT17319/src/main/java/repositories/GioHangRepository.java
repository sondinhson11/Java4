package repositories;

import entity.ChucVu;
import entity.GioHang;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class GioHangRepository {
    List<GioHang> list;

    public GioHangRepository() {
        list = new ArrayList<>();
    }

    private int findMa(String ma) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getMaGH().equals(ma)) {
                return i;
            }
        }
        return -1;
    }
    private int findByTenSanPham(String tenSP) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getTenSanPham().equals(tenSP)) {
                return i;
            }
        }
        return -1;
    }

    public void insert(GioHang gioHang) {
        list.add(gioHang);
    }

    public void update(GioHang gioHang) {
        int viTri = findMa(gioHang.getMaGH());
        list.set(viTri, gioHang);
    }

    public void delete(GioHang gioHang) {
        int viTri = findMa(gioHang.getMaGH());
        list.remove(viTri);
    }

    public List<GioHang> getAll() {
        return list;
    }

    public GioHang getByMa(String ma) {
        return list.get(findMa(ma));
    }
    public GioHang getByTenSP(String tenSP) {
        Integer index = findByTenSanPham(tenSP);
        if (index ==-1){
            return null;
        }
        return list.get(index);
    }

    public BigDecimal getTongTienList()
    {
        BigDecimal bigDecimal = new BigDecimal(0);
        for (GioHang gh : list) {
            bigDecimal= bigDecimal.add(gh.getTongTien());
        }
        return bigDecimal;
    }
}
