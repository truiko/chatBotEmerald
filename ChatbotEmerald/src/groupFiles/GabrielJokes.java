package groupFiles;

public class GabrielJokes implements Chatbot {
	
	private boolean inJokeLoop;
	private String[] knockKnockJokes = {"Knock Knock", "Etch", "Amos" };
	private String[] knockKnockAnswers = {"Bless you", "A mosquito"}; 
	
	public void talk() {
		
	}

	public boolean isTriggered(String userInput) {

		if(VictorMain.findKeyword(userInput, "funny", 0) >= 0){
			return true;
		}
		return false;
	}

}
