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
		this.setBackground(Color.GREEN);
		this.add(chatButton);
		this.add(chatDisplay);
		this.add(chatField);
		this.add(chatTitle);
	}
	/**
	 * Changes the layout of the panel, making all of the components go where they need to be.
	 */
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.EAST, chatDisplay, -70, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, chatField, 182, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatDisplay, -6, SpringLayout.NORTH, chatField);
		baseLayout.putConstraint(SpringLayout.WEST, chatField, 0, SpringLayout.WEST, chatDisplay);
		baseLayout.putConstraint(SpringLayout.NORTH, chatButton, 6, SpringLayout.SOUTH, chatField);
		baseLayout.putConstraint(SpringLayout.WEST, chatButton, 0, SpringLayout.WEST, chatDisplay);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatTitle, -38, SpringLayout.NORTH, chatDisplay);
		baseLayout.putConstraint(SpringLayout.EAST, chatTitle, -197, SpringLayout.EAST, this);
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
	}
}
