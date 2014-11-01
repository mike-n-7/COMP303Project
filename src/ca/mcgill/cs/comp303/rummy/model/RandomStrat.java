package ca.mcgill.cs.comp303.rummy.model;

import java.util.Random;

public class RandomStrat implements AIStrategy
{
	private static Random rand = new Random();
	
	@Override
	public Move discardChoice(Hand pHand)
	{
		int index = rand.nextInt()%pHand.getCards().size();
		Card remove = (Card) pHand.getCards().toArray()[index];
		return new Move(Move.MoveType.DISCARD, remove);
	}

	@Override
	public Move drawChoice(Hand pHand, Card topCard)
	{
		if (pHand.score() < 10 && rand.nextInt()%2 == 0)
		{
			return new Move(Move.MoveType.KNOCK);
		}
		if (rand.nextInt()%2 == 0)
		{
			return new Move(Move.MoveType.DRAWPILE);
		}
		else
		{
			return new Move(Move.MoveType.DRAWDECK);
		}
	}


}
