package groupFiles;

//import chatbot.VictorMain;

//import chatbot.MahinMain;

public class MahinContradiction implements Chatbot{
	private boolean inContradictionLoop;
	private String contradictionResponse;
	// j
	public boolean isTriggered(String userInput){
		if(VictorMain.findKeyword(userInput, "not", 0)>=0){
			return true;
		}
		if(VictorMain.findKeyword(userInput, "is", 0)>=0){
			return true;
		}
		if(VictorMain.findKeyword(userInput, "are", 0)>=0){
			return true;
		}
		if(VictorMain.findKeyword(userInput, "am", 0)>=0){
			return true;
		}
		return false;
		
	}
	
	public void talk(){
		inContradictionLoop = true;
		while(inContradictionLoop){
			VictorMain.print("Type 'quit' to go back.");
			contradictionResponse = VictorMain.promptInput();//static call on promptInput method from
			//MahinMain class
			if(contradictionResponse.indexOf("quit") >= 0){
				inContradictionLoop = false;
				VictorMain.promptForever();
			}
			VictorMain.print("You may have contradicted yourself.");
			//for each user response, if it finds response with similar beginning,
			//and the rest is different, it will notice.
			//for each user response, it goes through each word and checks to see
			//if it matches its recent response. once it notices a mismatch,
			//it takes the comment before the new comment or theOriginalComment
			//(comments that are both similar to each other) and it says:
			//"i thought you said:" + theOriginalComment
		}
	}
}
