package ca.mcgill.cs.comp303.rummy.model;

import java.util.Comparator;


/**
 * An immutable description of a playing card.
 */
public final class Card implements Comparable<Card>, Cloneable
{
	/**
	 * Represents the rank of the card.
	 */
	public enum Rank 
	{ ACE, TWO, THREE, FOUR, FIVE, SIX,
		SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING }
	
	/**
	 * Represents the suit of the card.
	 */
	public enum Suit 
	{ CLUBS, DIAMONDS, HEARTS, SPADES }
	
	private final Rank aRank;
	
	private final Suit aSuit;
	
	/**
	 * Create a new card object. 
	 * @param pRank The rank of the card.
	 * @param pSuit The suit of the card.
	 */
	public Card(Rank pRank, Suit pSuit )
	{
		aRank = pRank;
		aSuit = pSuit;
	}
	
	public Card(Card card) 
	{
		aRank = card.getRank();
		aSuit = card.getSuit();
	}
	
	/**
	 * Obtain the rank of the card.
	 * @return An object representing the rank of the card.
	 */
	public Rank getRank()
	{
		return aRank;
	}
	
	/**
	 * Obtain the suit of the card.
	 * @return An object representing the suit of the card 
	 */
	public Suit getSuit()
	{
		return aSuit;
	}
	
	/**
	 * @see java.lang.Object#toString()
	 * @return See above.
	 */
	public String toString()
	{
		return aRank + " of " + aSuit;
	}

	/**
	 * Compares two cards according to gin rules (ace is low, suits 
	 * run as Spade, Hearts, Diamonds, Clubs (high to low)).
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 * @param pCard The card to compare to
	 * @return Returns a negative integer, zero, or a positive integer 
	 * as this object is less than, equal to, or greater than pCard
	 * @author Eric Quinn
	 */
	public int compareTo(Card pCard)
	{
		if ( this.getSuit().ordinal() > pCard.getSuit().ordinal() ) 
		{ //suit overrides all else
			return Integer.MAX_VALUE;
		}
		if (this.getRank().ordinal() > pCard.getRank().ordinal() && this.getSuit().ordinal() == pCard.getSuit().ordinal() ) 
		{ //same suit, higher rank
			return Integer.MAX_VALUE;
		}
		if (this.getRank().ordinal() == pCard.getRank().ordinal() && this.getSuit().ordinal() == pCard.getSuit().ordinal() ) 
		{ //same suit and rank returns 0
			return 0;
		}
		return Integer.MIN_VALUE;
	}

	/**
	 * Two cards are equal if they have the same suit and rank.
	 * @param pCard The card to test.
	 * @return true if the two cards are equal
	 * @see java.lang.Object#equals(java.lang.Object)
	 * @author Pascale Gourdeau
	 */
	@Override
	public boolean equals( Object pCard ) 
	{
		if (this == null || pCard == null)
		{
			return false;
		}
		else if (pCard.getClass() != this.getClass()) 
		{
			return false;
		}
		else if (this.aRank == ((Card) pCard).getRank() && this.aSuit == ((Card) pCard).getSuit()) 
		{
			return true;
		}
		return false; 
	}

	/** 
	 * The hashcode for a card is the suit*13 + that of the rank (perfect hash).
	 * @return the hashcode
	 * @see java.lang.Object#hashCode()
	 * @author Michael Noseworthy
	 */
	@Override
	public int hashCode() 
	{
		return aRank.ordinal() + Rank.values().length * (aSuit.ordinal() + 1);
	}
	
	@Override
	protected Card clone() throws CloneNotSupportedException
	{
		return (Card) this.clone();
	}
	
	public static Comparator<Card> getBySuitComparator() 
	{
		return new Comparator<Card>() 
				{
					public int compare(Card pCard1, Card pCard2)
					{
						return pCard1.getSuit().compareTo(pCard2.getSuit());
					}
				};
	}
	
	public static Comparator<Card> getByRankComparator() 
	{
		return new Comparator<Card>() 
				{
					public int compare(Card pCard1, Card pCard2)
					{
						return pCard1.getRank().compareTo(pCard2.getRank());
					}
				};
	}
}
