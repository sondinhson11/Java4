package domain_model;


import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "ChucVu")
public class ChucVuDomain {
    @Id
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(name = "Id" , columnDefinition="uniqueidentifier")
    private String id;

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

    public List<NhanVienDomain> getListNv() {
        return listNv;
    }

    public void setListNv(List<NhanVienDomain> listNv) {
        this.listNv = listNv;
    }
}
