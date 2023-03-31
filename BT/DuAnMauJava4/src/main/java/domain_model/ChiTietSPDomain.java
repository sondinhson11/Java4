package domain_model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name="ChiTietSP")
public class ChiTietSPDomain {
    @Id
    @Column(name="Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID Id;
    @Column(name="IdSP")
    private String IdSP;
    @Column(name="IdNsx")
    private String IdNsx;
    @Column(name="IdMauSac")
    private String IdMauSac;
    @Column(name="IdDongSP")
    private String IdDongSP;
    @Column(name="NamBH")
    private String NamBH;
    @Column(name="MoTa")
    private String MoTa;
    @Column(name="SoLuongTon")
    private String SoLuongTon;
    @Column(name="GiaNhap")
    private String GiaNhap;
    @Column(name="GiaBan")
    private String GiaBan;

    public ChiTietSPDomain() {
    }

    public ChiTietSPDomain(UUID id, String idSP, String idNsx, String idMauSac, String idDongSP, String namBH, String moTa, String soLuongTon, String giaNhap, String giaBan) {
        Id = id;
        IdSP = idSP;
        IdNsx = idNsx;
        IdMauSac = idMauSac;
        IdDongSP = idDongSP;
        NamBH = namBH;
        MoTa = moTa;
        SoLuongTon = soLuongTon;
        GiaNhap = giaNhap;
        GiaBan = giaBan;
    }

    public UUID getId() {
        return Id;
    }

    public void setId(UUID id) {
        Id = id;
    }

    public String getIdSP() {
        return IdSP;
    }

    public void setIdSP(String idSP) {
        IdSP = idSP;
    }

    public String getIdNsx() {
        return IdNsx;
    }

    public void setIdNsx(String idNsx) {
        IdNsx = idNsx;
    }

    public String getIdMauSac() {
        return IdMauSac;
    }

    public void setIdMauSac(String idMauSac) {
        IdMauSac = idMauSac;
    }

    public String getIdDongSP() {
        return IdDongSP;
    }

    public void setIdDongSP(String idDongSP) {
        IdDongSP = idDongSP;
    }

    public String getNamBH() {
        return NamBH;
    }

    public void setNamBH(String namBH) {
        NamBH = namBH;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String moTa) {
        MoTa = moTa;
    }

    public String getSoLuongTon() {
        return SoLuongTon;
    }

    public void setSoLuongTon(String soLuongTon) {
        SoLuongTon = soLuongTon;
    }

    public String getGiaNhap() {
        return GiaNhap;
    }

    public void setGiaNhap(String giaNhap) {
        GiaNhap = giaNhap;
    }

    public String getGiaBan() {
        return GiaBan;
    }

    public void setGiaBan(String giaBan) {
        GiaBan = giaBan;
    }
}
