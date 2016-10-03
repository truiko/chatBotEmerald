package groupFiles;

import java.util.Scanner;

public class VictorMain {
	static String response;
	static boolean inMainLoop;
	static Scanner input;
	static String user;
	static boolean triggered;
	// list all the chatbots available under this class
	// add group chatbots below (see example)
	// static Chatbot school;
	static Chatbot veeraj;
	static Chatbot gabriel;
	static Chatbot mahin;
	static Chatbot victor;

	public static void main(String[] args) {
		// demonstrateStringMethods();
		createFields();
		promptName();
		// promptInput();
		promptForever();
	}
	
	public static void promptName() {
		print("Enter your name.");
		user = input.nextLine();
		print("Glad to meet you, " + user + ". For the rest of time, I will call you, " + user 		+ ". You may call me Computer." + " We should become friends. ");
	}

	public static void promptForever() {
		inMainLoop = true;
		triggered = false;
		while(inMainLoop){
			print("Hi, " + user + ". How are you?");
			response = promptInput();
			
			if(veeraj.isTriggered(response)){
				veeraj.talk();
				triggered = true;
			}
			if(gabriel.isTriggered(response)){
				gabriel.talk();
				triggered = true;
			}
			if(mahin.isTriggered(response)){
				mahin.talk();
				triggered = true;
			}
			if(victor.isTriggered(response)){
				victor.talk();
				triggered = true;
			}
			if(findKeyword(response, "good", 0) >= 0){
				print("That's wonderful." + "So glad you feel good.");
			}else if(triggered == false)
				print("I don't understand.");
			}
			// response to liking school heck
//			else if(school.isTriggered(response)){
//				print("School is great. Tell me about school.");
//				// exit this while loop
//				inMainLoop = false;
//				// got to the school's talk method
//				school.talk();
//			}
			
	}
		
	

	public static int findKeyword(String searchString, String keyword, int startPosition) {
		// delete white space
		searchString = searchString.trim();
		// make lower case
		searchString = searchString.toLowerCase();
		keyword = keyword.toLowerCase();
		// System.out.println("The phrase is " + searchString);
		// System.out.println("The keyword is " + keyword);
		// first position of key word
		int position = searchString.indexOf(keyword);
		// System.out.println("The keyword was found at "+ position);
		while(position >= 0){
			// assume preceeded and followed by space
			String before = " ";
			String after = " ";
			// check character in front if it exists
			if(position > 0){
				before = searchString.substring(position - 1, position);
			// 	System.out.println("The character before is " + before);
			}
			// check if there is a character after the keyword
			if(position + keyword.length() < searchString.length()){
				after = searchString.substring(position + keyword.length(), position +
						keyword.length() + 1);
			//	System.out.println("The character after is " + after);
			}
			if(before.compareTo("a") < 0 && after.compareTo("a") < 0 && noNegations(searchString, position)){
			//	System.out.println("Found " + keyword + " at " + position );
				return position;
			}
			else{
				// position + 1 is one space after our current position,
				// so this finds the next word
				position = searchString.indexOf(keyword, position + 1);
			//	System.out.println("Did not find " + keyword + ", checking position " 
			//	+ position );
			}
		}
		return -1;
	}
	/**
	 * This is a helper method. A helper method is a method designed for "helping"
	 * a larger method . Because of this, helper methods are generally private because they are
	 * only used by the methods they are helping ALSO, when you do your project, 
	 * I expect to see helper methods because they make the code more READABLE
	 * @param searchString (always lowercase)
	 * @param position
	 * @return "true" if there is no negation words
	 * in front of position
	 */
	private static boolean noNegations(String searchString, int position) {
		// check to see if the word "no" is in front of position
		// check to see if there are 3 spaces in front
		// then check to see if "no" is there
		if(position - 3 >= 0 && searchString.substring(position - 3, position).equals("no ")){
			return false;
		}
		// check for not
		if(position - 4 >= 0 && searchString.substring(position - 4, position).equals("not ")){
			return false;
		}
		// check for never
		if(position - 6 >= 0 && searchString.substring(position - 6, position).equals("never ")){
			return false;
		}
		// check for n't
		if(position - 4 >= 0 && searchString.substring(position - 4, position).equals("n't ")){
			return false;
		}
		return true;
	}

	public static String promptInput() {
		String userInput = input.nextLine();
		return userInput;
	}

	public static void createFields() {
		input = new Scanner(System.in);
		user = "";
		// initialize group chatbots below
//		school = new VictorSchool();
		veeraj = new VeerajMath();
		gabriel = new GabrielJokes();
		mahin = new MahinContradiction();
		victor = new VictorGame();
	}
	
	public static void demonstrateStringMethods(){
		
		String text1 = new String("Hello World");
		String text2 = "Hello World"; // same as above
		if(text1.equals(text2)){
			print("These strings are equal:");
		}
		print(text1);
		print(text2);
		
		String word1 = "Aardvark";
		String word2 = "Zyzzyva";
		
		if(word1.compareTo(word2) < 0){
			print("word1 comes before word2");
		}
		
	}
	public static void print(String s){
		String printString = "";
		int cutoff = 35;
		// check for words to add
		// in other words, s had a length > 0
		while(s.length() > 0){
			String cut = "";
			String nextWord = "";
			// check to see if the next word will fit on the line
			// and there must still be words to add
			while(cut.length() + nextWord.length() < cutoff && s.length() > 0){
				// add the next word to the line
				cut += nextWord;
				s = s.substring(nextWord.length());
				
				// identify the following word without the space
				int endOfWord = s.indexOf(" ");
				// if there are no more spaces
				// this is the last word, so add the whole thing
				if(endOfWord == -1){
					endOfWord = s.length() - 1; // -1 for index
				}
				nextWord = s.substring(0, endOfWord + 1);
			}
			printString += cut + "\n";
		}
		System.out.println(printString);
	}
}

