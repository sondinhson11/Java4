package repositories;

import entity.KhachHang;
import entity.NhanVien;
import viewmodel.Login;
import viewmodel.QLKhachHang;

import java.util.ArrayList;
import java.util.List;

public class KhachHangRepository {
    List<QLKhachHang> list;

    public KhachHangRepository(){
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

    public void insert(QLKhachHang kh) {
        list.add(kh);
    }

    public void update(QLKhachHang kh) {
        int viTri = findMa(kh.getMa());
        list.set(viTri,kh);
    }

    public void delete(QLKhachHang kh) {
        int viTri = findMa(kh.getMa());
        list.remove(viTri);
    }

    public List<QLKhachHang> getAll(){
        return list;
    }
    public QLKhachHang findByMa(String ma){
        return list.get(findMa(ma));
    }

    public boolean checkUser(Login login) {
        String taiKhoan = login.getTaiKhoan();
        for (QLKhachHang nv : list) {
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
