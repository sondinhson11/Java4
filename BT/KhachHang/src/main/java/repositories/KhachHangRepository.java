package repositories;

import view_model.QLKhachHang;

import java.util.ArrayList;

public class KhachHangRepository {
    private ArrayList<QLKhachHang> litsKhachHang;

    public KhachHangRepository() {
        this.litsKhachHang = new ArrayList<>();
    }

    public void insert(QLKhachHang kh) {
        //Insert into khachHang(ma,ten,....)
        this.litsKhachHang.add(kh);
    }

    public void update(QLKhachHang kh) {
        //update KhachHang SET ho =?, ten=?, ..where ma = ?
        for (int i = 0; i < this.litsKhachHang.size(); i++) {
            QLKhachHang item = this.litsKhachHang.get(i);
            if (item.getMa().equals(kh.getMa())) {
                this.litsKhachHang.set(i, kh);
            }
        }
    }

    public void delete(QLKhachHang kh) {
        //DELETE FROM KhachHang WHERE ma = ?
        for (int i = 0; i < this.litsKhachHang.size(); i++) {
            QLKhachHang item = this.litsKhachHang.get(i);
            if (item.getMa().equals(kh.getMa())) {
                this.litsKhachHang.remove(i);
            }
        }
    }

    public ArrayList<QLKhachHang> findAll() {
        return litsKhachHang;
    }

    public QLKhachHang findByMa(String ma) {
        //select * from KhachHang where Ma = ?
        for (int i = 0; i < this.litsKhachHang.size(); i++) {
            QLKhachHang item = this.litsKhachHang.get(i);
            if (item.getMa().equals(ma)) {
                return this.litsKhachHang.get(i);
            }
        }
        return null;
    }


}
