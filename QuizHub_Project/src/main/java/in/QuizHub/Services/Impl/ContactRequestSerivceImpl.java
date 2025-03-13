package in.QuizHub.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.QuizHub.DTO.ContactRequestDTO;
import in.QuizHub.Entities.ContactRequest;
import in.QuizHub.Repositories.ContactRequestRepo;
import in.QuizHub.Services.ContactRequestService;

@Service
public class ContactRequestSerivceImpl implements ContactRequestService{
   
	@Autowired
	private ContactRequestRepo contactRequestRepo;
	
	@Override
	public boolean saveRequest(ContactRequestDTO contactRequestDTO) {
		ContactRequest contactRequest = new ContactRequest();
		contactRequest.setFullName(contactRequestDTO.getFullName());
		contactRequest.setEmail(contactRequestDTO.getEmail());
		contactRequest.setDescription(contactRequestDTO.getDescription());
		
	  ContactRequest cq = contactRequestRepo.save(contactRequest);
	  if(cq != null) {
		  return true;
	  }
	  else {
		  return false;
	  }
	}

}
