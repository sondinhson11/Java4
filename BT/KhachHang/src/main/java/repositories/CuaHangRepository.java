package repositories;

import view_model.QLCuaHang;

import java.util.ArrayList;

public class CuaHangRepository {
    private ArrayList<QLCuaHang> listCuaHang;

    public CuaHangRepository() {
        listCuaHang = new ArrayList<>();
    }

    public void insert(QLCuaHang ch) {
        listCuaHang.add(ch);
    }

    public void update(QLCuaHang ch) {
        for (int i = 0; i < listCuaHang.size(); i++) {
            QLCuaHang item = listCuaHang.get(i);
            if (item.getMa().equals(ch.getMa())) {
                listCuaHang.set(i, ch);
            }
        }
    }

    public void delete(QLCuaHang ch) {
        for (int i = 0; i < listCuaHang.size(); i++) {
            QLCuaHang item = listCuaHang.get(i);
            if (item.getMa().equals(ch.getMa())) {
                listCuaHang.remove(i);
            }
        }
    }

    public ArrayList<QLCuaHang> findAll() {
        return listCuaHang;
    }

    public QLCuaHang findByMa(String ma) {
        for (int i = 0; i < listCuaHang.size(); i++) {
            QLCuaHang item = listCuaHang.get(i);
            if (item.getMa().equals(ma)) {
                return listCuaHang.get(i);
            }
        }
        return null;
    }
}
