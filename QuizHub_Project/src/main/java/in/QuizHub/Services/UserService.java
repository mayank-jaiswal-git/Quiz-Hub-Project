package in.QuizHub.Services;

import in.QuizHub.DTO.LoginDTO;
import in.QuizHub.DTO.UserDTO;
import in.QuizHub.Entities.UserData;
import in.QuizHub.Response.ForgotPasswordResponse;
import in.QuizHub.Response.LoginResponse;

public interface UserService {
    public UserData registerUser(UserDTO userDTO);
    public LoginResponse loginUser(LoginDTO loginDTO);
    public ForgotPasswordResponse forgotPassword(String email, String status);
    public Boolean resetPassword(String email, String newPassword);
    public LoginResponse checkUser(String email);
    
}