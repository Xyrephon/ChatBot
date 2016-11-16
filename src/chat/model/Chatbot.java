package chat.model;

import java.util.ArrayList;

/**
 * Base version of the 2015 Chatbot class. Only stub methods are provided.
 * Students will complete methods as part of the project.
 * 
 * @author Cody Henrichsen
 * @version 1.0 10/14/15
 */
public class Chatbot
{
	private ArrayList<String> memesList;
	private ArrayList<String> politicalTopicList;
	private String userName;
	private String content;

	/**
	 * Creates an instance of the Chatbot with the supplied username.
	 * 
	 * @param userName
	 *            The username for the chatbot.
	 */

	public Chatbot(String userName)
	{
		content = new String("dog");
		this.userName = userName;
		this.content = "Something nifty";
		memesList = new ArrayList<String>();
		buildMemesList();
		politicalTopicList = new ArrayList<String>();
		buildPoliticalTopicsList();

	}

	private void buildMemesList()
	{
		memesList.add("doge");
		memesList.add("cute animals");
		memesList.add("grumpy cat");
		memesList.add("dat boi");
		memesList.add("willy wonka");
		memesList.add("harambe");
		memesList.add("john cena");
		memesList.add("chuck norris");
		memesList.add("the most interesting man alive");
		memesList.add("punctuation saves lives");
		memesList.add("winter is coming");
		memesList.add("arthur");
		memesList.add("y u no");
		memesList.add("philosoraptor");
		memesList.add("one does not simply");
		memesList.add("fururama fry");
		memesList.add("success kid");
		memesList.add("bad luck brian");
		memesList.add("good guy greg");
	}

	private void buildPoliticalTopicsList()
	{
		politicalTopicList.add("Democrat");
		politicalTopicList.add("Republican");
		politicalTopicList.add("11/8/16");
		politicalTopicList.add("conservative");
		politicalTopicList.add("Clinton");
		politicalTopicList.add("Trump");
		politicalTopicList.add("Kaine");
		politicalTopicList.add("Pence");
		politicalTopicList.add("Stein");
		politicalTopicList.add("Johnson");
		politicalTopicList.add("election");
		politicalTopicList.add("Ben Carson");
		politicalTopicList.add("politics");
		politicalTopicList.add("Democracy");
		politicalTopicList.add("Republic");
		politicalTopicList.add("government");
		politicalTopicList.add("corruption");
		politicalTopicList.add("constitution");
		politicalTopicList.add("presidential");
	}

	/**
	 * Checks the length of the supplied string. Returns false if the supplied
	 * String is empty or null, otherwise returns true.
	 * 
	 * @param currentInput
	 * @return A true or false based on the length of the supplied String.
	 */

	public boolean lengthChecker(String currentInput)
	{
		boolean hasLength = false;

		if (currentInput != null && !currentInput.equals(""))
		{
			hasLength = true;
		}

		return hasLength;
	}

	/**
	 * * Checks if the supplied String matches the content area for this Chatbot
	 * instance.
	 * 
	 * @param currentInput
	 *            The supplied String to be checked. * @return Whether it
	 *            matches the content area.
	 */

	public boolean contentChecker(String currentInput)
	{
		boolean hasContent = false;

		if (currentInput.contains(content))
		{
			hasContent = true;
		}

		return hasContent;
	}

	/**
	 * * Checks if supplied String matches ANY of the topics in the
	 * politicalTopicsList. Returns true if it does find a match and false if it
	 * does not match.
	 * 
	 * @param currentInput
	 *            The supplied String to be checked. * @return Whether the
	 *            String is contained in the ArrayList.
	 */
	public boolean politicalTopicChecker(String currentInput)
	{
		boolean politicalTopic = false;

		for (String currentPoliticalTopic : politicalTopicList)
		{
			if (currentInput.contains(currentPoliticalTopic))
			{
				politicalTopic = true;
			}
		}

		return politicalTopic;
	}

	/**
	 * * Checks to see that the supplied String value is in the current
	 * memesList variable.
	 * 
	 * @param currentInput
	 *            The supplied String to be checked. * @return Whether the
	 *            supplied String is a recognized meme.
	 */
	public boolean memeChecker(String currentInput)
	{
		boolean meme = false;
		String tempInput = currentInput.toLowerCase();

		for (String currentMeme : memesList)
		{
			if (tempInput.contains(currentMeme))
			{
				meme = true;
			}
		}

		return meme;
	}

	/**
	 * * Returns the username of this Chatbot instance. * @return The username
	 * of the Chatbot.
	 */
	public String getUserName()
	{
		return userName;
	}

	/**
	 * * Returns the content area for this Chatbot instance. * @return The
	 * content area for this Chatbot instance.
	 */
	public String getContent()
	{
		return content;
	}

	/**
	 * * Getter method for the memesList object. * @return The reference to the
	 * meme list.
	 */
	public ArrayList<String> getMemesList()
	{
		return memesList;
	}

