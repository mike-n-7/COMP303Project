package ca.mcgill.cs.comp303.rummy.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DiscardPile
{
	private ArrayList<Card> aPile;
	
	public DiscardPile()
	{
		aPile = new ArrayList<Card>();
	}
	
	public void discard(Card pCard)
	{
		aPile.add(1, pCard);
	}
	
	public List<Card> getCards()
	{
		return Collections.unmodifiableList(aPile);
	}
	
	public Card getTop()
	{
		return aPile.get(1);
	}
}
