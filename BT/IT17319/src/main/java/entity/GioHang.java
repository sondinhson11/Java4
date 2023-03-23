package entity;

import java.math.BigDecimal;

public class GioHang {
    private String maGH;
    private String maKH;
    private String tenSanPham;
    private String anhSanPham;
    private Integer soLuong;
    private BigDecimal donGia;
    private BigDecimal tongTien;

    public GioHang() {
    }

    public GioHang(String maGH, String maKH, String tenSanPham, Integer soLuong, BigDecimal donGia) {
        this.maGH = maGH;
        this.maKH = maKH;
        this.tenSanPham = tenSanPham;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public String getMaGH() {
        return maGH;
    }

    public void setMaGH(String maGH) {
        this.maGH = maGH;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public String getAnhSanPham() {
        return anhSanPham;
    }

    public void setAnhSanPham(String anhSanPham) {
        this.anhSanPham = anhSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public BigDecimal getDonGia() {
        return donGia;
    }

    public void setDonGia(BigDecimal donGia) {
        this.donGia = donGia;
    }

    public BigDecimal getTongTien() {
        return donGia.multiply(BigDecimal.valueOf(Long.valueOf(soLuong)));
    }

    @Override
    public String toString() {
        return "GioHang{" +
                "maGH='" + maGH + '\'' +
                ", maKH='" + maKH + '\'' +
                ", tenSanPham='" + tenSanPham + '\'' +
                ", soLuong=" + soLuong +
                ", donGia=" + donGia +
                '}';
    }

}
