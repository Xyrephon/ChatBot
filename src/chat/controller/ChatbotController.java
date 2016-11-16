package chat.controller;

import chat.model.Chatbot;
import chat.view.ChatViewer;
import chat.view.ChatFrame;

public class ChatbotController
{
	private Chatbot stupidBot;
	private ChatViewer display;
	private ChatFrame appFrame;
	
	public ChatbotController()
	{
		stupidBot = new Chatbot("Unitelligent Chat Machine");
		display = new ChatViewer();
		appFrame = new ChatFrame(this);
	}
	
	public void start()
	{
		String response = "Words";
		while (stupidBot.lengthChecker(response))
		{
			
			response = display.collectResponse("What do you want to talk about?");
		}
	}
	
	public String useChatbotCheckers(String input)
	{
		String checkedInput = "";
		
		if(stupidBot.inputHTMLChecker(input))
		{
			checkedInput += "\nYou are typing in HTML!\n";
		}
		
		if(stupidBot.memeChecker(input))
		{
			checkedInput += "\nYou like memes!\n";
		}
		
		if(stupidBot.contentChecker(input))
		{
			checkedInput += "\nYou know my secret topic!\n";
		}
		
		if(stupidBot.keyboardMashChecker(input))
		{
			checkedInput += "\nYou are mashing the keyboard!\n";
		}
		
		if(stupidBot.twitterChecker(input))
		{
			checkedInput += "\nI see that you like Twitter!\n";
		}
		
		if(checkedInput.length() == 0)
		{
			checkedInput = "I have no idea you mean about " + input;
		}
		
		return checkedInput;
	}
	

}
