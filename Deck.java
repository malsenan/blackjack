package blackjack;


import java.util.Collections;
import java.util.LinkedList;



public class Deck {
	
	private LinkedList<Card> deck;
	
	//Deck constructor with all cards (not yet shuffled)
	public Deck() {
		deck = new LinkedList<Card>();
		for (int i = 0; i <= 3; i++) {
			for (int j = 0; j <= 12; j++) {
				deck.add(new Card(Rank.values()[j], Suit.values()[i]));
			}
		}
		
		//shuffle the deck
		Collections.shuffle(deck);
	}
	
	public Card deal() {
		return deck.poll();
	}
	
	public void printDeck() {
		for (Card c : deck) {
			System.out.println(c.toString());
		}
	}
}
