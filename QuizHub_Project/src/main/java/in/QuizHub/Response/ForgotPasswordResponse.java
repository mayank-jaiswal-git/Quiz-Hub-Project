package in.QuizHub.Response;

public class ForgotPasswordResponse {
	private String message;
	private boolean status;
	private int otp;

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

	public ForgotPasswordResponse(String message, boolean status, int otp) {
		super();
		this.message = message;
		this.status = status;
		this.otp = otp;
	}

	public int getOtp() {
		return otp;
	}

	public void setOtp(int otp) {
		this.otp = otp;
	}
}
