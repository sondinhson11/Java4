package DomainModel;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.UUID;

@Builder
@Getter
@Setter
@Entity
@Table(name="KhachHang")
public class KhachHang {
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
    private Date NgaySinh;

    @Column(name="Sdt")
    private String Sdt;

    @Column(name="DiaChi")
    private String DiaChi;

    @Column(name="ThanhPho")
    private String ThanhPho;

    @Column(name="QuocGia")
    private String QuocGia;

    @Column(name="MatKhau")
    private String MatKhau;


    public KhachHang(UUID id, String ma, String ten, String tenDem, String ho, Date ngaySinh, String sdt, String diaChi, String thanhPho, String quocGia, String matKhau) {
        Id = id;
        Ma = ma;
        Ten = ten;
        TenDem = tenDem;
        Ho = ho;
        NgaySinh = ngaySinh;
        Sdt = sdt;
        DiaChi = diaChi;
        ThanhPho = thanhPho;
        QuocGia = quocGia;
        MatKhau = matKhau;
    }

    public KhachHang() {
    }


}
