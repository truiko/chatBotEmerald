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
	private String infoString;
	
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
		//showEntry();
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
				if(!validDay(dayString)){
					VictorMain.print("Enter valid day");
				}else{
					proceedToDays();
					VictorMain.print("Add some information about this day.");
					proceedToInfo();
				}
				}
		}
	}
	public void proceedToDays(){
		for(int i = 0; i < daysOfTheWeek.length; i++){
			if(dayString.equals(daysOfTheWeek[i])){
				busyArray[i] = true;
	
				dayString = eventDay.nextLine();
				dayString = dayString.toLowerCase();
			}else{
				if(VictorMain.findKeyword(dayString, daysOfTheWeek[i], 0) >= 0){
					//VictorMain.print("Cool."); for testing
					addDay(daysOfTheWeek[i]);
				}
			}	
		}
		VictorMain.print(Arrays.toString(dayArray));
	}
	
	/*public void determineBusiness(String day){
		for(int i = 0; i < daysOfTheWeek.length; i++){
			if(day.equals(daysOfTheWeek[i])){
				busyArray[i] = true;
			}
		}
	}*/
	
	public void proceedToInfo(){
		infoString = eventInfo.nextLine();
		infoString = infoString.toLowerCase();
		addInfo(infoString);
		VictorMain.print(Arrays.toString(infoArray));
	}
	
	public void showEntry(){
		for(int i = 0; i < dayArray.length; i++){
			if(dayArray[i].equals("null")){
				VictorMain.print("");
			}
			if(infoArray[i].equals("null")){
				VictorMain.print("");
			}
			//VictorMain.print(Arrays.toString(dayArray[i])+" - "+Arrays.toString(infoArray[i]) + ";"); fix this
		}
	}
	
	public void addInfo(String info){
		infoArray[infoCounter] = info;
		infoCounter++;
	}
	
	public boolean validDay(String input){
		boolean valid = false;
		for(int i = 0; i < daysOfTheWeek.length; i++){
			if(input.equals(daysOfTheWeek[i])){
				valid = true;
			}
		}
		return valid;
	}
	
	private void formFields(){
		eventDay = new Scanner(System.in);
		eventInfo = new Scanner(System.in);
		leave = new Scanner(System.in);
	}
	
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
}
