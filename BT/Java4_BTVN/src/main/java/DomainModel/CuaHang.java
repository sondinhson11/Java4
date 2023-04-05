package DomainModel;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;
@Builder
@Getter
@Setter
@Entity
@Table(name="CuaHang")
public class CuaHang {
    @Id
    @Column(name="Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID Id;

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

    @OneToMany(mappedBy = "ch",fetch = FetchType.EAGER)
    private List<NhanVien> listNV;
    public CuaHang() {
    }


    public CuaHang(UUID id, String ma, String ten, String diaChi, String thanhPho, String quocGia, List<NhanVien> listNV) {
        Id = id;
        Ma = ma;
        Ten = ten;
        DiaChi = diaChi;
        ThanhPho = thanhPho;
        QuocGia = quocGia;
        this.listNV = listNV;
    }
}
