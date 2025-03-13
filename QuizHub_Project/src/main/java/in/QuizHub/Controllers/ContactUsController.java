package in.QuizHub.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.QuizHub.DTO.ContactRequestDTO;
import in.QuizHub.Services.ContactRequestService;

@CrossOrigin(origins = "http://127.0.0.1:5501")
@RestController
@RequestMapping("/contact")
public class ContactUsController {
    
	@Autowired
	private ContactRequestService contactRequestService;
	
	@PostMapping("/save")
	public boolean saveRequest(@RequestBody ContactRequestDTO contactRequestDTO){
		boolean status = contactRequestService.saveRequest(contactRequestDTO);
		if(status) {
			return true;
		}
		else {
			return false;
		}
	}
}
