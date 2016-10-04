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
			if(getIntegerInput(op1.nextLine())){
				double a = Double.parseDouble(op1.nextLine());
				System.out.println(a);
				num1 = op1.nextDouble();
			}
			else{
				VictorMain.print("Please try again");
				continue;
			}
			
			VictorMain.print("Enter the second number");
			if(getIntegerInput(op2.nextLine())){
				double b = Double.parseDouble(op2.nextLine());
				System.out.println(b);
				num2 = op2.nextDouble();
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
	
	private static boolean getIntegerInput(String integerString) {
		boolean isInteger = false;
		int value = 0;
		while(!isInteger){
			try{
				value = Integer.parseInt(integerString);
				//will not continue if an error above is thrown
				isInteger = true;//exits loop if entry is valid
			 }
		 
			 catch(NumberFormatException e){
				isInteger = false;
			 }
			}
			return isInteger;
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