package DomainModel;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Builder
@Getter
@Setter
@Entity
@Table(name="MauSac")
public class MauSac {
    @Id
    @Column(name="Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID Id;

    @Column(name="Ma")
    private String Ma;

    @Column(name="Ten")
    private String Ten;

    public MauSac() {
    }

    public MauSac(UUID id, String ma, String ten) {
        Id = id;
        Ma = ma;
        Ten = ten;
    }
}
