package domain_model;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "CuaHang")
public class CuaHangDomain {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name="Ma")
    private String Ma;

    @Column(name="Ten")
    private  String Ten;

    @Column(name="DiaChi")
    private String DiaChi;

    @Column(name="ThanhPho")
    private  String ThanhPho;

    @Column(name="QuocGia")
    private String QuocGia;

    @OneToMany(
            mappedBy = "ch",
            fetch = FetchType.LAZY
    )
    private List<CuaHangDomain> listCH;


    public CuaHangDomain() {
    }

    public CuaHangDomain(UUID id, String ma, String ten, String diaChi, String thanhPho, String quocGia) {
        this.id = id;
        Ma = ma;
        Ten = ten;
        DiaChi = diaChi;
        ThanhPho = thanhPho;
        QuocGia = quocGia;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getMa() {
        return Ma;
    }

    public void setMa(String ma) {
        Ma = ma;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    public String getThanhPho() {
        return ThanhPho;
    }

    public void setThanhPho(String thanhPho) {
        ThanhPho = thanhPho;
    }

    public String getQuocGia() {
        return QuocGia;
    }

    public void setQuocGia(String quocGia) {
        QuocGia = quocGia;
    }

    public List<CuaHangDomain> listCH() {
        return listCH;
    }
    public void listCH(List<CuaHangDomain> listCH) {
        this.listCH = listCH;
    }
}
