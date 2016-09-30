package groupFiles;


public class VictorSignInTopic implements Chatbot{
	public boolean isTriggered(String userInput){
		if(VictorMain.findKeyword(userInput, "game", 0) >= 0){
			return true;
		}
		return false;
	}

	public void talk() {
		
		
	}
}
