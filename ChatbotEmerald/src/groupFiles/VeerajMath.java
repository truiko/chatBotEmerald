package groupFiles;

public class VeerajMath implements Chatbot{
	private boolean inMathLoop;
	private String mathResponse;
	
	public void talk() {
		inMathLoop = true;
		while(inMathLoop){
			VictorMain.print("(Type 'quit' to go back.)");
			//this is called a static call m
			mathResponse = VictorMain.promptInput();
			if(mathResponse.indexOf("quit") >= 0){
				inMathLoop = false;
				VictorMain.promptForever();
			}
			VictorMain.print("What do you want to solve?");
		}
	}

	public boolean isTriggered(String userInput) {
		if(VictorMain.findKeyword(userInput, "math", 0) >= 0){
			return true;
		}
		return false;
	}
}