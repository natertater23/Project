
public class Quiz implements java.io.Serializable{
private Question[] arr;
private int j = 0;
public Quiz(int num) {
	arr = new Question[num];
}
public void add(Question q) {
	arr[j] = q.clone();
	j++;
}
public int length() {
	return arr.length;
}
public Question get(int i) {
	return arr[i];
}
public String toString() {
	String result= "";
	for(int k = 0;k<arr.length;k++)
		result+=arr[k].toString();
	return result;
}

}
