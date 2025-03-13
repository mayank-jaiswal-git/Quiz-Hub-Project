package in.QuizHub.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import in.QuizHub.Entities.ContactRequest;

public interface ContactRequestRepo extends JpaRepository<ContactRequest, Integer>{

}
