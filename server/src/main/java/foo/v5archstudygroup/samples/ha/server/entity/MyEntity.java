package foo.v5archstudygroup.samples.ha.server.entity;

import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "my_entity")
public class MyEntity implements Persistable<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "my_timestamp", nullable = false)
    private Instant myTimestamp;

    @Column(name = "host", nullable = false)
    private String host;

    @Column(name = "message", nullable = false)
    private String message;

    protected MyEntity() {
    }

    public MyEntity(Instant myTimestamp, String host, String message) {
        this.myTimestamp = myTimestamp;
        this.host = host;
        this.message = message;
    }

    public Instant getMyTimestamp() {
        return myTimestamp;
    }

    public String getHost() {
        return host;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public boolean isNew() {
        return id == null;
    }

}
