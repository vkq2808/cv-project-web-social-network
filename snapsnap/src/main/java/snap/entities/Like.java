package snap.entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "like")
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", length = 100, nullable = false)
    private String userId;

    @ManyToOne
    @JoinColumn(name = "post_id", referencedColumnName = "id", nullable = false)
    private Post post;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = true, insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date createdAt;

    // Constructors, getters, and setters

    public Like() {
        // Default constructor required by JPA
    }

    public Like(String userId, Post post) {
        this.userId = userId;
        this.post = post;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public Like setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public Like setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public Post getPost() {
        return post;
    }

    public Like setPost(Post post) {
        this.post = post;
        return this;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Like setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
        return this;
    }
}
