package in.QuizHub.Services.Impl;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import in.QuizHub.DTO.LoginDTO;
import in.QuizHub.DTO.UserDTO;
import in.QuizHub.Entities.UserData;
import in.QuizHub.Repositories.UserRepo;
import in.QuizHub.Response.ForgotPasswordResponse;
import in.QuizHub.Response.LoginResponse;
import in.QuizHub.Services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private EmailService emailService;
	
	@Autowired
	private JwtService jwtService;

	@Override
	public UserData registerUser(UserDTO user) {
		if (userRepo.findByEmail(user.getEmail()).isPresent()) {
			throw new RuntimeException("Email already registered");
		}

		UserData userData = new UserData();
		userData.setFullName(user.getFullName());
		userData.setUserName(user.getUserName());
		userData.setEmail(user.getEmail());
		userData.setGender(user.getGender());
		userData.setContactNo(user.getContactNo());
		userData.setPassword(passwordEncoder.encode(user.getPassword()));

		return userRepo.save(userData);
	}

	@Override
	public LoginResponse loginUser(LoginDTO loginDTO) {

		Optional<UserData> userData = userRepo.findByEmail(loginDTO.getEmail());
		if (userData.isPresent()) {
			UserData user = userData.get();
			String userPassword = loginDTO.getPassword();
			String encodedPassword = user.getPassword();

			boolean isPasswordRight = passwordEncoder.matches(userPassword, encodedPassword);

			if (isPasswordRight) {

				Optional<UserData> validUser = userRepo.findByUserName(user.getUserName());

				if (validUser.isPresent()) {
					 String token = jwtService.generateToken(loginDTO.getEmail());
					 
					return new LoginResponse("Login Successfull", true,token);
				} else {
					return new LoginResponse("***Login failed***", false, null);
				}
			} else {
				return new LoginResponse("***Invalid Password Entered***", false,null);
			}
		} else {
			return new LoginResponse("***Invaild Email Entered***", false,null);
		}

	}

	@Override
	public ForgotPasswordResponse forgotPassword(String email, String status) {
		if (status.equalsIgnoreCase("verified")) {
			int validOTP = emailService.getOTP();
			emailService.sendEmail(email, emailService.emailSubject(), emailService.emailbody(validOTP));
			return new ForgotPasswordResponse("Valid User", true, validOTP);
		} else {
			return new ForgotPasswordResponse("***Email Not Exists***", false, 0);
		}

	}

	@Override
	public Boolean resetPassword(String email, String newPassword) {
		Optional<UserData> validUser = userRepo.findByEmail(email);
		if (validUser.isPresent()) {
			UserData userData = validUser.get();
			String hashedPassword = passwordEncoder.encode(newPassword);
			userData.setPassword(hashedPassword);
			userRepo.save(userData);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public LoginResponse checkUser(String email) {
		Optional<UserData> validUser = userRepo.findByEmail(email);
		if (validUser.isPresent()) {
			return new LoginResponse("Verified User", true,null);
		} else {
			return new LoginResponse("***Email Not Exists***", false,null);
		}
	}

}
