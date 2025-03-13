package in.QuizHub.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import in.QuizHub.Entities.JavaQuestions;

public interface JavaQuestionsRepo extends JpaRepository<JavaQuestions, Integer> {



}
