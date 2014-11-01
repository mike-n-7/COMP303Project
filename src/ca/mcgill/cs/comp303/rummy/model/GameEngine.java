package ca.mcgill.cs.comp303.rummy.model;

import java.util.ArrayList;
import java.util.Stack;

public class GameEngine
{	
	private ArrayList<GameObserver> aObservers;
	
	public GameEngine() {
		
	}
	
	public static void main(String args[]) {
		
	}
	
	private Player addPlayer(Player.PlayerType type) {
		Player player = null;
		if (type == Player.PlayerType.HUMAN) {
			player = new HumanPlayer(type);
		}
		else if (type == Player.PlayerType.COMP) {
			player = new AIPlayer(type);
		}
		
		
		
		return player;
	}
	
	public void autoPlay() 
	{
		
	}
	
	private Move getMove(Player player) 
	{
		return null;
	}
	
	private void newHand()
	{
		
	}
	
	private void save()
	{
		
	}
	
	private void load()
	{
		
	}
	
	private void drawFromDiscard()
	{
		
	}
	
	private void peekFromDiscard()
	{
		
	}

	private void drawFromDeck()
	{
		
	}

	
}









