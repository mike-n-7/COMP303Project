package ca.mcgill.cs.comp303.rummy.model;

public interface AIStrategy
{
	public Move discardChoice(Move pMove);
	public Move drawChoice(Move pMove);
}
