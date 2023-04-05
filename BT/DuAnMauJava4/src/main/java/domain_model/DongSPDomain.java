package domain_model;


import jakarta.persistence.*;
import org.hibernate.annotations.Type;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "DongSP")
public class DongSPDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "uuid-char") // Sử dụng kiểu dữ liệu UUID
    private UUID id;

    @Column(name="Ma")
    private String Ma;

    @Column(name="Ten")
    private  String Ten;

    @OneToMany(
            mappedBy = "dsp",
            fetch = FetchType.LAZY
    )
    private List<ChiTietSPDomain> listCTSP;

    public DongSPDomain() {
    }

    public DongSPDomain(UUID id, String ma, String ten, List<ChiTietSPDomain> listCTSP) {
        this.id = id;
        Ma = ma;
        Ten = ten;
        this.listCTSP = listCTSP;
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

    public List<ChiTietSPDomain> getListCTSP() {
        return listCTSP;
    }

    public void setListCTSP(List<ChiTietSPDomain> listCTSP) {
        this.listCTSP = listCTSP;
    }
}
