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


    public NSX() {
    }

    public NSX(UUID id, String ma, String ten) {
        Id = id;
        Ma = ma;
        Ten = ten;
    }
}
