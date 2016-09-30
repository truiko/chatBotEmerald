package groupFiles;



public class VictorGame implements Chatbot{
	private boolean inGameLoop;
	private String gameResponse;
	
	public boolean isTriggered(String userInput){
		if(VictorMain.findKeyword(userInput, "game", 0) >= 0){
			return true;
		}
		return false;
	}

	public void talk(){
		inGameLoop = true;
		while(inGameLoop){
			VictorMain.print("(Type quit to go back.)");
			// static call on promptInput method from VictorMain class
			gameResponse = VictorMain.promptInput();
			if(gameResponse.indexOf("quit") >= 0){
				inGameLoop = false;
				VictorMain.promptForever();
			}
		}
	}
}
	
