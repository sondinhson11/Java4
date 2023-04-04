package domain_model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="NSX")
public class NSX {
    @Id
    @Column(name="Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID Id;
    @Column(name="Ma")
    private String Ma;
    @Column(name="Ten")
    private String Ten;

    @OneToMany(mappedBy = "nsx",fetch = FetchType.LAZY)
    List<ChiTietSP> listCTSP;
}
