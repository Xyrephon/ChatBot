package chat.controller;

import chat.model.Chatbot;
import chat.view.ChatViewer;


public class ChatbotController
{
	private Chatbot stupidBot;
	private ChatViewer display;
	
	public ChatbotController()
	{
		stupidBot = new Chatbot("Unitelligent Chat Machine");
		display = new ChatViewer();
	}
	
	public void start()
	{
		String response = "Words";
		while (stupidBot.lengthChecker(response))
		{
			
			response = display.collectResponse("What do you want to talk about?");
		}
	}
}
