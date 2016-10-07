package groupFiles;


public class GabrielJokes implements Chatbot {
	
	private String jokeChoice;
	private boolean inJokeLoop;
	private String jokeResponse;
	private String[] calm = {"Try again.", "Almost there.", "Not quite."};
	private String[] aggravated = {"YOU MUST REALLY HATE JOKES!", "You're doing this in purpose."};
	
	static int jokeCount;
	static int jokeIndex = 0;
	static String[] jokes = {"Amos", "Etch", "Cows go"};
	static String[] jokeAnswers = {"A mosquito.", "Bless you.", "No silly, cows go moo."};
	
	public boolean isTriggered(String userInput) {
		if(VictorMain.findKeyword(userInput, "funny", 0) >= 0){
			return true;
		}
		return false;
	}

	public void talk() {
		inJokeLoop = true;
		jokeCount = 0;
		VictorMain.print("Would you like to hear a joke?");
		while(inJokeLoop){
			jokeResponse = VictorMain.promptInput();
			jokeResponse = jokeResponse.toLowerCase();
			getsBored();
			knockKnockLoop();
		}
		
	}	
	
	private static String getJoke(){
		int joke = (int) (Math.random()*jokes.length); 
		return jokes[joke];
	}
	
	private static void findIndexOfJoke(String joke){
		for(int i = 0; i < jokes.length; i++){
			if(jokes[i].equals(joke)){
				jokeIndex = i;
			}
		}
	}
	
	 private void variousResponses(){
		  int responseChoice = 0;
		  if(jokeCount > 3){
		   responseChoice = (int) (Math.random()*aggravated.length);
		   VictorMain.print(aggravated[responseChoice]);
		  }
		  else{
		   responseChoice = (int) (Math.random()*calm.length);
		   VictorMain.print(calm[responseChoice]);
		  }
	 }
	 
	 private void getsBored(){
		 if(jokeCount == 6){
			 inJokeLoop = false;
			 VictorMain.print("Let's do something else then.");
			 VictorMain.promptForever();
		 }
	 }
	 
	 private void knockKnockLoop(){
		 if(VictorMain.findKeyword(jokeResponse, "no", 0)>= 0){
				inJokeLoop = false;
				VictorMain.print("Fine then.");
				VictorMain.promptForever();
			}
			else if((VictorMain.findKeyword(jokeResponse, "already", 0)>= 0) || 
					(VictorMain.findKeyword(jokeResponse, "before", 0)>= 0)){
				inJokeLoop = false;
				VictorMain.print("I'm very sorry. " + "My library of jokes is quite short. " + "Hopefully version 2.0 will have more. ");
				VictorMain.promptForever();
			}
			else if((VictorMain.findKeyword(jokeResponse, "yeah", 0)>= 0) || 
					(VictorMain.findKeyword(jokeResponse, "yes", 0) >= 0)){
				getJoke();
				jokeChoice = getJoke();
				findIndexOfJoke(jokeChoice);
				VictorMain.print("Knock knock.");	
			}
			else if((VictorMain.findKeyword(jokeResponse, "who's there", 0)>= 0)){
					VictorMain.print(jokeChoice);
			}
			
			else if((VictorMain.findKeyword(jokeResponse, "Amos", 0) >= 0)||
					(VictorMain.findKeyword(jokeResponse, "Etch", 0) >= 0)||
					(VictorMain.findKeyword(jokeResponse, "Cows go", 0) >= 0)){

					VictorMain.print(jokeAnswers[jokeIndex]);
					VictorMain.print("Do you wanna hear another joke?");
			}
			else{
				jokeCount++;
				variousResponses();
			}
	 }
	
}

	


