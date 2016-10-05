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
	
	
	public void talk() {
		makeFields();
		inMathLoop = true;
		while(inMathLoop){
			VictorMain.print("ONLY USE INTEGERS. Do you want to leave?");
			quit2 = quit.nextLine();
			quit2 = quit2.toLowerCase();
			
			if(VictorMain.findKeyword(quit2, "yes", 0) >= 0 || 
				VictorMain.findKeyword(quit2, "yea", 0) >= 0){
				inMathLoop = false;
				VictorMain.print("I see you don't like math. Fine then.");
				VictorMain.promptForever();
			}
			
			VictorMain.print("Enter the first number");
			String temp = op1.nextLine();
			if(getIntegerInput(temp)){
				double a = Double.parseDouble(temp);
				num1 = a;
				printResult(num1);
			}
			else if(!getIntegerInput(temp)){
				VictorMain.print("Please enter an integer!");
				continue;
			}
			
			VictorMain.print("Enter the second number");
			String temp2 = op2.nextLine();
			if(getIntegerInput(temp2)){
				double b = Double.parseDouble(temp2);
				num2 = b;
				printResult(num2);
			}
			else if(!getIntegerInput(temp)){
				VictorMain.print("Please enter an integer!");
				continue;
			}
			
			VictorMain.print("Enter the operation(+, -, *, /)");
			operation = mid.nextLine();
			
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
		VictorMain.print("It's sad that you can't do simple addition");
	}
	
	private void subtract(double one, double two){
		printResult(one - two);
		VictorMain.print("You should go back to elementary school");
	}
	
	private void multiply(double one, double two){
		printResult(one * two);
		VictorMain.print("You shouldn't rely on technology to do all the work for you");
	}
	
	private void divide(double one, double two){
		printResult(one / two);
		VictorMain.print("I'm smarter than you!"); 
	}
	
	private static double getDoubleInput() {
		boolean isDouble = false;
		double value = 0;
		String integerString = VictorMain.promptInput();
		while(!isDouble){
			try{
				value = Double.parseDouble(integerString);
				//will not continue if an error above is thrown
				isDouble = true;//exits loop if entry is valid
			}
		 
			catch(NumberFormatException e){
				System.out.println("invalid entry");
				integerString = VictorMain.promptInput();
				isDouble = false;
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