package ca.mcgill.cs.comp303.rummy.model;

public interface AIStrategy
{
	public Move discardChoice(Hand pHand);
	public Move drawChoice(Hand pHand, Card topCard);
}
