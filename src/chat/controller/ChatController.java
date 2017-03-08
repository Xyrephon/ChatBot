package chat.controller;

import chat.model.Chatbot;
import chat.view.ChatViewer;
import chat.view.ChatFrame;
import chat.model.CTECTwitter;

public class ChatController
{
	private Chatbot stupidBot;
	private ChatViewer display;
	private ChatFrame appFrame;
	public CTECTwitter twitterBot;

	public ChatController()
	{
		stupidBot = new Chatbot("Unitelligent Chat Machine");
		twitterBot = new CTECTwitter(this);
		display = new ChatViewer();
		appFrame = new ChatFrame(this);
	}
	/**
	 * Used to start the program.
	 */
	public void start()
	{

	}
	/**
	 * Looks through all of my checkers to see if the input matches a topic.
	 * Sometimes adds a random topic using randomTopicGenerator.
	 * @param input
	 * @return
	 */
	public String useChatbotCheckers(String input)
	{
		String checkedInput = "";

		if (!stupidBot.quitChecker(input))
		{
			if (stupidBot.inputHTMLChecker(input))
			{
				checkedInput += "\nYou are typing in HTML!\n";
			}

			if (stupidBot.memeChecker(input))
			{
				checkedInput += "\nYou like memes!\n";
			}

			if (stupidBot.contentChecker(input))
			{
				checkedInput += "\nYou know my secret topic!\n";
			}

			if (stupidBot.keyboardMashChecker(input))
			{
				checkedInput += "\nYou are mashing the keyboard!\n";
			}

			if (stupidBot.twitterChecker(input))
			{
				checkedInput += "\nI see that you like Twitter!\n";
			}

			if (checkedInput.length() == 0)
			{
				checkedInput = "I have no idea you mean about, \"" + input + "\"\n";
			}

			if (stupidBot.politicalTopicChecker(input))
			{
				checkedInput = "\nYou are talking about politics!\n";
			}
			
			int canBeRandom = (int) (Math.random() * 7);
			if (canBeRandom % 7 == 0)
			{
				checkedInput += randomTopicGenerator();
			}
		}
		else
		{
			display.displayMessage("Thanks for chatting! Talk to you soon!");
			System.exit(0);
		}

		return checkedInput;
	}
	/**
	 * Gets the ChatFrame
	 * @return
	 */
	public ChatFrame getBaseFrame()
	{
		return appFrame;
	}
	/**
	 * Gets the Chatbot
	 * @return
	 */
	public Chatbot getChatbot()
	{
		return stupidBot;
	}
	/**
	 * Creates a random topic for users
	 * @return
	 */
	private String randomTopicGenerator()
	{
		String randomTopic = "";
		int random = (int) (Math.random() * 7);

		switch (random)
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
	
	public void handleErrors(Exception currentException)
	{
		display.displayMessage("An error has occured. Details provided next.");
		display.displayMessage(currentException.getMessage());
	}
	
	public void useTwitter(String text)
	{
		twitterBot.sendTweet(text);
	}
	
	public ChatViewer getPopup()
	{
		return display;
	}

	public String searchTwitterUser(String usernameToSearch)
	{
		String searchResults = "The most popular word by user: " + usernameToSearch + ", is";
		
		searchResults += twitterBot.getMostCommonWord(usernameToSearch);
		
		return searchResults;
	}
}
