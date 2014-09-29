package ca.mcgill.cs.comp303.rummy.model;

import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

/**
 * Models a hand of 10 cards. The hand is not sorted. Not threadsafe.
 * The hand is a set: adding the same card twice will not add duplicates
 * of the card.
 * @inv size() > 0
 * @inv size() <= HAND_SIZE
 */
public class Hand
{
	private ArrayList<Card> aCards;
	private ArrayList<Card> aUnmatched;
	private ArrayList<CardSet> aRuns;
	private ArrayList<CardSet> aGroups;
	
	/**
	 * Creates a new, empty hand.
	 * @author: Mike
	 */
	public Hand()
	{
		aCards = new ArrayList<Card>();
		aUnmatched = new ArrayList<Card>();
		aRuns = new ArrayList<CardSet>();
		aGroups = new ArrayList<CardSet>();
	}
	
	/**
	 * Adds pCard to the list of unmatched cards.
	 * If the card is already in the hand, it is not added.
	 * @param pCard The card to add.
	 * @throws HandException if the hand is complete.
	 * @throws HandException if the card is already in the hand.
	 * @pre pCard != null
	 * @author: Pascale
	 */
	public void add( Card pCard )
	{
		// TODO
	}
	
	/**
	 * Remove pCard from the hand and break any matched set
	 * that the card is part of. Does nothing if
	 * pCard is not in the hand.
	 * @param pCard The card to remove.
	 * @pre pCard != null
	 * @author: Mike
	 */
	public void remove( Card pCard )
	{
		aCards.remove(pCard);
		aUnmatched.remove(pCard);
		// Remove any runs containing the card to remove.
		ArrayList<CardSet> runsToRemove = new ArrayList<CardSet>();
		for (CardSet run : aRuns) 
		{
			if (run.contains(pCard)) 
			{
				runsToRemove.add(run);	
			}
		}
		for (CardSet run : runsToRemove)
		{
			aRuns.remove(run);
		}
		// Remove any groups containing the card to remove.
		ArrayList<CardSet> groupsToRemove = new ArrayList<CardSet>();
		for (CardSet group : aGroups) 
		{
			if (group.contains(pCard))
			{
				groupsToRemove.add(group);
			}
		}
		for (CardSet group : groupsToRemove)
		{
			aGroups.remove(group);
		}
	}
	
	/**
	 * @return True if the hand is complete.
	 * @author: Pascale.
	 */
	public boolean isComplete()
	{
		return true; // TODO
	}
	
	/**
	 * Removes all the cards from the hand.
	 * @author: Mike.
	 */
	public void clear()
	{
		aCards = new ArrayList<Card>();
		aUnmatched = new ArrayList<Card>();
		aRuns = new ArrayList<CardSet>();
		aGroups = new ArrayList<CardSet>();
	}
	
	/**
	 * @return A copy of the set of matched sets
	 * @author: Pascale.
	 */
	public Set<ICardSet> getMatchedSets()
	{
		return null; // TODO
	}
	
	/**
	 * @return A copy of the set of unmatched cards.
	 * @author: Mike.
	 */
	public Set<Card> getUnmatchedCards()
	{
		return new HashSet<Card>(aUnmatched);
	}
	
	/**
	 * @return The number of cards in the hand.
	 * @author: Pascale.
	 */
	public int size()
	{
		return Integer.MAX_VALUE; // TODO
	}
	
	/**
	 * Determines if pCard is already in the hand, either as an
	 * unmatched card or as part of a set.
	 * @param pCard The card to check.
	 * @return true if the card is already in the hand.
	 * @pre pCard != null 
	 * @author Mike
	 */
	public boolean contains( Card pCard )
	{
		return aCards.contains(pCard);
	}
	
	/**
	 * @return The total point value of the unmatched cards in this hand.
	 * @author: Pascale.
	 */
	public int score()
	{
		return Integer.MAX_VALUE; // TODO
	}
	
	/**
	 * Creates a group of cards of the same rank.
	 * @param pCards The cards to groups
	 * @pre pCards != null
	 * @throws HandException If the cards in pCard are not all unmatched
	 * cards of the hand or if the group is not a valid group.
	 * @author: Mike.
	 */
	public void createGroup( Set<Card> pCards )
	{
		// Make sure all the cards are unmatched.
		for (Card card : pCards) 
		{
			if (!aUnmatched.contains(card)) 
			{
				throw new HandException("The cards are not all unmatched.");
			}
		}
		// Make sure the group is valid.
		CardSet group = new CardSet(pCards);
		if (group.isGroup())
		{
			aGroups.add(group);
			// Remove cards from being unmatched.
			for (Card card : pCards)
			{
				aUnmatched.remove(card);
			}
		}
		else 
		{
			throw new HandException("Not a valid group.");
		}
	}
	
	/**
	 * Creates a run of cards of the same suit.
	 * @param pCards The cards to group in a run
	 * @pre pCards != null
	 * @throws HandException If the cards in pCard are not all unmatched
	 * cards of the hand or if the group is not a valid group.
	 * @author: Pascale.
	 */
	public void createRun( Set<Card> pCards )
	{	
		// TODO
	}
	
	/**
	 * Calculates the matching of cards into groups and runs that
	 * results in the lowest amount of points for unmatched cards.
	 */
	public void autoMatch()
	{
	}
}
