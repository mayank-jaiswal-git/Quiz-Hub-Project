package in.QuizHub.Response;

public class LoginResponse {
	private String message;
	private boolean status;
	private String token;


	public LoginResponse(String message, boolean status, String token) {
		super();
		this.message = message;
		this.status = status;
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	
}
