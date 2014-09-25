package ca.mcgill.cs.comp303.rummy.model;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class TestCard
{
	
	/**
	 *  Tests Card.hashCode() to make sure cards only have the same hashcode if they have
	 *  the same rank and suit.
	 */
	@Test 
	public void testHashcode() 
	{
		// Make sure all cards have different hashcodes.
		for (Card.Rank r : Card.Rank.values()) 
		{
			for (Card.Suit s : Card.Suit.values()) 
			{
				Card c = new Card(r, s);
				for (Card.Rank r2 : Card.Rank.values()) 
				{
					for (Card.Suit s2 : Card.Suit.values()) 
					{
						Card c2 = new Card(r2, s2);
						if (s2 == s && r2 == r)
						{
							assertEquals(c.hashCode(), c2.hashCode());
						}
						else 
						{
							assertFalse(c.hashCode() == c2.hashCode());
						}
					}
				}
			}
		}
	}
	/**
	 *  Tests Card.equals() to make sure that only cards that have the same rank and suit
	 *  are identified as equal.  
	 */
	@Test
	public void testEquals()
	{	
		
		for (Card.Rank r1 : Card.Rank.values()) 
		{
			for (Card.Suit s1 : Card.Suit.values()) 
			{
				Card c1 = new Card(r1, s1);
				for (Card.Rank r2 : Card.Rank.values()) 
				{
					for (Card.Suit s2 : Card.Suit.values()) 
					{
						Card c2 = new Card(r2, s2);
						if (s1 == s2 && r1 == r2)
						{
							assertTrue(c1.equals(c2));
						}
						else 
						{
							assertFalse(c1.equals(c2));
						}
					}
				}
			}
		}
	}
}