package domain_model;


import jakarta.persistence.*;
import org.hibernate.annotations.Type;

import java.util.UUID;

@Entity
@Table(name = "SanPham")
public class SanPhamDomain {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name="Ma")
    private String Ma;

    @Column(name="Ten")
    private  String Ten;

    public SanPhamDomain() {
    }

    public SanPhamDomain(UUID id, String ma, String ten) {
        this.id = id;
        Ma = ma;
        Ten = ten;
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
}
