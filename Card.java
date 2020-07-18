package blackjack;

public class Card {
	private int value;
	private Suit suit;
	private Rank rank;
	
	//Constructor
	public Card(Rank inRank, Suit inSuit) {
		value = inRank.value;
		suit = inSuit;
		rank = inRank;
	}
	
	//Change ace's value from 1 to 11
	public void changeAceUp() {
		if (rank.equals(Rank.Ace)) {
			value = Rank.Ace.aceValue;
		}
	}
	
	//Change ace's value from 11 to 1
	public void changeAceDn() {
		if (rank.equals(Rank.Ace)) {
			value = Rank.Ace.value;
		}
	}
	
	public int getValue() {
		return value;
	}
	
	public String getRank() {
		return rank.name();
	}
	
	@Override
	public String toString() {
		return rank.toString() + " of " + suit.value;
	}
}
