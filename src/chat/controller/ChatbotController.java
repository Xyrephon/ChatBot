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
			checkedInput = "I have no idea you mean about, \"" + input + "\"\n";
		}
		
		if (stupidBot.politicalTopicChecker(input))
		{
			checkedInput = "\nYou are talking about politics!\n";
		}
		int canBeRandom = (int) (Math.random() * 7);
		if(canBeRandom % 7 == 0)
		{
		checkedInput += randomTopicGenerator();
		}
		
		return checkedInput;
	}

	private String randomTopicGenerator()
	{
		String randomTopic = "";
		int random = (int) (Math.random() * 7);
		
		switch(random)
		{
		case 0:
			randomTopic = "Did you hear about the daft pk beastie boys mix?";
			break;
		case 1:
			randomTopic = "Can you bring me some Siracha?";
			break;
		case 2:
			randomTopic = "Time for some industrial!";
			break;
		case 3:
			randomTopic = "Reading novels is fantastic!";
			break;
		case 4:
			randomTopic = "Computational and algorithmic thinking for the win";
			break;
		case 5:
			randomTopic = "I love Java!";
			break;
		case 6:
			randomTopic = "Time to run!";
			break;
		default:
			randomTopic = "This can't be happening!";
			break;
			
		}
		
		return randomTopic;
	}

}
