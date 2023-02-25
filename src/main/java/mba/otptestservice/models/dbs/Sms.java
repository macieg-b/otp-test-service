package mba.otptestservice.models.dbs;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "smses")
public class Sms {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "body")
    private String body;
    @Column(name = "creationDt")
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDt;
}
