package DomainModel;


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
@Table(name="ChucVu")
public class ChucVu {
    @Id
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(name = "Id" , columnDefinition="uniqueidentifier")
    private String Id;

    @Column(name="Ma")
    private String Ma;

    @Column(name="Ten")
    private String Ten;

    @OneToMany(mappedBy = "cv",fetch = FetchType.EAGER)
    private List<NhanVien> listNV;

    public ChucVu() {
    }

    public ChucVu(String id, String ma, String ten, List<NhanVien> listNV) {
        Id = id;
        Ma = ma;
        Ten = ten;
        this.listNV = listNV;
    }


}

