package in.QuizHub.Services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.QuizHub.Entities.PythonOptions;
import in.QuizHub.Entities.PythonQuestions;
import in.QuizHub.Repositories.PythonQuestionsRepo;
import in.QuizHub.Services.PythonQuestionsService;

@Service
public class PythonQuestionsServiceImpl implements PythonQuestionsService {
	
	@Autowired
	private PythonQuestionsRepo pythonQuestionsRepo;

	@Override
	public boolean saveAllQuestions(List<PythonQuestions> questionsList) {
		for (PythonQuestions question : questionsList) {
			for (PythonOptions option : question.getOptions()) {
				option.setPythonQuestions(question); // Ensuring bidirectional mapping
			}
		}

		List<PythonQuestions> list = pythonQuestionsRepo.saveAll(questionsList);

		if (list.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public List<PythonQuestions> getAllQuestions() {
		List<PythonQuestions> allQuestionsList = pythonQuestionsRepo.findAll();
	    if(allQuestionsList.isEmpty()) {
	    	return null;
	    }
	    else {
	    	 return allQuestionsList;
	    }
	}

}
