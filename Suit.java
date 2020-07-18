package blackjack;

public enum Suit {
	Diamonds("diamonds"),
	Hearts("hearts"),
	Clubs("clubs"),
	Spades("spades");
	
	String value;
	
	//Suits constructor
	private Suit(String suit) {
		value = suit;
	}
}
