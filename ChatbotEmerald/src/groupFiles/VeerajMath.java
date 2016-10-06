package groupFiles;

import java.util.Scanner;

public class VeerajMath implements Chatbot{
	private boolean inMathLoop;
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
	private String operation;
	private String[] responses = {"Wow, you can't do basic math!", 
			"You need to go back to first grade", 
			"What are you doing with your life", 
			"You're not as smart as you think",
			"Start studying more often"};
	
	public void talk() {
		makeFields();
		inMathLoop = true;
		VictorMain.print("ONLY USE NUMERICS");
		while(inMathLoop){
			VictorMain.print("Do you want to leave?");
			quit2 = quit.nextLine();
			quit2 = quit2.toLowerCase();
			
			if(VictorMain.findKeyword(quit2, "yes", 0) >= 0 || 
				VictorMain.findKeyword(quit2, "yea", 0) >= 0){
				inMathLoop = false;
				VictorMain.print("I see you don't like math. Fine then.");
				VictorMain.promptForever();
			}
			
			VictorMain.print("Enter the first number");
			num1 = getDoubleInput();
			System.out.println("You entered: " + num1);

			VictorMain.print("Enter the second number");
			num2 = getDoubleInput();
			System.out.println("You entered: " + num2);

			
			VictorMain.print("Enter the operation(+, -, *, /)");
			operation = mid.nextLine();
			System.out.println("You entered: " + operation);
			
			switch (operation){
				case "+":
					add(num1, num2);
					break;
				case "-":
					subtract(num1, num2);
					break;
				case "*":
					multiply(num1, num2);
					break;
				case "/":
					divide(num1, num2);
					break;
				default:
					VictorMain.print("Please enter a valid operator!");
			}
		}
	}
	
	private void add(double one, double two){
		printResult(one + two);
		System.out.println(responses[(int) ((Math.random() * 4))]);
	}
	
	private void subtract(double one, double two){
		printResult(one - two);
		System.out.println(responses[(int) ((Math.random() * 4))]);
	}
	
	private void multiply(double one, double two){
		printResult(one * two);
		System.out.println(responses[(int) ((Math.random() * 4))]);
	}

	private void divide(double one, double two){
		printResult(one / two);
		System.out.println(responses[(int) ((Math.random() * 4))]);
	}
	

	private static double getDoubleInput() {
		boolean isDouble = false;
		double value = 0;
		String doubleString = VictorMain.promptInput();
		while(!isDouble){
			try{
				value = Double.parseDouble(doubleString);
				//will not continue if an error above is thrown
				isDouble = true;//exits loop if entry is valid
			}
		 
			catch(NumberFormatException e){
				VictorMain.print("Please enter an integer!");
				doubleString = VictorMain.promptInput();
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
	
	private void printResult(double input){
		System.out.println(input);
	}
	
	private void makeFields(){
		question = new Scanner(System.in);
		quit = new Scanner(System.in);
		op1 = new Scanner(System.in);
		op2 = new Scanner(System.in);
		res = new Scanner(System.in);
		mid = new Scanner(System.in);
	}
}