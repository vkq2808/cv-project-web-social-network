package snap.entities;

import java.util.Date;
import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "id", length = 100, nullable = false)
    private String id;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "phone", length = 12, nullable = false, unique = true)
    private String phone;

    @Column(name = "email", columnDefinition = "TEXT", nullable = false)
    private String email;

    @Column(name = "password", nullable = false) // Thêm trường password
    private String password;

    @Temporal(TemporalType.DATE)
    @Column(name = "birthdate", nullable = true)
    private Date birthdate;

    @Column(name = "gender", length = 1, nullable = false, columnDefinition = "VARCHAR(1) DEFAULT 'U'")
    private String gender;

    @Column(name = "image", length = 1024, nullable = true)
    private String image;

    // Constructors, getters, and setters

    // Default constructor required by JPA
    public User() {
    }

    public User setId(String id) {
        this.id = id;
        return this;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public User setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public User setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
        return this;
    }

    public User setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public User setImage(String image) {
        this.image = image;
        return this;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public String getGender() {
        return gender;
    }

    public String getImage() {
        return image;
    }
}