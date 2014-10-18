package ca.mcgill.cs.comp303.rummy.model;

public class AIPlayer extends Player
{
	private AIStrategy aStrategy;
	
	public AIPlayer(PlayerType type)
	{
		super(type);
	}
	
	public void setStrategy(AIStrategy strat)
	{
		aStrategy = strat;
	}
	
	public Move makeMove(Card aCard)
	{
		return null;
	}
}
