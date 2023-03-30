package view_model;

public class ChiTietSP {

    private String idSP;
    private String ten_sp;
    private String idNSX;
    private String idMauSac;
    private String idDongSP;
    private int nam_bh;
    private String mo_ta;
    private int slt;
    private double gia_nhap;
    private double gia_ban;

    public ChiTietSP() {
    }

    public String getIdSP() {
        return idSP;
    }

    public void setIdSP(String idSP) {
        this.idSP = idSP;
    }

    public String getTen_sp() {
        return ten_sp;
    }

    public void setTen_sp(String ten_sp) {
        this.ten_sp = ten_sp;
    }

    public String getIdNSX() {
        return idNSX;
    }

    public void setIdNSX(String idNSX) {
        this.idNSX = idNSX;
    }

    public String getIdMauSac() {
        return idMauSac;
    }

    public void setIdMauSac(String idMauSac) {
        this.idMauSac = idMauSac;
    }

    public String getIdDongSP() {
        return idDongSP;
    }

    public void setIdDongSP(String idDongSP) {
        this.idDongSP = idDongSP;
    }

    public int getNam_bh() {
        return nam_bh;
    }

    public void setNam_bh(int nam_bh) {
        this.nam_bh = nam_bh;
    }

    public String getMo_ta() {
        return mo_ta;
    }

    public void setMo_ta(String mo_ta) {
        this.mo_ta = mo_ta;
    }

    public int getSlt() {
        return slt;
    }

    public void setSlt(int slt) {
        this.slt = slt;
    }

    public double getGia_nhap() {
        return gia_nhap;
    }

    public void setGia_nhap(double gia_nhap) {
        this.gia_nhap = gia_nhap;
    }

    public double getGia_ban() {
        return gia_ban;
    }

    public void setGia_ban(double gia_ban) {
        this.gia_ban = gia_ban;
    }

    public ChiTietSP( String ten_sp, int nam_bh, String mo_ta, int slt, double gia_nhap, double gia_ban) {
        this.ten_sp = ten_sp;
        this.nam_bh = nam_bh;
        this.mo_ta = mo_ta;
        this.slt = slt;
        this.gia_nhap = gia_nhap;
        this.gia_ban = gia_ban;
    }
}
