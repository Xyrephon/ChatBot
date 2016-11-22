package chat.view;

import javax.swing.JFrame;
import chat.controller.ChatController;
import java.awt.Dimension;


public class ChatFrame extends JFrame
{
	private ChatController baseController;
	private ChatPanel appPanel;
	/**
	 * Calls the ChatPanel and then calls setupFrame().
	 * @param baseController
	 */
	public ChatFrame(ChatController baseController)
	{
		super();
		this.baseController = baseController;
		appPanel = new ChatPanel(baseController);
		
		setupFrame();
	}
	/**
	 * Adds the title, the size, makes it not resizable, and sets visibility to true.
	 */
	private void setupFrame()
	{
		this.setContentPane(appPanel);
		this.setTitle("ChatBot");
		this.setSize(new Dimension(500, 500));
		this.setResizable(false);
		this.setVisible(true);
		
	}
}
