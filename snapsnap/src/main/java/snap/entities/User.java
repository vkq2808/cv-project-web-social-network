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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}
