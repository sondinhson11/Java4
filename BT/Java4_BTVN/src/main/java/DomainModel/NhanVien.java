package DomainModel;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import java.util.Date;
import java.util.UUID;
@Builder
@Getter
@Setter
@Entity
@Table(name="NhanVien")
public class NhanVien {
    @Id
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(name = "ID" , columnDefinition="uniqueidentifier")
    private String Id;

    @Column(name="Ma")
    private String Ma;

    @Column(name="Ten")
    private String Ten;

    @Column(name="TenDem")
    private String TenDem;

    @Column(name="Ho")
    private String Ho;

    @Column(name="NgaySinh")
    private Date NgaySinh;

    @Column(name="Sdt")
    private String Sdt;

    @Column(name="DiaChi")
    private String DiaChi;


    @Column(name="MatKhau")
    private String MatKhau;

    @Column(name="GioiTinh")
    private String GioiTinh;


    @ManyToOne()
    @JoinColumn(
            name="IdCV",
            referencedColumnName = "Id",
            nullable = false
    )
    private ChucVu cv;
    @ManyToOne()
    @JoinColumn(
            name="IdCH",
            referencedColumnName = "Id",
            nullable = false
    )
    private CuaHang ch;

    @Column(name="IdGuiBC")
    private String idGuiBC;


    @Column(name="TrangThai")
    private int trangThai;

    public NhanVien() {
    }

    public NhanVien(String id, String ma, String ten, String tenDem, String ho, Date ngaySinh, String sdt, String diaChi, String matKhau, String gioiTinh,  ChucVu cv, CuaHang ch, String idGuiBC, int trangThai) {
        Id = id;
        Ma = ma;
        Ten = ten;
        TenDem = tenDem;
        Ho = ho;
        NgaySinh = ngaySinh;
        Sdt = sdt;
        DiaChi = diaChi;
        MatKhau = matKhau;
        GioiTinh = gioiTinh;
        this.cv = cv;
        this.ch = ch;
        this.idGuiBC = idGuiBC;
        this.trangThai = trangThai;
    }


}
