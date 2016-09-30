package groupFiles;

//import chatbot.MahinMain;

public class MahinContradiction implements Chatbot{
	private boolean inContradictionLoop;
	private String contradictionResponse;
	// j
	public boolean isTriggered(String userInput){
		if(VictorMain.findKeyword(userInput, "not", 0)>=0){
			return true;
		}
		return false;
		
	}
	
	public void talk(){
		
	}
}
