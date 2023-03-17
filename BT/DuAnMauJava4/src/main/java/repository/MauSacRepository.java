package repository;

import viewmodel.QLMauSac;

import java.util.ArrayList;

public class MauSacRepository {
    private ArrayList<QLMauSac> listMauSac;

    public MauSacRepository() {
        this.listMauSac = new ArrayList<>();
    }

    public void insert(QLMauSac ms) {
        listMauSac.add(ms);
    }

    public void update(QLMauSac ms) {
        for (int i = 0; i < listMauSac.size(); i++) {
            QLMauSac item = listMauSac.get(i);
            if (item.getMa().equals(ms.getMa())) {
                listMauSac.set(i, ms);
            }
        }
    }

    public void delete(QLMauSac ms) {
        for (int i = 0; i < listMauSac.size(); i++) {
            QLMauSac item = listMauSac.get(i);
            if (item.getMa().equals(ms.getMa())) {
                listMauSac.remove(i);
            }
        }
    }

    public ArrayList<QLMauSac> findAll() {
        return listMauSac;
    }

    public QLMauSac findByMa(String ma) {
        for (int i = 0; i < listMauSac.size(); i++) {
            QLMauSac item = listMauSac.get(i);
            if (item.getMa().equals(ma)) {
                return listMauSac.get(i);
            }
        }
        return null;
    }
}
