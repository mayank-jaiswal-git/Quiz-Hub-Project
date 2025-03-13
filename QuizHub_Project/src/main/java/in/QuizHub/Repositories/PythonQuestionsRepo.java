package in.QuizHub.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import in.QuizHub.Entities.PythonQuestions;

public interface PythonQuestionsRepo  extends JpaRepository<PythonQuestions, Integer>{

}
