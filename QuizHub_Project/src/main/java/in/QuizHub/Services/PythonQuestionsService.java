package in.QuizHub.Services;

import java.util.List;

import in.QuizHub.Entities.PythonQuestions;

public interface PythonQuestionsService {
	public boolean saveAllQuestions(List<PythonQuestions> questionsList);

	public List<PythonQuestions> getAllQuestions();
}
