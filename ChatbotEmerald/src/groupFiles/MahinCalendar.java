package groupFiles;

import java.util.Scanner;
import java.util.Arrays;

//import groupFiles.VictorMain;


public class MahinCalendar implements Chatbot{
	private boolean inCalendarLoop;
	//private String calendarResponse;
	
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
	int busyCounter = 0;
	
	private int getIndex;
	
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
		if(VictorMain.findKeyword(userInput, "remember", 0)>=0){
			return true;
		}
		if(VictorMain.findKeyword(userInput, "week", 0)>=0){
			return true;
		}
		return false;
		
	}
	
	public void talk(){
		formFields();
		inCalendarLoop = true;
		VictorMain.print("Would you like to add things to my calendar for this week?");
		showEntry();
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
				if(busyCounter > 6){
					VictorMain.print("You are busy for the whole week!");
					inCalendarLoop = false;
					VictorMain.promptForever();
				}
				dayString = enterValidDay();
				getIndex = getIndexOfDayEntered(dayString);
				determineBusiness(getIndex);
				
					proceedToInfo();
					showEntry();
			}
		}
	}
	
	public String enterValidDay(){
		boolean waitingForInput = true;
		VictorMain.print("Please enter a day.");
		String dayString = VictorMain.promptInput();
		while(waitingForInput){
			if(!validDay(dayString)){
				VictorMain.print("Enter valid day");
				dayString = VictorMain.promptInput();
			}else{
				waitingForInput = false;
			}
		}
		
		return dayString;
	}
	
	
	public void proceedToDays(){
		VictorMain.print("Add some information about this day.");
		for(int i = 0; i < daysOfTheWeek.length; i++){
				if(VictorMain.findKeyword(dayString, daysOfTheWeek[i], 0) >= 0){
					addDay(daysOfTheWeek[i]);
				}
			}	
			VictorMain.print(Arrays.toString(dayArray));
			VictorMain.print(Arrays.toString(busyArray));
		}
		
	public int getIndexOfDayEntered(String dayEntered){
		int counter = 0;
		/*int counter = 0;
		boolean notFound = true;
		while(notFound == true){
			if(dayEntered != daysOfTheWeek[counter]){
			counter = counter + 1;	
				if(counter > 6){
					return 1;
				}
			}else{
				notFound = false;
			}
		}
			return counter;
	}*/
	//use findkeyword, if it finds monday, return 0, etc.
		if(VictorMain.findKeyword(dayEntered, "monday", 0) >= 0){
			counter = 0;
		}
		if(VictorMain.findKeyword(dayEntered, "tuesday", 0) >= 0){
			counter = 1;
		}
		if(VictorMain.findKeyword(dayEntered, "wednesday", 0) >= 0){
			counter = 2;
		}
		if(VictorMain.findKeyword(dayEntered, "thursday", 0) >= 0){
			counter = 3;
		}
		if(VictorMain.findKeyword(dayEntered, "friday", 0) >= 0){
			counter = 4;
		}
		if(VictorMain.findKeyword(dayEntered, "saturday", 0) >= 0){
			counter = 5;
		}
		if(VictorMain.findKeyword(dayEntered, "sunday", 0) >= 0){
			counter = 6;
		}
		return counter;
	}
	
	public void determineBusiness(int index){
		System.out.println(index);
		VictorMain.print(Arrays.toString(busyArray));
		System.out.println(busyCounter);
		if(busyArray[index] == false){
			proceedToDays();
		}
		if(busyArray[index] == true){
			VictorMain.print("This day is busy. Choose another day.");
			inCalendarLoop = false;
			VictorMain.promptForever();
		}
		VictorMain.print(Arrays.toString(busyArray));
	}
	
	
	public void proceedToInfo(){
		infoString = eventInfo.nextLine();
		infoString = infoString.toLowerCase();
		addInfo(infoString);
		inCalendarLoop = false;
		//comment?
		VictorMain.promptForever();
		VictorMain.print(Arrays.toString(infoArray));
	}
	
	public void showEntry(){
		for(int i = 0; i < dayArray.length; i++){
			VictorMain.print("Day: " + dayArray[i] + " - " + infoArray[i]);
		}
		VictorMain.print(Arrays.toString(busyArray));
	}
	
	public void addInfo(String info){
		infoArray[infoCounter] = info;
		//busyArray[busyCounter] = true; //used infoCounter before
		infoCounter++;
		//busyCounter++;
		
		if(VictorMain.findKeyword(dayString, "monday", 0) >= 0){
			busyArray[0] = true;
		}
		if(VictorMain.findKeyword(dayString, "tuesday", 0) >= 0){
			busyArray[1] = true;
		}
		if(VictorMain.findKeyword(dayString, "wednesday", 0) >= 0){
			busyArray[2] = true;
		}
		if(VictorMain.findKeyword(dayString, "thursday", 0) >= 0){
			busyArray[3] = true;
		}
		if(VictorMain.findKeyword(dayString, "friday", 0) >= 0){
			busyArray[4] = true;
		}
		if(VictorMain.findKeyword(dayString, "saturday", 0) >= 0){
			busyArray[5] = true;
		}
		if(VictorMain.findKeyword(dayString, "sunday", 0) >= 0){
			busyArray[6] = true;
		}
	}
	
	public void updateBusiness(){
		busyArray[busyCounter] = true;
		busyCounter++;
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
