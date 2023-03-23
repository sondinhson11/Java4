package repositories;

import entity.NhanVien;
import viewmodel.Login;

import java.util.ArrayList;
import java.util.List;

public class NhanVienRepository {
    List<NhanVien> list;

    public NhanVienRepository() {
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

    public void insert(NhanVien nv) {
        list.add(nv);
    }

    public void update(NhanVien nv) {
        int viTri = findMa(nv.getMa());
        list.set(viTri, nv);
    }

    public void delete(NhanVien nv) {
        int viTri = findMa(nv.getMa());
        list.remove(viTri);
    }

    public List<NhanVien> getAll() {
        return list;
    }

    public NhanVien getByMa(String ma) {
        int index = findMa(ma);
        if (index==-1)return null;
        return list.get(index);
    }

    public boolean checkUser(Login login) {
        String taiKhoan = login.getTaiKhoan();
        for (NhanVien nv : list) {
            if (nv.getMa().equals(taiKhoan)||nv.getSdt().equals(taiKhoan)){
                if (nv.getMatKhau().equals(login.getMatKhau())){
                    return true;
                }
                break;
            }
        }
        return false;
    }
}
