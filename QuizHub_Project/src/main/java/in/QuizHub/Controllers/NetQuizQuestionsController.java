package in.QuizHub.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.QuizHub.Entities.NetQuestions;
import in.QuizHub.Services.NetQuestionsService;

@CrossOrigin(origins = "http://127.0.0.1:5501")
@RestController
@RequestMapping("/net")
public class NetQuizQuestionsController {
	
	@Autowired
    private NetQuestionsService netQuestionsService;
	
	@PostMapping("/saveAll")
    public ResponseEntity<String> saveAllQuestions(@RequestBody List<NetQuestions> questionsList){
		
        boolean status = netQuestionsService.saveAllQuestions(questionsList);
        if(status) {
        	return ResponseEntity.ok("Questions Inserted Successfully");
        }
        else {
			return ResponseEntity.badRequest().body("Insertion Failed");
		}

    }
	
	
	 @GetMapping("/netQuestions")
	    public List<NetQuestions> getAllQuestions(){
	        List<NetQuestions> allQuestions = netQuestionsService.getAllQuestions();
	        return allQuestions;
	    }
}
