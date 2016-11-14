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
}
