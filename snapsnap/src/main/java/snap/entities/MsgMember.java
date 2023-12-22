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
	@Column(name = "join_at", nullable = true, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date joinAt;

	// Getters and setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public MsgFolder getMsgFolder() {
		return msgFolder;
	}

	public void setMsgFolder(MsgFolder msgFolder) {
		this.msgFolder = msgFolder;
	}

	public Date getJoinAt() {
		return joinAt;
	}

	public void setJoinAt(Date joinAt) {
		this.joinAt = joinAt;
	}
}
