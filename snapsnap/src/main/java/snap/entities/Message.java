package snap.entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "msg")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", length = 100)
    private String userId;

    @Column(name = "content", columnDefinition = "TEXT")
    private String content;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date createdAt;

    @ManyToOne
    @JoinColumn(name = "msg_folder_id", referencedColumnName = "id")
    private MsgFolder msgFolder;

    // Getters and setters

    public Long getId() {
        return id;
    }

    public Message setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public Message setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public String getContent() {
        return content;
    }

    public Message setContent(String content) {
        this.content = content;
        return this;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Message setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public MsgFolder getMsgFolder() {
        return msgFolder;
    }

    public Message setMsgFolder(MsgFolder msgFolder) {
        this.msgFolder = msgFolder;
        return this;
    }
}
