package in.QuizHub.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class UserData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", length = 10)
	private int id;
	@Column(name = "full_name", length = 50, nullable = false)
	private String fullName;
	@Column(name = "user_name", length = 50, nullable = false)
	private String userName;
	@Column(name = "email", length = 100, unique = true, nullable = false)
	private String email;
	@Column(name = "contact_no", length = 100, nullable = false)
	private String contactNo;
	@Column(name = "password", length = 100, unique = true, nullable = false, updatable = true)
	private String password;
	@Column(name = "gender", length = 50, nullable = false)
	private String gender;

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
}
