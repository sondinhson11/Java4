package DomainModel;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@Entity
@Table(name="ChiTietSP")
public class ChiTietSP {

    @Id
    @Column(name="Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String Id;

    @Column(name="IdSP")
    private String IdSP;

    @Column(name="IdNsx")
    private String IdNsx;

    @Column(name="IdDongSP")
    private String IdDongSP;

    @Column(name="NamBH")
    private String namBH;

    @Column(name="MoTa")
    private String moTa;

    @Column(name="SoLuongTon")
    private int soLuongTon;

    @Column(name="GiaNhap")
    private double giaNhap;

    @Column(name="GiaBan")
    private double giaBan;

    public ChiTietSP() {
    }

    public ChiTietSP(String id, String idSP, String idNsx, String idDongSP, String namBH, String moTa, int soLuongTon, double giaNhap, double giaBan) {
        Id = id;
        IdSP = idSP;
        IdNsx = idNsx;
        IdDongSP = idDongSP;
        this.namBH = namBH;
        this.moTa = moTa;
        this.soLuongTon = soLuongTon;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
    }

}
