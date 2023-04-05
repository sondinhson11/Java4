package domain_model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import java.util.List;
import java.util.UUID;
@Entity
@Table(name = "MauSac")
public class MauSacDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "uuid-char") // Sử dụng kiểu dữ liệu UUID
    private UUID Id;

    @Column(name="Ma")
    private String Ma;

    @Column(name="Ten")
    private  String Ten;

    @OneToMany(
            mappedBy = "ms",
            fetch = FetchType.LAZY
    )
    private List<ChiTietSPDomain> listCTSP;


    public MauSacDomain() {
    }

    public MauSacDomain(UUID id, String ma, String ten, List<ChiTietSPDomain> listCTSP) {
        Id = id;
        Ma = ma;
        Ten = ten;
        this.listCTSP = listCTSP;
    }

    public UUID getId() {
        return Id;
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

    public List<ChiTietSPDomain> getListCTSP() {
        return listCTSP;
    }

    public void setListCTSP(List<ChiTietSPDomain> listCTSP) {
        this.listCTSP = listCTSP;
    }
}
