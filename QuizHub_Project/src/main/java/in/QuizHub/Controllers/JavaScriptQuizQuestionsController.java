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

import in.QuizHub.Entities.JavaScriptQuestions;
import in.QuizHub.Services.JavaScriptQuestionsService;

@CrossOrigin(origins = "http://127.0.0.1:5501")
@RestController
@RequestMapping("/javascript")
public class JavaScriptQuizQuestionsController {
   
	@Autowired
	private JavaScriptQuestionsService javaScriptQuestionsService;
	
	@PostMapping("/saveAll")
    public ResponseEntity<String> saveAllQuestions(@RequestBody List<JavaScriptQuestions> questionsList){
		
        boolean status = javaScriptQuestionsService.saveAllQuestions(questionsList);
        if(status) {
        	return ResponseEntity.ok("Questions Inserted Successfully");
        }
        else {
			return ResponseEntity.badRequest().body("Insertion Failed");
		}

    }
	
	
	 @GetMapping("/javascriptQuestions")
	    public List<JavaScriptQuestions> getAllQuestions(){
	        List<JavaScriptQuestions> allQuestions = javaScriptQuestionsService.getAllQuestions();
	        return allQuestions;
	    }
}