	/**
	 * * Getter method for the politicalTopicList object. * @return The
	 * reference to the political topic list.
	 */
	public ArrayList<String> getPoliticalTopicList()
	{
		return politicalTopicList;
	}

	/**
	 * * Updates the content area for this Chatbot instance. * @param content
	 * The updated value for the content area.
	 */
	public void setContent(String content)
	{

	}

	public boolean quitChecker(String currentInput)
	{
		boolean checker = false;

		if (currentInput.equals("exit"))
		{
			checker = false;
		}

		if (currentInput.equals("quit"))
		{
			checker = true;
		}

		return checker;
	}

	public boolean keyboardMashChecker(String currentInput)
	{
		boolean mashChecker = false;

		if (currentInput.contains("S.D.F."))
		{
			mashChecker = false;
		}

		if (currentInput.contains("derf"))
		{
			mashChecker = false;
		}

		if (currentInput.contains("sdf"))
		{
			mashChecker = true;
		}

		if (currentInput.contains("dfg"))
		{
			mashChecker = true;
		}

		if (currentInput.contains("cvb"))
		{
			mashChecker = true;
		}

		if (currentInput.contains(",./"))
		{
			mashChecker = true;
		}

		return mashChecker;
	}

	public boolean inputHTMLChecker(String currentInput)
	{
		boolean HTMLChecker = false;
		int open = -1;
		int close = -1;
		int open2 = -1;
		int close2 = -1;
		int HREFStart = -1;
		int HREFEnd = -1;
		int HREFCheck = -1;
		int IStart = -1;
		int IEnd = -1;
		int BStart = -1;
		int BEnd = -1;
		
		BStart = currentInput.toLowerCase().indexOf("<B>".toLowerCase());
		BEnd = currentInput.toLowerCase().indexOf("</B>".toLowerCase());
		
		if (currentInput.length() > 3)
		{
			String BTag = currentInput.toLowerCase().substring(BStart + 3, BEnd);
			
			if (!BTag.equals("") && BEnd > 0 && BStart > 0)
			{
				HTMLChecker = true;
			}
		}
		

		IStart = currentInput.toLowerCase().indexOf("<I>".toLowerCase());
		IEnd = currentInput.toLowerCase().indexOf("</i>".toLowerCase());

		if (currentInput.length() > 3)
		{
			String ITag = currentInput.toLowerCase().substring(IStart + 3, IEnd);

			if (!ITag.equals("") && IEnd > 0 && IStart > 0)
			{
				HTMLChecker = true;
			}
		}

		if (currentInput.contains("<P>"))
		{
			HTMLChecker = true;
		}

		if (currentInput.length() > 9)
		{
			HREFStart = currentInput.toLowerCase().indexOf("<A HREF=\"".toLowerCase());
			HREFEnd = currentInput.indexOf("\"", HREFStart + 9);
			String HREF = currentInput.toLowerCase().substring(HREFStart + 9, HREFEnd);
			HREFCheck = currentInput.toLowerCase().indexOf("</a>".toLowerCase(), HREFEnd + 1);

			if (!HREF.equals(" ") && HREFCheck > 0)
			{
				HTMLChecker = true;
			}
		}
		if (currentInput.contains("<>"))
		{
			HTMLChecker = false;
		}

		if (currentInput.contains("< >"))
		{
			HTMLChecker = false;
		}

		open = currentInput.indexOf("<");
		close = currentInput.indexOf(">");
		if (close > -1)
		{
			String tag = currentInput.toLowerCase().substring(open + 1, close);
			open2 = currentInput.indexOf("<", close + 1);
			close2 = currentInput.indexOf(">", close + 1);

			if (close2 > -1)
			{
				String tag2 = currentInput.toLowerCase().substring(open2 + 1, close2);

				if (tag2.equals("/" + tag))
				{
					HTMLChecker = true;
				}
			}
		}

		return HTMLChecker;

	}

	public boolean twitterChecker(String currentInput)
	{
		boolean twitter = false;
		int hashtagStart = -1;
		int hashtagEnd = -1;
		int atStart = -1;
		int atEnd = -1;

		if (currentInput.equals(" "))
		{
			twitter = false;
		}

		hashtagStart = currentInput.indexOf("#");
		hashtagEnd = currentInput.indexOf(" ", hashtagStart + 1);

		if (hashtagEnd > -1)
		{
			String hashtag = currentInput.toLowerCase().substring(hashtagStart + 1, hashtagEnd);

			if (!hashtag.equals(" "))
			{
				twitter = true;
			}
		}

		atStart = currentInput.indexOf("@");
		atEnd = currentInput.indexOf(" ", atStart + 1);

		if (atEnd > -1)
		{
			String at = currentInput.toLowerCase().substring(atStart + 1, atEnd);

			if (!at.equals(" "))
			{
				twitter = true;
			}
		}

		return twitter;
	}

}
