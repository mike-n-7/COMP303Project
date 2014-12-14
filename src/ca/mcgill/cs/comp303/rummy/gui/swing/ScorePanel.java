package ca.mcgill.cs.comp303.rummy.gui.swing;

import javax.swing.JLabel;
import javax.swing.JPanel;

import ca.mcgill.cs.comp303.rummy.model.GameObserver;

public class ScorePanel extends JPanel implements GameObserver {
	private int aScore;
	private JLabel aLabel = new JLabel();
	
	public ScorePanel() {
		aScore = 0;
		setName("Score");
		aLabel.setText("Score:" + Integer.toString(aScore));
		add(aLabel);
	}

}
