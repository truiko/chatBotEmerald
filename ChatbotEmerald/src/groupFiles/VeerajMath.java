package groupFiles;

import java.util.Scanner;

public class VeerajMath implements Chatbot{
	private boolean inMathLoop;
	private String mathQuestion;
	private String quit2;
	static Scanner question;
	static Scanner in;
	static Scanner op1;
	static Scanner op2;
	static Scanner res;
	static Scanner mid;
	static Scanner quit;
	private double num1;
	private double num2;
	private double result;
	private String operation;
	
	public void talk() {
		makeFields();
		inMathLoop = true;
		VictorMain.print("This is the math section. Do you want to leave?");
		quit2 = quit.nextLine();
		quit2 = quit2.toLowerCase();
		if(VictorMain.findKeyword(quit2, "yes", 0) >= 0 || 
				VictorMain.findKeyword(quit2, "yea", 0) >= 0){
			inMathLoop = false;
			VictorMain.print("I see you don't like math. Fine then.");
			VictorMain.promptForever();
		}
		//this is called a static call
		while(inMathLoop){
			VictorMain.print("Enter the first number");
			num1 = op1.nextDouble();
			
			VictorMain.print("Enter the second number");
			num2 = op2.nextDouble();
			
			VictorMain.print("Enter the operation(+, -, *, /)");
			operation = mid.nextLine();
			
			switch (operation){
				case "+":
					System.out.println(num1 + num2);
					break;
				case "-":
					System.out.println(num1 - num2);
					break;
				case "*":
					System.out.println(num1 * num2);
					break;
				case "/":
					System.out.println(num1 / num2);
					break;
				default:
					System.out.println("Please enter a valid operator");
			}
		}
	}
	
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
		quit = new Scanner(System.in);
		op1 = new Scanner(System.in);
		op2 = new Scanner(System.in);
		res = new Scanner(System.in);
		mid = new Scanner(System.in);
		String mathQuestion = "";
		String quit2 = "";
		double num1;
		double num2;
		double result;
	}
}