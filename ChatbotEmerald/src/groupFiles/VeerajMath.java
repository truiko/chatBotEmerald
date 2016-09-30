package groupFiles;

public class VeerajMath implements Chatbot{
	private boolean inMathLoop;
	private String mathResponse;
	
	public void talk() {
		inMathLoop = true;
		while(inMathLoop){
			VictorMain.print("This is the math section. Type quit to quit.");
			//this is called a static call
			mathResponse = VictorMain.promptInput();
			if(mathResponse.indexOf("quit") >= 0){
				inMathLoop = false;
				VictorMain.promptForever();
			}
		}
	}

	public boolean isTriggered(String userInput) {
		if(VictorMain.findKeyword(userInput, "math", 0) >= 0){
			return true;
		}
		return false;
	}
}