package in.QuizHub.Controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.QuizHub.DTO.LoginDTO;
import in.QuizHub.DTO.UserDTO;
import in.QuizHub.Entities.UserData;
import in.QuizHub.Response.ForgotPasswordResponse;
import in.QuizHub.Response.LoginResponse;
import in.QuizHub.Services.UserService;
import in.QuizHub.Services.Impl.JwtService;

@CrossOrigin(origins = "http://127.0.0.1:5501")
@RestController
@RequestMapping("/auth")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private JwtService jwtService;

	@PostMapping("/register")
	public ResponseEntity<String> RegisterUser(@RequestBody UserDTO userDTO) {
		UserData userData = userService.registerUser(userDTO);

		if (userData != null) {
			return ResponseEntity.ok("Registration Successful");
		} else {
			return ResponseEntity.badRequest().body("Registration Failed");
		}
	}

	@PostMapping("/login")
	public ResponseEntity<LoginResponse> loginUser(@RequestBody LoginDTO loginDTO) {
		LoginResponse response = userService.loginUser(loginDTO);
			return ResponseEntity.ok(response);
	 }
	
	@PostMapping("/check")
	public ResponseEntity<LoginResponse> checkEmail(@RequestBody Map<String, String> request){
		LoginResponse response = userService.checkUser(request.get("email"));
		return ResponseEntity.ok(response);
	}
	
	@PostMapping("/forgot-password")
	public ResponseEntity<ForgotPasswordResponse> forgotPassword(@RequestBody Map<String, String> request){
		String userEmail = request.get("email");
		String status = request.get("status");
		ForgotPasswordResponse response = userService.forgotPassword(userEmail, status);
		return ResponseEntity.ok(response);
	}
	
	@PostMapping("/reset-password")
	public boolean resetPassword(@RequestBody Map<String, String> request){
		String userEmail = request.get("email");
		String newPassword = request.get("password");
		return userService.resetPassword(userEmail,newPassword);
	}
	
	@PostMapping("/check-token")
	public boolean checkToken(@RequestBody Map<String, String> request) {
		String token = request.get("token");
		if(token == null) {
			return false;
		}
		else {
			boolean status = jwtService.validateToken(token);
			return status;
		}
			
	}

}
