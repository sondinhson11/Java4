package domain_model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="SanPham")
public class SanPham {
    @Id
    @Column(name="Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID Id;
    @Column(name="Ma")
    private String Ma;
    @Column(name="Ten")
    private String Ten;

    @OneToMany(mappedBy = "sanPham",fetch = FetchType.LAZY)
    List<ChiTietSP> listCTSP;
}
