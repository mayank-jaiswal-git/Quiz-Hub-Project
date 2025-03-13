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

import in.QuizHub.Entities.PythonQuestions;
import in.QuizHub.Services.PythonQuestionsService;

@CrossOrigin(origins = "http://127.0.0.1:5501")
@RestController
@RequestMapping("/python")
public class PythonQuizQuestionsController {
    
	@Autowired
	private PythonQuestionsService pythonQuestionsService;
	
	@PostMapping("/saveAll")
    public ResponseEntity<String> saveAllQuestions(@RequestBody List<PythonQuestions> questionsList){
		
        boolean status = pythonQuestionsService.saveAllQuestions(questionsList);
        if(status) {
        	return ResponseEntity.ok("Questions Inserted Successfully");
        }
        else {
			return ResponseEntity.badRequest().body("Insertion Failed");
		}

    }
	
	
	 @GetMapping("/pythonQuestions")
	    public List<PythonQuestions> getAllQuestions(){
	        List<PythonQuestions> allQuestions = pythonQuestionsService.getAllQuestions();
	        return allQuestions;
	    }
}
