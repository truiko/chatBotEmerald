package groupFiles;

import java.util.Random;

public class GabrielJokes implements Chatbot {
	
	private String jokeChoice;
	private boolean inJokeLoop;
	private String jokeResponse;
	private int jokeCount;
	
	static int jokeIndex = 0;
	static String[] jokes = {"Amos","Etch","Cows go"};
	static String[] jokeAnswers = {"A mosquito","Bless you","No silly. Cows go moo"};
	
	public boolean isTriggered(String userInput) {
		if(VictorMain.findKeyword(userInput, "funny", 0) >= 0){
			return true;
		}
		return false;
	}

	public void talk() {
		inJokeLoop = true;
		VictorMain.print("Would you like to hear a joke?");
		while(inJokeLoop){
			jokeResponse = VictorMain.promptInput();
			jokeResponse = jokeResponse.toLowerCase();
			jokeChoice = getJoke();
			findIndexOfJoke(jokeChoice);
			
			if(VictorMain.findKeyword(jokeResponse, "no", 0)>= 0){
				inJokeLoop = false;
				VictorMain.print("Fine then");
				VictorMain.promptForever();
			}
			if((VictorMain.findKeyword(jokeResponse, "yeah", 0)>= 0) || (VictorMain.findKeyword(jokeResponse, "yes", 0) >= 0)){
				VictorMain.print("Knock knock.");	
			}
			if(VictorMain.findKeyword(jokeResponse, "there", 0)>= 0){
				VictorMain.print(jokeChoice);
			}
			if(VictorMain.findKeyword(jokeResponse, "who", 0) >= 0){
				VictorMain.print(jokeAnswers[jokeIndex]);
			}
			
		}
	}
	
	public static String getJoke(){
		int joke = (int) (Math.random()*jokes.length); 
		return jokes[joke];
	}
	
	public static void findIndexOfJoke(String joke){
		for(int i = 0; i < jokes.length; i++){
			if(jokes[i].equals(joke)){
				jokeIndex = i;
			}
		}
	}
}

	


