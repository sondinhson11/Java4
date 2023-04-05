package domain_model;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import java.util.List;
import java.util.UUID;
@Builder
@Getter
@Setter
@Entity
@Table(name="CuaHang")
public class CuaHangDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "uuid-char") // Sử dụng kiểu dữ liệu UUID
    private UUID id;

    @Column(name="Ma")
    private String Ma;

    @Column(name="Ten")
    private String Ten;

    @Column(name="DiaChi")
    private String DiaChi;

    @Column(name="ThanhPho")
    private String ThanhPho;

    @Column(name="QuocGia")
    private String QuocGia;

    @OneToMany(mappedBy = "cuaHang",fetch = FetchType.EAGER)
    private List<NhanVienDomain> listNV;
    public CuaHangDomain() {
    }


    public CuaHangDomain(UUID id, String ma, String ten, String diaChi, String thanhPho, String quocGia, List<NhanVienDomain> listNV) {
        this.id = id;
        Ma = ma;
        Ten = ten;
        DiaChi = diaChi;
        ThanhPho = thanhPho;
        QuocGia = quocGia;
        this.listNV = listNV;
    }
}
