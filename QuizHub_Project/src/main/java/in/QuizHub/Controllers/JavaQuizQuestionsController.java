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

import in.QuizHub.Entities.JavaQuestions;
import in.QuizHub.Services.JavaQuestionsService;

@CrossOrigin(origins = "http://127.0.0.1:5501")
@RestController
@RequestMapping("/java")
public class JavaQuizQuestionsController {
     
	@Autowired
	private JavaQuestionsService javaQuestionsService;
	
	@PostMapping("/saveAll")
    public ResponseEntity<String> saveAllQuestions(@RequestBody List<JavaQuestions> questionsList){
		System.out.println(questionsList);
		
        boolean status = javaQuestionsService.saveAllQuestions(questionsList);
        if(status) {
        	return ResponseEntity.ok("Questions Inserted Successfully");
        }
        else {
			return ResponseEntity.badRequest().body("Insertion Failed");
		}

    }
	
	
	 @GetMapping("/JavaQuestions")
	    public List<JavaQuestions> getAllQuestions(){
	        List<JavaQuestions> allQuestions = javaQuestionsService.getAllQuestions();
	        return allQuestions;
	    }

}
