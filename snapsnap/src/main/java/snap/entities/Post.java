package snap.entities;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false, insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date createdAt;

    @Column(name = "user_id", length = 100, nullable = false)
    private String userId;

    @Column(name = "content", columnDefinition = "TEXT")
    private String content;

    @Column(name = "image", columnDefinition = "TEXT")
    private String image;

    @Column(name = "status", nullable = false, columnDefinition = "TINYINT DEFAULT 1")
    private Integer status;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private User user;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Like> likes;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments;

    // Getters and setters

    public Long getId() {
        return id;
    }

    public Post setId(Long id) {
        this.id = id;
        return this;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Post setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public Post setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public String getContent() {
        return content;
    }

    public Post setContent(String content) {
        this.content = content;
        return this;
    }

    public String getImage() {
        return image;
    }

    public Post setImage(String image) {
        this.image = image;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public Post setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Post setUser(User user) {
        this.user = user;
        return this;
    }

    public List<Like> getLikes() {
        return likes;
    }

    public Post setLikes(List<Like> likes) {
        this.likes = likes;
        return this;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public Post setComments(List<Comment> comments) {
        this.comments = comments;
        return this;
    }
}
