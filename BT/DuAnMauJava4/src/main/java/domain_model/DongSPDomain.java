package domain_model;


import jakarta.persistence.*;

@Entity
@Table(name = "DongSP")
public class DongSPDomain {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name="Ma")
    private String Ma;

    @Column(name="Ten")
    private  String Ten;

    public DongSPDomain() {
    }

    public DongSPDomain(String id, String ma, String ten) {
        this.id = id;
        Ma = ma;
        Ten = ten;
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
}
