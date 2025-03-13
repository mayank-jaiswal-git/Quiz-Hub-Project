package in.QuizHub.Services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.QuizHub.Entities.JavaScriptOptions;
import in.QuizHub.Entities.JavaScriptQuestions;
import in.QuizHub.Repositories.JavaScriptQuestionsRepo;
import in.QuizHub.Services.JavaScriptQuestionsService;

@Service
public class JavaScriptQuestionsServiceImpl implements JavaScriptQuestionsService {
	
	@Autowired
	private JavaScriptQuestionsRepo javaScriptQuestionsRepo;

	@Override
	public boolean saveAllQuestions(List<JavaScriptQuestions> questionsList) {
		for (JavaScriptQuestions question : questionsList) {
			for (JavaScriptOptions option : question.getOptions()) {
				option.setJavaScriptQuestions(question); // Ensuring bidirectional mapping
			}
		}

		List<JavaScriptQuestions> list = javaScriptQuestionsRepo.saveAll(questionsList);

		if (list.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public List<JavaScriptQuestions> getAllQuestions() {
		 List<JavaScriptQuestions> allQuestionsList = javaScriptQuestionsRepo.findAll();
		    if(allQuestionsList.isEmpty()) {
		    	return null;
		    }
		    else {
		    	 return allQuestionsList;
		    }
	}

}
