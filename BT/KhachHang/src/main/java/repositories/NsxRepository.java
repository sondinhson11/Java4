package repositories;

import view_model.QLNSX;

import java.util.ArrayList;

public class NsxRepository {
    private ArrayList<QLNSX> listNSX;

    public NsxRepository() {
        listNSX = new ArrayList<>();
    }

    public void insert(QLNSX nsx) {
        listNSX.add(nsx);
    }

    public void update(QLNSX nsx) {
        for (int i = 0; i < listNSX.size(); i++) {
            QLNSX item = listNSX.get(i);
            if (item.getMa().equals(nsx.getMa())) {
                listNSX.set(i, nsx);
            }
        }
    }

    public void delete(QLNSX nsx) {
        for (int i = 0; i < listNSX.size(); i++) {
            QLNSX item = listNSX.get(i);
            if (item.getMa().equals(nsx.getMa())) {
                listNSX.remove(i);
            }
        }
    }

    public ArrayList<QLNSX> findAll() {
        return listNSX;
    }

    public QLNSX findByMa(String ma) {
        for (int i = 0; i < listNSX.size(); i++) {
            QLNSX item = listNSX.get(i);
            if (item.getMa().equals(ma)) {
                return listNSX.get(i);
            }

        }
        return null;
    }
}

