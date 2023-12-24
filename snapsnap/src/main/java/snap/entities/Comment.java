package snap.entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", length = 100, nullable = false)
    private String userId;

    @ManyToOne
    @JoinColumn(name = "post_id", referencedColumnName = "id", nullable = false)
    private Post post;

    @Column(name = "content", columnDefinition = "TEXT")
    private String content;

    @Column(name = "image", columnDefinition = "TEXT")
    private String image;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = true, insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date createdAt;

    // Getters and setters

    public Long getId() {
        return id;
    }

    public Comment setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public Comment setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public Post getPost() {
        return post;
    }

    public Comment setPost(Post post) {
        this.post = post;
        return this;
    }

    public String getContent() {
        return content;
    }

    public Comment setContent(String content) {
        this.content = content;
        return this;
    }

    public String getImage() {
        return image;
    }

    public Comment setImage(String image) {
        this.image = image;
        return this;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Comment setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
        return this;
    }
}
