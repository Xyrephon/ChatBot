package chat.model;

import chat.controller.ChatController;
import chat.model.Chatbot;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.Twitter;
import twitter4j.Status;
import java.util.List;
import java.text.DecimalFormat;
import java.util.ArrayList;
import twitter4j.Paging;
import java.util.Scanner;
import twitter4j.Query;
import twitter4j.GeoLocation;
import twitter4j.QueryResult;

public class CTECTwitter 
{
	private ChatController baseController;
	private Twitter chatbotTwitter;
	private List<Status> searchedTweets;
	private List<String> tweetedWords;
	
	public CTECTwitter(ChatController baseController)
	{
		this.baseController = baseController;
		this.searchedTweets = new ArrayList<Status>();
		this.tweetedWords = new ArrayList<String>();
		this.chatbotTwitter = TwitterFactory.getSingleton();
		
	}
	
	public void sendTweet(String text)
	{
		try
		{
			chatbotTwitter.updateStatus("I Jonah just tweeted from my Java Chatbot program 2017! #APCSRocks @CTECNow Thanks @cscheerleader & @codyhenrichsen! @ChatbotCTEC");
		}
		catch(TwitterException tweetError)
		{
			baseController.handleErrors(tweetError);
		}
		catch(Exception otherError)
		{
			baseController.handleErrors(otherError);
		}
	}
	
	private String [] createIgnoredWordArray()
	{
		String [] boringWords;
		
		int wordCount = 0;
		Scanner wordScanner = new Scanner(this.getClass().getResourceAsStream("commonWords.txt"));
		
		while(wordScanner.hasNextLine())
		{
			wordScanner.nextLine();
			wordCount++;
		}
		boringWords = new String [wordCount];
		wordScanner.close();
		
		wordScanner = new Scanner(this.getClass().getResourceAsStream("commonWords.txt"));
		for(int index = 0; index < boringWords.length; index ++)
		{
			boringWords[index] = wordScanner.nextLine();
		}
		
		wordScanner.close();
		return boringWords;
	}
	
	private void collectTweets(String username)
	{
		searchedTweets.clear();
		tweetedWords.clear();
		
		Paging statusPage = new Paging(1,100);
		int page = 1;
		
		while(page <= 10)
		{
			statusPage.setPage(page);
			try
			{
			searchedTweets.addAll(chatbotTwitter.getUserTimeline(username, statusPage));
			}
			catch(TwitterException searchTweetError)
			{
				baseController.handleErrors(searchTweetError);
			}
			page++;
		}
	}
	
	public String getMostCommonWord(String user)
	{
		String results = "";
		collectTweets(user);
		turnStatusesToWords();
		
		removeAllBoringWords();
		removeEmptyText();
		removeMentions();
	
		results += calculatePopularWordAndCount();
//		results += "There are " + tweetedWords.size() + " words in the tweets from " + user + " ";
		return results;
	}
	
	private void removeEmptyText()
	{
		for (int index = 0; index < tweetedWords.size(); index++)
		{
			if(tweetedWords.get(index).trim().equals(""))
			{
				tweetedWords.remove(index);
				index--;
			}
		}
	}
	
	private void removeAllBoringWords()
	{
		String [] boringWords = createIgnoredWordArray();
		for (int index = 0; index < tweetedWords.size(); index++)
		{
			for (int boringIndex = 0; boringIndex < boringWords.length; boringIndex ++)
			{
				if(tweetedWords.get(index).equalsIgnoreCase(boringWords[boringIndex]))
				{
					tweetedWords.remove(index);
					index--;
					boringIndex = boringWords.length;
				}
			}
		}
	}
	
	private void turnStatusesToWords()
	{
		for(Status currentStatus : searchedTweets)
		{
			String tweetText = currentStatus.getText();
			String [] tweetWords =  tweetText.split(" ");
			for(int index = 0; index < tweetWords.length; index++)
			{
				tweetedWords.add(removePunctuation(tweetWords[index]));
			}
		}
	}

	private String calculatePopularWordAndCount()
	{
		String information = "";
		String mostPopular = "";
		int popularIndex = 0;
		int popularCount = 0;
		
		for(int index = 0; index < tweetedWords.size(); index++)
		{
			int currentPopularity = 0;
			for(int searched = index + 1; searched < tweetedWords.size(); searched++)
			{
				if(tweetedWords.get(index).equalsIgnoreCase(tweetedWords.get(searched)))
				{
					currentPopularity++;
				}
			}
			if(currentPopularity > popularCount)
			{
				popularIndex = index;
				popularCount = currentPopularity;
				mostPopular = tweetedWords.get(index);
			}
		}
		
		information = mostPopular + ", and it occured " + popularCount + " times out of " + tweetedWords.size() + ", AKA " + (DecimalFormat.getPercentInstance().format(((double)popularCount)/tweetedWords.size()) + " ");
		
		
		return information;
	}
	
	private String removePunctuation(String currentString)
	{
		String punctuation = ".,'?!:;\"(){}^[]<>-"; //Think about adding hashtag and @
		
		String scrubbedString = "";
		for (int i = 0; i < currentString.length(); i++)
		{
			if(punctuation.indexOf(currentString.charAt(i)) == -1)
			{
				scrubbedString += currentString.charAt(i);
			}
		}
		return null;
	}
	
	public String Investigation(int miles)
	{
		String results = "";
		int numberOfHtml = 0;
		int numberOfHtml2 = 0;
		
		Query search = new Query("href");
		search.setCount(100);
		search.setGeoCode(new GeoLocation(40.587521, -111.869178), miles, Query.MILES);
		search.setSince("2017-1-1");
		
		try
		{
			QueryResult result = chatbotTwitter.search(search);
			for (Status tweet : result.getTweets())
			{
				if (baseController.getChatbot().inputHTMLChecker(tweet.getText()))
				{
					numberOfHtml++;
				}
			}
			
		}
		catch (TwitterException error)
		{
			error.printStackTrace();
		}
		results = "Number of tweets in html is: " + numberOfHtml;
		
		return results;
	}
	
	private void removeMentions()
	{
		for (int index = 0; index < tweetedWords.size(); index++)
		{
			if(tweetedWords.get(index).substring(0, 1).equals("@"))
			{
				tweetedWords.remove(index);
				index --;
			}
		}
	}
}
