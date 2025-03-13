package in.QuizHub.Services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.QuizHub.Entities.JavaOptions;
import in.QuizHub.Entities.JavaQuestions;
import in.QuizHub.Repositories.JavaQuestionsRepo;
import in.QuizHub.Services.JavaQuestionsService;

@Service
public class JavaQuestionsServiceImpl implements JavaQuestionsService {

	@Autowired
	private JavaQuestionsRepo javaQuestionsRepo;

	@Override
	public boolean saveAllQuestions(List<JavaQuestions> questionsList) {

		for (JavaQuestions question : questionsList) {
			for (JavaOptions option : question.getOptions()) {
				option.setJavaQuizQuestion(question); // Ensuring bidirectional mapping
			}
		}

		List<JavaQuestions> list = javaQuestionsRepo.saveAll(questionsList);

		if (list.isEmpty()) {
			return false;
		} else {
			return true;
		}

	}

	@Override
	public List<JavaQuestions> getAllQuestions() {
		 List<JavaQuestions> allQuestionsList = javaQuestionsRepo.findAll();
	    if(allQuestionsList.isEmpty()) {
	    	return null;
	    }
	    else {
	    	 return allQuestionsList;
	    }
	}

}
