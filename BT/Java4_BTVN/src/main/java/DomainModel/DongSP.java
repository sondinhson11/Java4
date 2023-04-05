package DomainModel;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Builder
@Getter
@Setter
@Entity
@Table(name="DongSP")
public class DongSP {
    @Id
    @Column(name="Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID Id;

    @Column(name="Ma")
    private String Ma;

    @Column(name="Ten")
    private String Ten;

    public DongSP() {
    }

    public DongSP(UUID id, String ma, String ten) {
        Id = id;
        Ma = ma;
        Ten = ten;
    }
}
