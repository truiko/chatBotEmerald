package groupFiles;



public class VictorGame implements Chatbot{
	private boolean inGameLoop;
	private String gameResponse;

	static int[] playerChoices = {0,0,0};
	static int rounds = 0;
	static int largestIndex = 0;
	
	public boolean isTriggered(String userInput){
		if(VictorMain.findKeyword(userInput, "game", 0) >= 0){
			return true;
		}
		return false;
	}

	public void talk(){
		inGameLoop = true;
		VictorMain.print("Let's play a game of Rock, Papers, Scissors!"
				+ " Choose your weapon.");
		while(inGameLoop){
			VictorMain.print("(Type quit to go back.)");
			// static call on promptInput method from VictorMain class
			gameResponse = VictorMain.promptInput();
			if(VictorMain.findKeyword(gameResponse, "quit", 0) >= 0){
				inGameLoop = false;
				VictorMain.promptForever();
			}
			 if(!isValidChoice(gameResponse)){
				VictorMain.print("Please choose a valid option.");
			}else{
				rounds++;
				trackUserChoices(gameResponse);
				VictorMain.print(determineWinner(gameResponse));
				VictorMain.print(computerRespond(determineMostUsed(), findLargest()));
			}
		}
	}
	
	public static String computerRespond(String mostUsed, int numTimes){
		if(rounds == 5){
			return "You sure love using " + mostUsed + ". You have used it " + numTimes + " times already!";
		}
		return "Hey! Let's play more rounds!";
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
		System.out.println(computerChoice);
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
