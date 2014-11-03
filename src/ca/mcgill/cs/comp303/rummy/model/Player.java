package ca.mcgill.cs.comp303.rummy.model;

public abstract class Player
{
	public enum PlayerType {
		HUMAN, COMP;//Used to tell computer what type of player to create
	}
	
	private final PlayerType aType;
	private Hand aHand;
	private int aHandsWon;
	
	public abstract Move makeMove(Card aCard);
	
	public Player(PlayerType pType) 
	{
		aType = pType;
		aHand = new Hand();
		aHandsWon = 0;
	}
	
	public PlayerType getType()
	{
		return aType;
	}
	
	public int getScore()
	{
		return aHandsWon;
	}
	
	public void addCard(Card pCard)
	{
		aHand.add(pCard);
	}
	
	public void wipeHand()
	{
		aHand.clear();
	}
	
	public void winHand()
	{
		aHandsWon++;
	}
	
	@Override
	public String toString()
	{
		return "";
	}
	
}
