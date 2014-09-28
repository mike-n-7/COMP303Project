package ca.mcgill.cs.comp303.rummy.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;

/**
 * 
 * @author Eric
 */
public class CardSet implements ICardSet
{
	private Set<Card> cards;
	
	CardSet (Set<Card> input) {
		for (Card c1 : input) {
			Card c2 = new Card(c1.getRank(), c1.getSuit());
			cards.add(c2);
		}
	}
	
	@Override
	public Iterator<Card> iterator()
	{
		return cards.iterator();
	}

	@Override
	public boolean contains(Card pCard)
	{
		return cards.contains(pCard);
	}

	@Override
	public int size()
	{
		return cards.size();
	}

	@Override
	public boolean isGroup()
	{
		if (cards.size() == 3 || cards.size() == 4) {return false;} //Need to have three or more cards
		
		ArrayList<Card> aList = new ArrayList<Card>(cards);
		
		Card.Rank rank = null; //Loop through cards, check if they have the same rank
		for(Card c1 : aList) {
			if(rank == null) { rank = c1.getRank(); } //set the first one, then check each after
			else if( rank.ordinal() != (c1.getRank().ordinal()) ) {
					return false;
			}
		}
		return true; //returns true if they all have the same rank
	}

	@Override
	public boolean isRun()
	{
		if (cards.size() < 3) {return false;} //Need to have three or more cards
		
		ArrayList<Card> aList = new ArrayList<Card>(cards);
		Collections.sort(aList, new Comparator<Card>() { //Sorts the cards, so we can check if they are sequential
			public int compare(Card c1,Card c2) {
				if(c1.getRank().ordinal() > c2.getRank().ordinal()) {
					return Integer.MAX_VALUE;
				}
				else if(c1.getRank().ordinal() == c2.getRank().ordinal()) { 
					return Integer.MIN_VALUE; 
				} else {
					return 0; 
				}
			};
		});
		
		Card.Rank prevRank = null; //Loop through cards, check if each is 1 more than previous
		for(Card c1 : aList) {
			if(prevRank == null) { prevRank = c1.getRank(); } //set the first one, then check each after
			else if( prevRank.ordinal() != (c1.getRank().ordinal() + 1) ) {
					return false;
			}
		}
		return true; //there are >=3 and in order they are consecutive
	}

}