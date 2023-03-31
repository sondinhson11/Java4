package domain_model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name="NhanVien")
public class NhanVienDomain {
    @Id
    @Column(name="Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID Id;
    @Column(name="Ma")
    private String Ma;
    @Column(name="Ten")
    private String Ten;
    @Column(name="TenDem")
    private String TenDem;
    @Column(name="Ho")
    private String Ho;
    @Column(name="NgaySinh")
    private String NgaySinh;
    @Column(name="DiaChi")
    private String DiaChi;
    @Column(name="Sdt")
    private String Sdt;
    @Column(name="MatKhau")
    private String MatKhau;
    @Column(name="IdCH")
    private String IdCH;
    @Column(name="IdCV")
    private String IdCV;
    @Column(name="IdGuiBC")
    private String IdGuiBC;
    @Column(name="TrangThai")
    private int TrangThai;

    public NhanVienDomain() {
    }

    public NhanVienDomain(UUID id, String ma, String ten, String tenDem, String ho, String ngaySinh, String diaChi, String sdt, String matKhau, String idCH, String idCV, String idGuiBC, int trangThai) {
        Id = id;
        Ma = ma;
        Ten = ten;
        TenDem = tenDem;
        Ho = ho;
        NgaySinh = ngaySinh;
        DiaChi = diaChi;
        Sdt = sdt;
        MatKhau = matKhau;
        IdCH = idCH;
        IdCV = idCV;
        IdGuiBC = idGuiBC;
        TrangThai = trangThai;
    }

    public UUID getId() {
        return  Id;
    }

    public void setId(UUID id) {
        Id = id;
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

    public String getTenDem() {
        return TenDem;
    }

    public void setTenDem(String tenDem) {
        TenDem = tenDem;
    }

    public String getHo() {
        return Ho;
    }

    public void setHo(String ho) {
        Ho = ho;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        NgaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    public String getSdt() {
        return Sdt;
    }

    public void setSdt(String sdt) {
        Sdt = sdt;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String matKhau) {
        MatKhau = matKhau;
    }

    public String getIdCH() {
        return IdCH;
    }

    public void setIdCH(String idCH) {
        IdCH = idCH;
    }

    public String getIdCV() {
        return IdCV;
    }

    public void setIdCV(String idCV) {
        IdCV = idCV;
    }

    public String getIdGuiBC() {
        return IdGuiBC;
    }

    public void setIdGuiBC(String idGuiBC) {
        IdGuiBC = idGuiBC;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int trangThai) {
        TrangThai = trangThai;
    }
}
