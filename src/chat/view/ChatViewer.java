package chat.view;

import javax.swing.JOptionPane;

public class ChatViewer
{

		public String collectResponse(String question)
		{
			String response = "";
			
			response = JOptionPane.showInputDialog(null, question);
			
			return response;
		}
		
		public void displatyMessage(String message)
		{
			JOptionPane.showMessageDialog(null, message);
		}
		
		public int collectUserOption(String question)
		{
			int response = 0;
			
			response = JOptionPane.showConfirmDialog(null, question);
					
			return response;
		}
}
