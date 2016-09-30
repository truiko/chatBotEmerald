package groupFiles;

public class VeerajMath implements Chatbot{
	public void talk() {
		
	}

	public boolean isTriggered(String userInput) {
		if(VictorMain.findKeyword(userInput, "math", 0) >= 0){
			return true;
		}
		return false;
	}
}
