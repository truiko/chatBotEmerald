package groupFiles;

import java.util.Scanner;

//import groupFiles.VictorMain;


public class MahinCalendar implements Chatbot{
	private boolean inCalendarLoop;
	
	static Scanner eventMonth;
	static Scanner eventDay;
	static Scanner eventYear;
	//static Scanner eventTime;
	static Scanner eventInfo;
	static Scanner leave;
	private String leaveString;
	private String monthString;
	private String yearString;
	//private String dayString; will use
	
	String[] monthArray = new String[10];
	int[] dayArray = new int[10];
	int[] yearArray = new int[10];
	String[] theMonths = {"jan", "feb", "mar", "apr", "may", "jun", "jul", "aug", "sep", "oct", "nov", "dec"};
	int monthCounter = 0;
	int yearCounter = 0;
	int dayCounter = 0;
	int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	
	
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
		while(inCalendarLoop){
			VictorMain.print("Would you like to add things to my calendar? I can remember up to 10 events, starting from 2016. You can say 'quit' to exit this part.");
			leaveString = leave.nextLine();
			leaveString = leaveString.toLowerCase();
			if(VictorMain.findKeyword(leaveString, "no", 0) >= 0||VictorMain.findKeyword(leaveString, "quit", 0) >= 0 ){
				inCalendarLoop = false;
				VictorMain.print("I don't think you value organization and punctuality.");
				VictorMain.promptForever();
			}
			
			//calendarResponse = VictorMain.promptInput();//static call on promptInput method from
			//MahinMain class
			
			/*if(calendarResponse.indexOf("no") >= 0){
				inCalendarLoop = false;
				VictorMain.print("I don't think you value organization and punctuality.");
				VictorMain.promptForever();
			}
			*/
			
			else{
				VictorMain.print("I will take that as a yes. Which month? Jan, Feb, Mar, Apr, May, Jun, Jul, Aug, Sep, Oct, Nov, Dec?");
				monthString = eventMonth.nextLine();
				monthString = monthString.toLowerCase();
				for(int i = 0; i < theMonths.length; i++){
					if(VictorMain.findKeyword(monthString, theMonths[i], 0) >=0 ){
						//VictorMain.print(theMonths[i]);
						addMonth(theMonths[i]);
						VictorMain.print(monthArray[0]);
					}
				}
				
				VictorMain.print("Which year?");
				yearString = eventYear.nextLine();
				int enteredYear = Integer.parseInt(yearString);
				addYear(enteredYear);
				
				VictorMain.print("Which day?");
				
				/*if(VictorMain.findKeyword(monthString, "jan", 0) >=0 ){
					addMonth("jan");
					//add jan to month array
					//addMonth("jan");
				}*/
				//VictorMain.print(addToCalendar());
			}
		}
	}
	
	//public static String addToCalendar(){
		//return "I will take that as a yes. Which month?";
	//}
	
	private void formFields(){
		eventMonth = new Scanner(System.in);
		eventDay = new Scanner(System.in);
		eventYear = new Scanner(System.in);
		eventInfo = new Scanner(System.in);
		leave = new Scanner(System.in);
	}
	
	public void addMonth(String month){
		for(int i = 0; i < theMonths.length; i++){
			if(month.equals(theMonths[i])){
			//if first is empty then input, if filled look next.
			boolean isFilled = false;
				while(isFilled){
					monthArray[monthCounter] = theMonths[i];
					isFilled = true;
					monthCounter++;
					//else print try again
				}
			}
		}
	}
	
	public void addYear(int year){
		if(year >= 2016){
			yearArray[yearCounter] = year;
			yearCounter++;
		}else{
			VictorMain.print("It's 2016.");
		}
	}
	
	public void addDay(int day){ 
		int maxDays = 0;
		if(monthArray[(monthCounter - 1)] == theMonths[1] /*&& isLeapYear*/){
			maxDays = 29;
		}
		if(monthArray[(monthCounter - 1)] == theMonths[1] /*&& !isLeapYear*/){
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
	}
	
	public boolean isLeapYear(int year){
		if(year % 4 == 0 && year % 100 != 0 && year % 400 == 0 && year >= 2016){
			return true;
		}else{
			return false;
		}
	}
	
	/*public void addMonth(month){
		if(month.equals("jan")){
			for(i = 0; i < monthArray.length; i++){
				if(monthArray[i].equals("")){
					monthArray[i] = "jan";
				}
			}
		}
	}
	*/
	
}
