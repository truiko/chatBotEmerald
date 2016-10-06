package groupFiles;

import java.util.Scanner;
import java.util.Arrays;

//import groupFiles.VictorMain;


public class MahinCalendar implements Chatbot{
	private boolean inCalendarLoop;
	private String calendarResponse;
	
	//static Scanner eventTime;
	
	static Scanner eventDay;
	private String dayString;
	static Scanner eventInfo;
	static Scanner leave;
	private String leaveString;
	
	String[] infoArray = new String[7];
	String[] dayArray = new String[7];
	boolean[] busyArray = new boolean[7];
	String[] daysOfTheWeek = {"monday", "tuesday", "wednesday", "thursday", "friday", "saturday", "sunday"};
	int dayCounter = 0;
	int infoCounter = 0;
	
	//String[] theMonths = {"jan", "feb", "mar", "apr", "may", "jun", "jul", "aug", "sep", "oct", "nov", "dec"};
	//int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	
	
	public boolean isTriggered(String userInput){
		if(VictorMain.findKeyword(userInput, "date", 0)>=0){
			return true;
		}
		if(VictorMain.findKeyword(userInput, "time", 0)>=0){
			return true;
		}
		if(VictorMain.findKeyword(userInput, "calendar", 0)>=0){
			return true;
		}
		return false;
		
	}
	
	public void talk(){
		
		formFields();
		inCalendarLoop = true;
		VictorMain.print("Would you like to add things to my calendar for this week?");
		while(inCalendarLoop){
			VictorMain.print("You can say 'quit' to exit this part.");
			leaveString = leave.nextLine();
			leaveString = leaveString.toLowerCase();
			//calendarResponse = VictorMain.promptInput();
			if(VictorMain.findKeyword(leaveString, "no", 0) >= 0||VictorMain.findKeyword(leaveString, "quit", 0) >= 0 ){
				inCalendarLoop = false;
				VictorMain.print("I don't think you value organization and punctuality.");
				VictorMain.promptForever();
			}else{
				VictorMain.print("I will take that as a yes. Which day? Monday, Tuesday, Wednesday, Thursday, or Friday?");
				dayString = eventDay.nextLine();
				dayString = dayString.toLowerCase();
				for(int i = 0; i < daysOfTheWeek.length; i++){
					if(VictorMain.findKeyword(dayString, daysOfTheWeek[i], 0) >= 0){
						addDay(daysOfTheWeek[i]);
						//VictorMain.print(Arrays.toString(dayArray));
					}
				}
				if(dayString != "monday"){
					VictorMain.print("Enter valid day");
					proceedToDays();
				}
				//proceedToDays();
			}
		}	
	}			
				//for(int i = 0; i < theMonths.length; i++){
					//if(VictorMain.findKeyword(dayString, daysOfTheWeek[i], 0) >=0 ){
						//VictorMain.print(theMonths[i]); was commented out before
						//addMonth(theMonths[i]);
						
						
						//VictorMain.print(Arrays.toString(monthArray));
						//VictorMain.print(monthArray[0]);Arrays.toString(monthArray)
				//	}
				//}
				
				//VictorMain.print("Which year?");
				//yearString = eventYear.nextLine();
				//int enteredYear = Integer.parseInt(yearString);
				//addYear(enteredYear);
			//}
		
	//}
	public void proceedToDays(){
		//VictorMain.print("I will take that as a yes. Which day? Monday, Tuesday, Wednesday, Thursday, or Friday?");
		dayString = eventDay.nextLine();
		dayString = dayString.toLowerCase();
		//calendarResponse = VictorMain.promptInput();
		//calendarResponse = calendarResponse.toLowerCase();
		for(int i = 0; i < daysOfTheWeek.length; i++){
			if(VictorMain.findKeyword(dayString, daysOfTheWeek[i], 0) >= 0){
				//VictorMain.print("Cool."); for testing
				addDay(daysOfTheWeek[i]);
			}
		}	
		VictorMain.print(Arrays.toString(dayArray));
	}
	public void invalidDay(){
		VictorMain.print("Please enter a valid day."); 
	}
	
	private void formFields(){
		eventDay = new Scanner(System.in);
		eventInfo = new Scanner(System.in);
		leave = new Scanner(System.in);
	}
	
	//public boolean isValid(String input){
	//	if(input )
	//}
	
	/*public void addMonth(String month){
		for(int i = 0; i < theMonths.length; i++){
			if(month.equals(theMonths[i])){
			//if first is empty then input, if filled look next.
			boolean isFilled = false;
				while(isFilled == false){
					monthArray[monthCounter] = theMonths[i];
					isFilled = true;
					monthCounter++;
					//else print try again
				}
			}
		}
	}*/
	public void addDay(String day){
		for(int i = 0; i < daysOfTheWeek.length; i++){
			if(day.equals(daysOfTheWeek[i])){
				boolean isFilled = false;
				while(isFilled == false){
					dayArray[dayCounter] = daysOfTheWeek[i];
					isFilled = true;
					dayCounter++;
				}
			}
		}
	}
	
	/*public void addYear(int year){
		if(year >= 2016){
			yearArray[yearCounter] = year;
			yearCounter++;
		}else{
			VictorMain.print("It's 2016.");
		}
	}*/
	
	/*public void addDay(int day){ 
		int maxDays = 0;
		if(monthArray[(monthCounter - 1)] == theMonths[1] && isLeapYear){
			maxDays = 29;
		}
		if(monthArray[(monthCounter - 1)] == theMonths[1] && !isLeapYear){
			maxDays = 28;
		}
		//0,2,4,6,7,9,11 are indexes of theMonths[] for months with 31 days
		if(monthArray[monthCounter - 1] == theMonths[0] || monthArray[monthCounter - 1] == theMonths[2] || monthArray[monthCounter - 1] == theMonths[4] || 
				monthArray[monthCounter - 1] == theMonths[6] || monthArray[monthCounter - 1] == theMonths[7] ||  monthArray[monthCounter - 1] == theMonths[9] || 
				monthArray[monthCounter - 1] == theMonths[11]){
			maxDays = 31; 
		}
		if(monthArray[monthCounter - 1] == theMonths[3] || monthArray[monthCounter - 1] == theMonths[5] || monthArray[monthCounter - 1] == theMonths[8] || 
				monthArray[monthCounter - 1] == theMonths[10]){
			maxDays = 30; 
		}
		if(day > 0 && day <= maxDays){
			dayArray[dayCounter] = day;
			dayCounter++;
		}else{
			VictorMain.print("You don't seem to know how many days are in"+monthArray[monthCounter - 1]);
		}
	}*/
}
