package groupFiles;

import java.util.Scanner;



public class MahinCalendar implements Chatbot{
	private boolean inCalendarLoop;
	
	
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
	String[] initialChatbotResponses = {"Well then...", "I don't think you value organization and punctuality", "Perhaps you already have a calendar to add things to..."};
	int dayCounter = 0;
	int infoCounter = 0;
	
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
		
			if(VictorMain.findKeyword(leaveString, "no", 0) >= 0||VictorMain.findKeyword(leaveString, "quit", 0) >= 0 ){
				inCalendarLoop = false;
				VictorMain.print(initialChatbotResponses[(int) (Math.random() * initialChatbotResponses.length)]);
				VictorMain.promptForever();
			}else{
				VictorMain.print("I will take that as a yes. Which day? Monday, Tuesday, Wednesday, Thursday, or Friday?");
				
				dayString = enterValidDay();
				getIndex = getIndexOfDayEntered(dayString);
				determineBusiness(getIndex);
				
				proceedToInfo();
				showEntry();
			}
		}
	}
	
	private void formFields(){
		eventDay = new Scanner(System.in);
		eventInfo = new Scanner(System.in);
		leave = new Scanner(System.in);
	}
	
	private boolean validDay(String input){
		boolean valid = false;
		for(int i = 0; i < daysOfTheWeek.length; i++){
			if(input.equals(daysOfTheWeek[i])){
				valid = true;
			}
		}
		return valid;
	}
	
	private String enterValidDay(){
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
	
	private int getIndexOfDayEntered(String dayEntered){
		int counter = 0;
		
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
	
	private void determineBusiness(int index){
		if(busyArray[index] == false){
			proceedToDays();
		}
		if(busyArray[index] == true){
			VictorMain.print("This day is busy. Choose another day.");
			inCalendarLoop = false;
			VictorMain.promptForever();
		}
	}
	
	private void addDay(String day){
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
	
	private void proceedToDays(){
		VictorMain.print("Add some information about this day.");
		for(int i = 0; i < daysOfTheWeek.length; i++){
				if(VictorMain.findKeyword(dayString, daysOfTheWeek[i], 0) >= 0){
					addDay(daysOfTheWeek[i]);
				}
			}	
		}
	
	private void addInfo(String info){
		infoArray[infoCounter] = info;
		infoCounter++;
		
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
	
	private void proceedToInfo(){
		infoString = eventInfo.nextLine();
		infoString = infoString.toLowerCase();
		addInfo(infoString);
		inCalendarLoop = false;
		VictorMain.promptForever();
	}
	
	private void showEntry(){
		for(int i = 0; i < dayArray.length; i++){
			VictorMain.print("Day: " + dayArray[i] + " - " + infoArray[i]);
		}
		if(busyArray[0] ==  true && busyArray[1] == true && busyArray[2] == true && busyArray[3] == true && busyArray[4] == true
				&& busyArray[5] == true && busyArray[6] == true){
				VictorMain.print("You are busy for the whole week!");
		}
	}
}
