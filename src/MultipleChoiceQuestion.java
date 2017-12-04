public class MultipleChoiceQuestion extends Question implements java.io.Serializable{
public String[] arr;
public MultipleChoiceQuestion(String question, String answer,String[] arr){
	super(question, answer);
	this.arr = arr;
}
public String loopThru(){
String thing = "";
for(int i = 0; i<arr.length;i++)
	thing+= (i+1)+ " . " +  arr[i] + '\n' ; 

return thing;
}
public String askQuestion(){
		return super.askQuestion() + '\n' + loopThru() ;
	
}
public boolean check(int choice){
		
	if(arr[choice-1].equals(getAnswer()))
	return true;
	return false;	
	
}
public void setPossibleAnswers(String[] arr){
this.arr = arr;
}
public String[] getPossibleAnswers(){
return arr;
}
public String toString() {
return super.getAnswer() + super.askQuestion() + '\n';
}


public MultipleChoiceQuestion clone(){
String[] temp = arr;
String temp1 = getAnswer();
String temp2 = askQuestion();
return new MultipleChoiceQuestion(temp1,temp2,temp);
}

}
