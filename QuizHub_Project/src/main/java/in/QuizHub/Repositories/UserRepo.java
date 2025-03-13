package in.QuizHub.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.QuizHub.Entities.UserData;
import java.util.Optional;



@Repository
public interface UserRepo extends JpaRepository<UserData, Integer>{
    public Optional<UserData> findByEmail(String email);
  
    public Optional<UserData> findByUserName(String userName);
}

