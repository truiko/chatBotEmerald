package groupFiles;



public class VictorGame implements Chatbot{
	private boolean inGameLoop;
	private String gameResponse;
	
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
			if(gameResponse.indexOf("quit") >= 0){
				inGameLoop = false;
				VictorMain.promptForever();
			}
			 if(!isValidChoice(gameResponse)){
				VictorMain.print("Please choose a valid option.");
			}else{
				VictorMain.print(determineWinner(gameResponse));
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
