package ca.mcgill.cs.comp303.rummy.model;

public class Move
{
	public enum MoveType
	{
		DRAWPIILE, DRAWDECK, DISCARD, KNOCK
	}
	
	private MoveType aType;
	private Card aCard;
	
	public Card getCard()
	{
		if (aCard == null)
		{
			return null;
		}
		return aCard;
	}
	
	public MoveType getType()
	{
		return aType;
	}
	
	public Move(MoveType pType)
	{
		aType = pType;
		aCard = null;
	}
	
	public Move(MoveType pType, Card pCard)
	{
		aType = pType;
		aCard = pCard;
	}
}
