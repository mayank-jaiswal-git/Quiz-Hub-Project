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
@Entity(name = "Net_Question_options")
public class NetOptions {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "option_id")
	private int optionId;

	@Column(name = "option_text", nullable = false)
	private String option_Text;

	@ManyToOne
	@JoinColumn(name = "question_Id", nullable = false)
	@JsonBackReference
	private NetQuestions netQuestions;

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

	public NetQuestions getNetQuestions() {
		return netQuestions;
	}

	public void setNetQuestions(NetQuestions netQuestions) {
		this.netQuestions = netQuestions;
	}

}
