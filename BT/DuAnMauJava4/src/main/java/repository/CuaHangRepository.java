package repository;

import viewmodel.QLChucVu;
import viewmodel.QLCuaHang;

import java.util.ArrayList;

public class CuaHangRepository {
    ArrayList<QLCuaHang> list = new ArrayList<>();
    public void insert(QLCuaHang cv) {
        list.add(cv);
    }
    public void update(QLCuaHang cv) {
        for (int i = 0; i < list.size(); i++) {
            QLCuaHang item = list.get(i);
            if (item.getMa().equals(cv.getMa())) {
                list.set(i, cv);
            }
        }
    }

    public void delete(QLCuaHang cv) {
        for (int i = 0; i < list.size(); i++) {
            QLCuaHang item = list.get(i);
            if (item.getMa().equals(cv.getMa())) {
                list.remove(i);
            }
        }
    }

    public ArrayList<QLCuaHang> findAll() {
        return list;
    }

    public QLCuaHang findByMa(String ma) {
        for (int i = 0; i < list.size(); i++) {
            QLCuaHang item = list.get(i);
            if (item.getMa().equals(ma)) {
                return list.get(i);
            }
        }
        return null;
    }

}
