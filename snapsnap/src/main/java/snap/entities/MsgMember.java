package snap.entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "msg_member")
public class MsgMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", length = 100, nullable = false)
    private String userId;

    @ManyToOne
    @JoinColumn(name = "msg_folder_id", referencedColumnName = "id", nullable = false)
    private MsgFolder msgFolder;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "join_at", nullable = true, insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date joinAt;

    // Getters and setters

    public Long getId() {
        return id;
    }

    public MsgMember setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public MsgMember setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public MsgFolder getMsgFolder() {
        return msgFolder;
    }

    public MsgMember setMsgFolder(MsgFolder msgFolder) {
        this.msgFolder = msgFolder;
        return this;
    }

    public Date getJoinAt() {
        return joinAt;
    }

    public MsgMember setJoinAt(Date joinAt) {
        this.joinAt = joinAt;
        return this;
    }
}
