
public class MultipleAnswer extends Question implements java.io.Serializable{
	private String[] answers;
	private String[] answers2;
	public MultipleAnswer(String question, String answer, String[] answers, String[] answers2) {
		super(question, answer);
		this.answers = answers;
		this.answers2 = answers2;
		
		// TODO Auto-generated constructor stub
	}
	
	

}
