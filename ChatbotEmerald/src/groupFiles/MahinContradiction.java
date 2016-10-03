package groupFiles;

//import groupFiles.VictorMain;


public class MahinContradiction implements Chatbot{
	private boolean inCalendarLoop;
	private String calendarResponse;
	/*static Scanner eventMonth;
	static Scanner eventDay;
	static Scanner eventYear;
	static Scanner eventTime;
	static Scanner eventInfo;
	*/
	
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
		inCalendarLoop = true;
		while(inCalendarLoop){
			VictorMain.print("Would you like to add things to my calendar?");
			calendarResponse = VictorMain.promptInput();//static call on promptInput method from
			//MahinMain class
			if(calendarResponse.indexOf("no") >= 0){
				inCalendarLoop = false;
				VictorMain.print("I don't think you value organization and punctuality.");
				VictorMain.promptForever();
			}else{
				VictorMain.print(addToCalendar());
			}
		}
	}
	
	public static String addToCalendar(){
		return "I will take that as a yes.";
	}
}
