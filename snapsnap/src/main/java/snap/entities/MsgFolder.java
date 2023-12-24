package snap.entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "msg_folder")
public class MsgFolder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false, insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date createdAt;

    @Column(name = "status")
    private int status;

    // Getters and setters

    public Long getId() {
        return id;
    }

    public MsgFolder setId(Long id) {
        this.id = id;
        return this;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public MsgFolder setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public MsgFolder setStatus(Integer status) {
        this.status = status;
        return this;
    }
}
