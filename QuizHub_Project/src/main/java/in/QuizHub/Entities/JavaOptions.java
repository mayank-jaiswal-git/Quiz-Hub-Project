package in.QuizHub.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity(name = "Java_Question_options")
public class JavaOptions {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "option_id")
	private int optionId;

	@Column(name = "option_text", nullable = false)
	private String option_Text;

	@ManyToOne
	@JoinColumn(name = "question_Id", nullable = false)
	@JsonBackReference
	private JavaQuestions javaQuizQuestion;

	public int getOptionId() {
		return optionId;
	}

	public void setOptionId(int optionId) {
		this.optionId = optionId;
	}

	public String getOption_Text() {
		return option_Text;
	}

	public void setOption_Text(String option_Text) {
		this.option_Text = option_Text;
	}

	public JavaQuestions getJavaQuizQuestion() {
		return javaQuizQuestion;
	}

	public void setJavaQuizQuestion(JavaQuestions javaQuizQuestion) {
		this.javaQuizQuestion = javaQuizQuestion;
	}

}
