package repository;

import viewmodel.QLChucVu;

import java.util.ArrayList;

public class ChucVuRepository {
    private ArrayList<QLChucVu> listChucVu;

    public ChucVuRepository() {
        listChucVu = new ArrayList<>();
    }

    public void insert(QLChucVu cv) {
        listChucVu.add(cv);
    }

    public void update(QLChucVu cv) {
        for (int i = 0; i < listChucVu.size(); i++) {
            QLChucVu item = listChucVu.get(i);
            if (item.getMa().equals(cv.getMa())) {
                listChucVu.set(i, cv);
            }
        }
    }

    public void delete(QLChucVu cv) {
        for (int i = 0; i < listChucVu.size(); i++) {
            QLChucVu item = listChucVu.get(i);
            if (item.getMa().equals(cv.getMa())) {
                listChucVu.remove(i);
            }
        }
    }

    public ArrayList<QLChucVu> findAll() {
        return listChucVu;
    }

    public QLChucVu findByMa(String ma) {
        for (int i = 0; i < listChucVu.size(); i++) {
            QLChucVu item = listChucVu.get(i);
            if (item.getMa().equals(ma)) {
                return listChucVu.get(i);
            }
        }
        return null;
    }

}
