package groupFiles;

import java.util.Scanner;

public class VeerajMath implements Chatbot{
	private boolean inMathLoop;
	private String mathQuestion;
	static Scanner question;
	
	public void talk() {
		makeFields();
		inMathLoop = true;
		String operant1 = "";
		String operant2 = "";
		String answer = "";
		int temp;
		VictorMain.print("This is the math section. Type quit to quit.");
		//this is called a static call
		while(inMathLoop){
			VictorMain.print("Enter a math problem you wish to solve");
			mathQuestion = question.nextLine();
			VictorMain.print(mathQuestion);
			//for(int i = 0; i < mathQuestion.length(); i++){
				if(mathQuestion.indexOf("+") > 0){
					temp = mathQuestion.indexOf("+");
					operant1 = mathQuestion.substring(0, 0);
					operant2 = mathQuestion.substring(temp + 1, temp + 1);
					answer = operant1 + operant2;
					System.out.println(temp);
				//}
				//i++;
			}
			/*getIntegerInput();
			mathResponse = VictorMain.promptInput();
			if(mathResponse.indexOf("quit") >= 0){
				inMathLoop = false;
				VictorMain.promptForever();*/
			}
		}
	//}
	
	private static int getIntegerInput() {
		VictorMain.print("Please enter an integer.");
		String integerString = VictorMain.promptInput();
		boolean isInteger = false;
		int value = 0;
		while(!isInteger){
			try{
				value = Integer.parseInt(integerString);
				//will not continue if an error above is thrown
				isInteger = true;//exits loop if entry is valid
			 }
		 
			 catch(NumberFormatException e){
				VictorMain.print("You must enter an integer. You better try again.");
				integerString = VictorMain.promptInput();
			 }
		 }
		 	return value;
		 }

	public boolean isTriggered(String userInput) {
		if(VictorMain.findKeyword(userInput, "math", 0) >= 0){
			return true;
		}
		return false;
	}
	
	public void makeFields(){
		question = new Scanner(System.in);
		mathQuestion = "";
	}
}