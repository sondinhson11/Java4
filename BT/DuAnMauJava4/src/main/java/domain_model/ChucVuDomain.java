package domain_model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "ChucVu")
public class ChucVuDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "uuid-char") // Sử dụng kiểu dữ liệu UUID
    private UUID id;

    @Column(name="Ma")
    private String Ma;

    @Column(name="Ten")
    private  String Ten;

    @OneToMany(
            mappedBy = "cv",
            fetch = FetchType.LAZY
    )
    private List<NhanVienDomain> listNv;

    public ChucVuDomain() {
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

    public List<NhanVienDomain> getListNv() {
        return listNv;
    }

    public void setListNv(List<NhanVienDomain> listNv) {
        this.listNv = listNv;
    }
}
