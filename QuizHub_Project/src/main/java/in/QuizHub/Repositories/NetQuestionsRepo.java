package in.QuizHub.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import in.QuizHub.Entities.NetQuestions;

public interface NetQuestionsRepo  extends JpaRepository<NetQuestions, Integer>{

}
