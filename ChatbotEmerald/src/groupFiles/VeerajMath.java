package groupFiles;

import java.util.Scanner;

public class VeerajMath implements Chatbot{
	private boolean inMathLoop;
	private String mathQuestion;
	static Scanner question;
	static Scanner in;
	private double num1;
	private double num2;
	private double result;
	
	public void talk() {
		makeFields();
		inMathLoop = true;
		//String operant1 = "";
		//String operant2 = "";
		//String answer = "";
		//int temp;
		VictorMain.print("This is the math section. Type quit to quit.");
		//this is called a static call
		while(inMathLoop){
			VictorMain.print("Enter the first number");
			
			mathQuestion = question.nextLine();
			VictorMain.print(mathQuestion);
			String[] temp = mathQuestion.split(" ");
			for(int i = 0; i < temp.length; i++){
				if(temp[i] == "+"){
					System.out.println("hi");
					
				}
			//for(int i = 0; i < mathQuestion.length(); i++){
				//if(mathQuestion.indexOf("+") > 0){
					//temp = mathQuestion.indexOf("+");
					//operant1 = mathQuestion.substring(0, 0);
					//operant2 = mathQuestion.substring(temp + 1, temp + 1);
					//answer = operant1 + operant2;
					//System.out.println(temp);
				//}
				//i++;
				}
				if(mathQuestion.indexOf("quit") >= 0){
					inMathLoop = false;
					VictorMain.print("I see you don't like math. Fine then.");
					VictorMain.promptForever();
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
		String mathQuestion = "";
		double num1;
		double num2;
		double result;
	}
}