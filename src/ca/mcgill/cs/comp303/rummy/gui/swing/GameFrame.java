package ca.mcgill.cs.comp303.rummy.gui.swing;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;

public class GameFrame extends JFrame {
	public static void main(String[] args) {
		GameFrame thaFrame = new GameFrame();
		thaFrame.setLocationRelativeTo(null);
		thaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		thaFrame.pack();
		thaFrame.setResizable(false);
		thaFrame.setVisible(true); 
	}
	
	public GameFrame()
	{
		setTitle("Gin Rummy");
		setLayout(new BorderLayout());
		JPanel lCenterPanel = new JPanel();
		lCenterPanel.setLayout(new GridLayout(2,1));
		add(lCenterPanel, BorderLayout.CENTER);
		add(new ScorePanel());
	}
}
