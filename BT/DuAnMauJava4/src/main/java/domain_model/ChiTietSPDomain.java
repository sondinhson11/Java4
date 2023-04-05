package domain_model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import java.util.UUID;


@Entity
@Table(name="ChiTietSP")
public class ChiTietSPDomain {
    @Id
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(name = "Id" , columnDefinition="uniqueidentifier")
    private String Id;

    @ManyToOne()
    @JoinColumn(
            name = "IdSP",
            referencedColumnName = "Id"
    )
    private SanPhamDomain sp;

    @ManyToOne()
    @JoinColumn(
            name = "IdNsx",
            referencedColumnName = "Id"
    )
    private NSXDomain nsx;

    @ManyToOne()
    @JoinColumn(
            name = "IdMauSac",
            referencedColumnName = "Id"
    )
    private MauSacDomain ms;

    @ManyToOne()
    @JoinColumn(
            name = "IdDongSP",
            referencedColumnName = "Id"
    )
    private DongSPDomain dsp;

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

    public ChiTietSPDomain(String id, SanPhamDomain sp, NSXDomain nsx, MauSacDomain ms, DongSPDomain dsp, String namBH, String moTa, String soLuongTon, String giaNhap, String giaBan) {
        Id = id;
        this.sp = sp;
        this.nsx = nsx;
        this.ms = ms;
        this.dsp = dsp;
        NamBH = namBH;
        MoTa = moTa;
        SoLuongTon = soLuongTon;
        GiaNhap = giaNhap;
        GiaBan = giaBan;
    }

    public String getId() {
        return Id;
    }

    public void setId(String     id) {
        Id = id;
    }

    public SanPhamDomain getSp() {
        return sp;
    }

    public void setSp(SanPhamDomain sp) {
        this.sp = sp;
    }

    public NSXDomain getNsx() {
        return nsx;
    }

    public void setNsx(NSXDomain nsx) {
        this.nsx = nsx;
    }

    public MauSacDomain getMs() {
        return ms;
    }

    public void setMs(MauSacDomain ms) {
        this.ms = ms;
    }

    public DongSPDomain getDsp() {
        return dsp;
    }

    public void setDsp(DongSPDomain dsp) {
        this.dsp = dsp;
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
