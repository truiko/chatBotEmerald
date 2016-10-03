package groupFiles;

public class GabrielJokes implements Chatbot {
	
	private boolean inJokeLoop;
	private String jokeResponse;

	public boolean isTriggered(String userInput) {

		if(VictorMain.findKeyword(userInput, "funny", 0) >= 0){
			return true;
		}
		return false;
	}

	public void talk() {
		inJokeLoop = true;
		while(inJokeLoop){
			VictorMain.print("Would you like to hear a joke?");
			jokeResponse = VictorMain.promptInput();
			if(jokeResponse.indexOf("no") >= 0){
				inJokeLoop = false;
				VictorMain.print("Fine then");
				VictorMain.promptForever();
			}
		}
	}
}
