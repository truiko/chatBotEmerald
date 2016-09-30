package groupFiles;

public class GabrielJokes implements Chatbot {
	
	public void talk() {
		// TODO Auto-generated method stub
		
	}

	public boolean isTriggered(String userInput) {

		if(VictorMain.findKeyword(userInput, "funny", 0) >= 0){
			return true;
		}
		return false;
	}

}
