package in.QuizHub.Services;

import java.util.List;

import in.QuizHub.Entities.NetQuestions;

public interface NetQuestionsService {
	 public boolean saveAllQuestions(List<NetQuestions> questionsList);
	    
	    public List<NetQuestions> getAllQuestions();
}
