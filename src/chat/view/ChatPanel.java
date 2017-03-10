package chat.view;

import javax.swing.*;
import chat.controller.ChatController;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChatPanel extends JPanel
{
	private ChatController baseController;
	private SpringLayout baseLayout;
	private JTextArea chatDisplay;
	private JTextField chatField;
	private JButton chatButton;
	private JLabel chatTitle;
	private JButton sendTweetButton;
	private JButton twitterSave;
	private JButton searchTwitterButton;
	private JButton twitterChat;
	/**
	 * Initializes all data members, and calls setupChatDisplay(), setupPanel(), setupLayout(), and setupListeners().
	 * @param baseController
	 */
	public ChatPanel(ChatController baseController)
	{
		super();
		this.baseController = baseController;
	
		baseLayout = new SpringLayout();
		chatDisplay = new JTextArea(5,25);
		chatField = new JTextField(25);
		chatButton = new JButton("Chat with the bot");
		chatTitle = new JLabel("ChatBot!");
		sendTweetButton = new JButton("Post");
		twitterSave = new JButton("Save");
		searchTwitterButton = new JButton("Search");
		twitterChat = new JButton("Chat");
		
		setupChatDisplay();
		setupPanel();
		setupLayout();
		setupListeners();
	}
	/**
	 * Allows the user to write to the chat bot, and sets the word wrap to true.
	 */
	private void setupChatDisplay()
	{
		chatDisplay.setEditable(false);
		chatDisplay.setEnabled(false);
		chatDisplay.setWrapStyleWord(true);
		chatDisplay.setLineWrap(true);
	}
	/**
	 * Adds all of the components to the panel, and makes the background green.
	 */
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setBackground(Color.MAGENTA);
		this.add(chatButton);
		this.add(chatDisplay);
		this.add(chatField);
		this.add(chatTitle);
		this.add(sendTweetButton);
		this.add(twitterSave);
		this.add(searchTwitterButton);
		this.add(twitterChat);
	}
	/**
	 * Changes the layout of the panel, making all of the components go where they need to be.
	 */
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.EAST, twitterChat, -23, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, chatField, 150, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatDisplay, -6, SpringLayout.NORTH, chatField);
		baseLayout.putConstraint(SpringLayout.NORTH, chatButton, 6, SpringLayout.SOUTH, chatField);
		baseLayout.putConstraint(SpringLayout.WEST, chatButton, 0, SpringLayout.WEST, chatDisplay);
		baseLayout.putConstraint(SpringLayout.WEST, chatTitle, 204, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatTitle, -6, SpringLayout.NORTH, chatDisplay);
		baseLayout.putConstraint(SpringLayout.WEST, sendTweetButton, 387, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, chatDisplay, -17, SpringLayout.WEST, sendTweetButton);
		baseLayout.putConstraint(SpringLayout.NORTH, sendTweetButton, -5, SpringLayout.NORTH, chatDisplay);
		baseLayout.putConstraint(SpringLayout.EAST, chatField, -7, SpringLayout.WEST, twitterSave);
		baseLayout.putConstraint(SpringLayout.WEST, twitterSave, 0, SpringLayout.WEST, sendTweetButton);
		baseLayout.putConstraint(SpringLayout.NORTH, twitterSave, 6, SpringLayout.SOUTH, searchTwitterButton);
		baseLayout.putConstraint(SpringLayout.NORTH, searchTwitterButton, 9, SpringLayout.SOUTH, sendTweetButton);
		baseLayout.putConstraint(SpringLayout.WEST, searchTwitterButton, 0, SpringLayout.WEST, sendTweetButton);
		baseLayout.putConstraint(SpringLayout.NORTH, twitterChat, -62, SpringLayout.NORTH, this);
	}
	/**
	 * Makes the button send what the user writes to the chatbot, allowing the chatbot to respond.
	 */
	private void setupListeners()
	{
		chatButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String personWords = chatField.getText();
				String chatbotResponse = baseController.useChatbotCheckers(personWords);
				
				chatDisplay.setText("You said: " + personWords +"\n"+ "Chatbot says: " + chatbotResponse);
				chatField.setText("");
				
			}
		});
		
		sendTweetButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				baseController.useTwitter(chatField.getText());
				
			}
		});
		
		twitterSave.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				
			}
		});
		
		searchTwitterButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				int miles = Integer.parseInt(chatField.getText());
				chatDisplay.setText(baseController.twitterBot.Investigation(miles));
//				String results = baseController.searchTwitterUser(chatField.getText());
//				chatDisplay.setText(results + chatDisplay.getText());
			}
		});
		
		twitterSave.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				
			}
		});
		
		twitterChat.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				
			}
		});
	}
}
