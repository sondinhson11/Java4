package domain_model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "CuaHang")
public class CuaHangDomain {
    @Id
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(name = "Id" , columnDefinition="uniqueidentifier")
    private String id;


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

    @OneToMany(mappedBy = "cuaHang", fetch = FetchType.LAZY)
    List<NhanVienDomain> listCuaHang;

    public CuaHangDomain() {
    }

    public CuaHangDomain(String id, String ma, String ten, String diaChi, String thanhPho, String quocGia) {
        this.id = id;
        Ma = ma;
        Ten = ten;
        DiaChi = diaChi;
        ThanhPho = thanhPho;
        QuocGia = quocGia;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public List<NhanVienDomain> getListCuaHang() {
        return listCuaHang;
    }

    public void setListCuaHang(List<NhanVienDomain> listCuaHang) {
        this.listCuaHang = listCuaHang;
    }
}
