package blackjack;

public enum Rank {
	Ace(1, 11),
	Two(2),
	Three(3),
	Four(4),
	Five(5),
	Six(6),
	Seven(7),
	Eight(8),
	Nine(9),
	Ten(10),
	Jack(10),
	Queen(10),
	King(10);
	
	int value;
	
	int aceValue;
	
	//Ace constructor
	private Rank(int x, int y) {
		value = x;
		aceValue = y;
	}
	
	//Every other card constructor
	private Rank(int x) {
		value = x;
	}
}

