package ca.mcgill.cs.comp303.rummy.model;

public class GameEngine
{
		
	public GameEngine() {
		
	}
	
	public void autoPlay() {
		
	}
	
	public static void main(String args[]) {
		
	}
	
	private Player addPlayer(Player.PlayerType type) {
		if (type == Player.HUMAN) {
			Player player = new Player(type);
		}
		else if (type == Player.COMP) {
			Player player = new Player(type);
		}
		
		
		
		return player;
	}
}
