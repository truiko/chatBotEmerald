package groupFiles;

import java.util.Random;

public class GabrielJokes implements Chatbot {
	
	private boolean inJokeLoop;
	private String jokeResponse;
	private int jokeCount;
	private String[] jokes = {"Amos", "Etch", "Cows go"};
	private String [] jokeAnswers = {"A mosquito", "Bless you", "No silly. Cows go moo"};
	
	public boolean isTriggered(String userInput) {

		if(VictorMain.findKeyword(userInput, "funny", 0) >= 0){
			return true;
		}
		return false;
	}

	public void talk() {
		
		VictorMain.print("Would you like to hear a joke?");
		jokeResponse = VictorMain.promptInput();
		jokeResponse = jokeResponse.toLowerCase();
		if(VictorMain.findKeyword(jokeResponse, "no", 0)>= 0){
			inJokeLoop = false;
			VictorMain.print("Fine then");
			VictorMain.promptForever();
		}
		if((VictorMain.findKeyword(jokeResponse, "yeah", 0)>= 0) || (VictorMain.findKeyword(jokeResponse, "yes", 0) >= 0)){
			VictorMain.print("Knock knock.");				
			inJokeLoop = true;
			while(inJokeLoop){
				String randomJoke = (jokes[new Random().nextInt(jokes.length)]);
				if(VictorMain.findKeyword(jokeResponse, "who's there", 0) >= 0){
					VictorMain.print("randomJoke");
				}
							
			}
		}
	}
}	


