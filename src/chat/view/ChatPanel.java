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
	private JScrollPane chatScroll;
	private JButton chatButton;
	private JLabel chatTitle;
	private JButton sendTweetButton;
	private JButton twitterSave;
	private JButton searchTwitterButton;
	private JButton twitterChat;
	private JButton twitterLoad;
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
		twitterLoad = new JButton("Load");
		chatScroll = new JScrollPane();	
		
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
		chatScroll.setViewportView(chatDisplay);
		chatScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		chatScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	}
	/**
	 * Adds all of the components to the panel, and makes the background green.
	 */
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setBackground(Color.MAGENTA);
		this.add(chatButton);
		this.add(chatField);
		this.add(chatTitle);
		this.add(sendTweetButton);
		this.add(twitterSave);
		this.add(searchTwitterButton);
		this.add(twitterChat);
		this.add(twitterLoad);
		this.add(chatScroll);
	}
	/**
	 * Changes the layout of the panel, making all of the components go where they need to be.
	 */
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.SOUTH, chatField, -84, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, twitterChat, -23, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.WEST, chatTitle, 204, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatTitle, -6, SpringLayout.NORTH, chatDisplay);
		baseLayout.putConstraint(SpringLayout.NORTH, twitterChat, -62, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, chatButton, 6, SpringLayout.SOUTH, chatField);
		baseLayout.putConstraint(SpringLayout.WEST, chatButton, 138, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.WEST, twitterSave, 387, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.WEST, sendTweetButton, 0, SpringLayout.WEST, twitterSave);
		baseLayout.putConstraint(SpringLayout.SOUTH, sendTweetButton, -6, SpringLayout.NORTH, searchTwitterButton);
		baseLayout.putConstraint(SpringLayout.SOUTH, searchTwitterButton, -6, SpringLayout.NORTH, twitterSave);
		baseLayout.putConstraint(SpringLayout.NORTH, twitterLoad, 150, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, twitterSave, -6, SpringLayout.NORTH, twitterLoad);
		baseLayout.putConstraint(SpringLayout.WEST, twitterLoad, 386, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatScroll, -6, SpringLayout.NORTH, chatField);
		baseLayout.putConstraint(SpringLayout.EAST, chatField, 0, SpringLayout.EAST, chatScroll);
		baseLayout.putConstraint(SpringLayout.EAST, chatScroll, -105, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.WEST, searchTwitterButton, 17, SpringLayout.EAST, chatScroll);
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
		
		twitterLoad.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				
			}
		});
	}
}
