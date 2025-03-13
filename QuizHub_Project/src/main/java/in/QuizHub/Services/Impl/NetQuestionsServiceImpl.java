package in.QuizHub.Services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.QuizHub.Entities.NetOptions;
import in.QuizHub.Entities.NetQuestions;
import in.QuizHub.Repositories.NetQuestionsRepo;
import in.QuizHub.Services.NetQuestionsService;
@Service
public class NetQuestionsServiceImpl implements NetQuestionsService{
    
	@Autowired
	private NetQuestionsRepo netQuestionsRepo;
	
	@Override
	public boolean saveAllQuestions(List<NetQuestions> questionsList) {
		for (NetQuestions question : questionsList) {
			for (NetOptions option : question.getOptions()) {
				option.setNetQuestions(question); // Ensuring bidirectional mapping
			}
		}

		List<NetQuestions> list = netQuestionsRepo.saveAll(questionsList);

		if (list.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public List<NetQuestions> getAllQuestions() {
		 List<NetQuestions> allQuestionsList = netQuestionsRepo.findAll();
		    if(allQuestionsList.isEmpty()) {
		    	return null;
		    }
		    else {
		    	 return allQuestionsList;
		    }
	}

}
