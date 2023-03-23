package entity;

import java.awt.*;
import java.math.BigDecimal;

public class CTSanPham {
    private String id;
    private String tenSanPham;
    private String dongSanPham;
    private String mauSac;
    private String NSX;
    private Integer namBH;
    private String moTa;
    private Integer soLuongTon;
    private BigDecimal giaNhap;
    private BigDecimal giaBan;
    private String anhSanPham;

    public CTSanPham() {
    }
    public CTSanPham(String id, String tenSanPham, String dongSanPham, String mauSac, String NSX, Integer namBH, String moTa, Integer soLuongTon, BigDecimal giaNhap, BigDecimal giaBan) {
        this.id = id;
        this.tenSanPham = tenSanPham;
        this.dongSanPham = dongSanPham;
        this.mauSac = mauSac;
        this.NSX = NSX;
        this.namBH = namBH;
        this.moTa = moTa;
        this.soLuongTon = soLuongTon;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
    }

    public CTSanPham(String id, String tenSanPham, String dongSanPham, String mauSac, String NSX, Integer namBH, String moTa, Integer soLuongTon, BigDecimal giaNhap, BigDecimal giaBan, String anhSanPham) {
        this.id = id;
        this.tenSanPham = tenSanPham;
        this.dongSanPham = dongSanPham;
        this.mauSac = mauSac;
        this.NSX = NSX;
        this.namBH = namBH;
        this.moTa = moTa;
        this.soLuongTon = soLuongTon;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.anhSanPham = anhSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public String getDongSanPham() {
        return dongSanPham;
    }

    public void setDongSanPham(String dongSanPham) {
        this.dongSanPham = dongSanPham;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public String getNSX() {
        return NSX;
    }

    public void setNSX(String NSX) {
        this.NSX = NSX;
    }

    public String getAnhSanPham() {
        return anhSanPham;
    }

    public void setAnhSanPham(String anhSanPham) {
        this.anhSanPham = anhSanPham;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getNamBH() {
        return namBH;
    }

    public void setNamBH(Integer namBH) {
        this.namBH = namBH;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public Integer getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(Integer soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    public BigDecimal getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(BigDecimal giaNhap) {
        this.giaNhap = giaNhap;
    }

    public BigDecimal getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(BigDecimal giaBan) {
        this.giaBan = giaBan;
    }


}
