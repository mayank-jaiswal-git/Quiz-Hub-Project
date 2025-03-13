package in.QuizHub.Entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity(name = "Java_Quiz_Questions")
public class JavaQuestions {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int questionId;

	@Column(nullable = false)
	private String question;

	@Column(nullable = false)
	private String correctAnswer;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "javaQuizQuestion" , fetch = FetchType.LAZY)
	@JsonManagedReference 
	private List<JavaOptions> options;

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	public List<JavaOptions> getOptions() {
		return options;
	}

	public void setOptions(List<JavaOptions> options) {
		this.options = options;
	}

}
