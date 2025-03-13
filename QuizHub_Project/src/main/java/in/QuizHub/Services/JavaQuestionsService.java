package in.QuizHub.Services;

import java.util.List;

import in.QuizHub.Entities.JavaQuestions;

public interface JavaQuestionsService {
    public boolean saveAllQuestions(List<JavaQuestions> questionsList);
    
    public List<JavaQuestions> getAllQuestions();
}
