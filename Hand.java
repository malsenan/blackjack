package blackjack;

import java.util.ArrayList;
import java.util.List;

public class Hand {
	
	private List<Card> hand;
	int hitNum;
	int sum;
	boolean hit;
	boolean bust;
	boolean blackjack;
	
	public Hand() {
		hand = new ArrayList<Card>();
		sum = 0;
	}
	
	public Hand(int x) {
		hand = new ArrayList<Card>();
		sum = 0;
		hitNum = x;
	}
	
	public Hand(List<Card> cards) {
		for (Card c : cards) {
			hand.add(c);
			sum += c.getValue();
		}
	}
	
	public void add(Card c) {
		hand.add(c);
	}
	
	public void dealerEval() {
		int total = 0;
		int aceCount = 0;
		for (Card c : hand) {
			if (!(c.getRank().equals(Rank.Ace.name()))) {
				total += c.getValue();
			}
			else {
				c.changeAceDn();
				aceCount++; //Ace's values change dependent on how many aces there are
			}
		}
		
		//max needed for blackjack (if the hand sum + 11 (an ace) reaches the max, then a blackjack is guaranteed)
		int max = 0;
		if (aceCount == 4) {
			max = 18;
		}
		else if (aceCount == 3) {
			max = 19;
		}
		else if (aceCount == 2) {
			max = 20;
		}
		else if (aceCount == 1) {
			max = 21;
		}
		
		//Ace logic
		if (aceCount > 0) {
			for (Card c : hand) {
				if (c.getRank().equals(Rank.Ace.name())) {
					if ((total + 11) <= max) {
						c.changeAceUp();
						total += c.getValue();
					}
					else {
						total += c.getValue();
					}
				}
			}
		}
		
		sum = total;
		if (sum == 21) {
			blackjack = true;
			hit = false;
		}
		else if (sum > 21) {
			bust = true;
			hit = false;
		}
		else if (sum <= 16) {
			hit = true;
		}
		else {
			hit = false;
		}
	}
	
	public void playerEval() {
		int total = 0;
		int aceCount = 0;
		for (Card c : hand) {
			if (!(c.getRank().equals(Rank.Ace.name()))) {
				total += c.getValue();
			}
			else {
				c.changeAceDn();
				aceCount++; //Ace's values change dependent on how many aces there are
			}
		}
		
		//max needed for blackjack (if the hand sum + 11 (an ace) reaches the max, then a blackjack is guaranteed)
		int max = 0;
		if (aceCount == 4) {
			max = 18;
		}
		else if (aceCount == 3) {
			max = 19;
		}
		else if (aceCount == 2) {
			max = 20;
		}
		else if (aceCount == 1) {
			max = 21;
		}
		
		//Ace logic
		if (aceCount > 0) {
			for (Card c : hand) {
				if (c.getRank().equals(Rank.Ace.name())) {
					if ((total + 11) <= max) {
						c.changeAceUp();
						total += c.getValue();
					}
					else {
						total += c.getValue();
					}
				}
			}
		}
		
		sum = total;
		if (sum == 21) {
			blackjack = true;
			hit = false;
		}
		else if (sum > 21) {
			bust = true;
			hit = false;
		}
		else if (sum <= hitNum) {
			hit = true;
		}
		else {
			hit = false;
		}
	}
	
}
