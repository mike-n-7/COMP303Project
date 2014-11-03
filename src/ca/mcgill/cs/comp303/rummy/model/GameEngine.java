package ca.mcgill.cs.comp303.rummy.model;

import java.util.ArrayList;
import java.util.Stack;

public class GameEngine
{	
	private ArrayList<GameObserver> aObservers;
	private Deck aDeck;
	private ArrayList<Player> aPlayers;
	private DiscardPile aDiscard;
	
	public GameEngine() 
	{
		
	}
	
	public static void main(String args[]) 
	{
		
	}
	
	private void addObserver(GameObserver pObserver) 
	{
		aObservers.add(pObserver);
	}
	
	private Player addPlayer(Player.PlayerType type) 
	{
		Player player = null;
		if (type == Player.PlayerType.HUMAN) 
		{
			player = new HumanPlayer(type);
		}
		else if (type == Player.PlayerType.COMP) 
		{
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
	
	public void newGame(Player.PlayerType p1, Player.PlayerType p2)
	{
		aPlayers.add(addPlayer(p1));
		aPlayers.add(addPlayer(p2));
		
		newHand();
	}
	
	public void newHand()
	{
		aDeck = new Deck();
		aDiscard  = new DiscardPile();
		
		for( Player player : aPlayers)
		{
			player.wipeHand();
			for(int i = 0; i<10; i++)
			{
				player.addCard(drawFromDeck());
			}
		}
	}
	
	private void save()
	{
		//prints P1's toString method
		//then P2's toString
		for (Player player: aPlayers)
		{
			System.out.println(player.toString());
		}
		//then print the current deck order
		System.out.println(aDeck.toString());
		//then the current Discard Pile
		System.out.println(aDiscard.toString());
	}
	
	private void load()
	{
		//read the players string, then the deck's, then the discard pile
		//this should fill all the variables around
		
	}
	
	private Card drawFromDiscard()
	{
		return aDiscard.draw();
	}
	
	private Card peekFromDiscard()
	{
		return aDiscard.getTop();
	}

	private Card drawFromDeck()
	{
		return aDeck.draw();
	}

	
}









