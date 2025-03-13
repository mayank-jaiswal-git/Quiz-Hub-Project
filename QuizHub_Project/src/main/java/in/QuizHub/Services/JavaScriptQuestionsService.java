package in.QuizHub.Services;

import java.util.List;

import in.QuizHub.Entities.JavaScriptQuestions;

public interface JavaScriptQuestionsService {
   
public boolean saveAllQuestions(List<JavaScriptQuestions> questionsList);
    
    public List<JavaScriptQuestions> getAllQuestions();
}
