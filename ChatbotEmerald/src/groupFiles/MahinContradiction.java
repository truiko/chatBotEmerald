package groupFiles;

import java.util.Scanner;

//import groupFiles.VictorMain;


public class MahinContradiction implements Chatbot{
	private boolean inCalendarLoop;
	
	static Scanner eventMonth;
	static Scanner eventDay;
	static Scanner eventYear;
	//static Scanner eventTime;
	static Scanner eventInfo;
	static Scanner leave;
	private String leaveString;
	private String monthString;
	
	String[] monthArray = new String[10];
	double[] dayArray = new double[10];
	int[] yearArray = new int[10];
	String[] theMonths = {"jan", "feb", "mar", "apr", "may", "jun", "jul", "aug", "sep", "oct", "nov", "dec"};
	int monthCounter = 0;
	
	
	
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
			VictorMain.print("Would you like to add things to my calendar? I can remember up to 10 events.");
			leaveString = leave.nextLine();
			leaveString = leaveString.toLowerCase();
			if(VictorMain.findKeyword(leaveString, "no", 0) >= 0){
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
				}
			}
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
