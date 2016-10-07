package groupFiles;



public class VictorGame implements Chatbot{
	private boolean inGameLoop;
	private String gameResponse;

	static int[] playerChoices = {0,0,0};
	static int rounds = 0;
	static int largestIndex = 0;
	static String[] playerRecord = new String[10];
	static String roundResult;
	
	public boolean isTriggered(String userInput){
		if(VictorMain.findKeyword(userInput, "game", 0) >= 0){
			return true;
		}
		return false;
	}

	public void talk(){
		inGameLoop = true;
		if(!(rounds >= 9)){
			VictorMain.print("Let's play a game of Rock, Papers, Scissors!"
					+ " Choose your weapon.");
		}
		while(inGameLoop){
			VictorMain.print("(Type quit to go back.)");
			gameResponse = VictorMain.promptInput();
			gameResponse = gameResponse.toLowerCase();
			if(VictorMain.findKeyword(gameResponse, "quit", 0) >= 0 || rounds >= 9){
				if(rounds >= 9){
					VictorMain.print("I'm bored. Let's do something different.");
				}
				inGameLoop = false;
				VictorMain.promptForever();
			}
			if(VictorMain.findKeyword(gameResponse, "record", 0) >= 0){
				showRecord();
			}else{
				if(!isValidChoice(gameResponse)){
					VictorMain.print("Please choose a valid option.");
				}else{
					trackUserChoices(gameResponse);
					roundResult = determineWinner(gameResponse);
					updateRecord(roundResult);
					rounds++;
					VictorMain.print(roundResult);
					VictorMain.print(computerRespond(determineMostUsed(), findLargest()));
					
				}
			}
		}
	}
	
	public static String computerRespond(String mostUsed, int numTimes){
		if(rounds > 1){
			if(playerRecord[rounds - 1].equals(playerRecord[rounds-2]) && playerRecord[rounds - 1].equals("lost")){
				return "You are really bad at this game!";
			}else{
				if(playerRecord[rounds - 1].equals(playerRecord[rounds-2]) && playerRecord[rounds - 1].equals("win") ){
					return "You are too good at this game. You are cheating!";
				}
			}
		}
		if(rounds == 5){
			return "You sure love using " + mostUsed + ". You have used it " + numTimes + " times already!";
		}
		return "Hey! Let's play more rounds!";
	}
	
	public static void showRecord(){
		for(int i = 0; i < playerRecord.length; i++){
			int roundNumber = i + 1;
			if(playerRecord[i] == (null)){
				break;
			}else{
				VictorMain.print("Round " + roundNumber + " result: " + playerRecord[i]);
			}
		}
	}
	public static void updateRecord(String result){
		if(VictorMain.findKeyword(result, "computer", 0) >= 0){
			playerRecord[rounds] = "lost";
		}else{
			if(VictorMain.findKeyword(result, "tie", 0) >= 0){
				playerRecord[rounds] = "tie";
			}else{
				playerRecord[rounds] = "win";
			}
		}
	}
	
	public static String determineMostUsed(){
		if(largestIndex == 0){
			return "rock";
		}else{
			if(largestIndex == 1){
				return "paper";
			}else{
				return "scissor";
			}
		}
	}
	
	public static int findLargest(){
		int largest = playerChoices[0];
		for(int i = 0; i < playerChoices.length; i++){
			if(playerChoices[i] >= largest){
				largest = playerChoices[i];
			}
			if(i == playerChoices.length){
				i = largestIndex;
			}
		}
		return largest;
	}
	
	public static void trackUserChoices(String choice){
		if(choice.equals("rock")){
			playerChoices[0] ++; 
		}else{
			if(choice.equals("paper")){
				playerChoices[1] ++;
			}else{
				playerChoices[2] ++;
			}
		}
	}
	public static String determineWinner(String userChoice){
		int computerChoice = makeComputerChoice();
		int ROCK = 1;
		int PAPER = 2;
		int SCISSOR = 3;
		if(userChoice.equals("rock") && computerChoice == PAPER){
			return "The winner is "+ "computer!";
		}else{
			if(userChoice.equals("rock") && computerChoice == SCISSOR){
				return "The winner is " + VictorMain.user + "!";
			}else{
				if(userChoice.equals("paper") && computerChoice == ROCK){
					return "The winner is " + VictorMain.user + "!";
				}else{
					if(userChoice.equals("paper") && computerChoice == SCISSOR){
						return "The winner is "+ "computer!";
					}else{
						if(userChoice.equals("scissor") && computerChoice == PAPER){
							return "The winner is " + VictorMain.user + "!";
						}else{
							if(userChoice.equals("scissor") && computerChoice == ROCK){
								return "The winner is "+ "computer!";
							}
						}
					}
				}
			}
		}
		return "The round is a tie";	
	}
	
	private static int makeComputerChoice(){
		
		return (int) (Math.random()*3) + 1;
	}
	
	private static boolean isValidChoice(String choice){
		String[] choices = {"rock", "paper", "scissor"};
		boolean match = false;
		for(int i = 0; i < choices.length; i++){
			if(choice.equals(choices[i])){
				match = true;
			}
		}
		return match;
	}
}
