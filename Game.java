package blackjack;

public class Game {
	
	private Hand dealer;
	private Hand player;
	private Deck deck;
	private int money;
	private double wins;
	private double ties;
	private double losses;
	private double totalGames;
	private double blackjacks;
	public double bjRate;
	public double winrate;
	
	//shuffle and deal
	public Game() {
		money = 1000;
		wins = 0;
		ties = 0;
		losses = 0;
		blackjacks = 0;
	}
	
	public void play(int hitNum) {
		deck = new Deck();
		dealer = new Hand();
		player = new Hand(hitNum);
		
		for (int i = 1; i <= 2; i++) {
			dealer.add(deck.deal());
			player.add(deck.deal());
		}
		dealer.dealerEval();
		player.playerEval();
		
		//dealer hits (takes another card) until they no longer can
		while (dealer.hit == true) {
			dealer.add(deck.deal());
			dealer.dealerEval();
		}
		
		//player hits (takes another card) until they no longer can
		while (player.hit == true) {
			player.add(deck.deal());
			player.playerEval();
		}
		
		//bust is loss
		if (player.bust) {
			losses++;
			money -= 10;
		}
		
		//double blackjack is tie
		else if (player.blackjack && dealer.blackjack) {
			blackjacks++;
			ties++;
		}
		
		//equal hands is tie
		else if (player.sum == dealer.sum) {
			ties++;
		}
		
		//player blackjack and !(dealer blackjack) is win
		else if (player.blackjack && !dealer.blackjack) {
			blackjacks++;
			wins++;
			money += 10;
		}
		
		//player hand better than dealer hand is win (already checked for player bust)
		else if (player.sum > dealer.sum) {
			wins++;
			money += 10;
		}
		
		//dealer bust is win (already checked for player bust)
		else if (dealer.bust) {
			wins++;
			money += 10;
		}
		
		//dealer hand better than player hand is loss (already checked for dealer bust)
		else if (dealer.sum > player.sum) {
			losses++;
			money -= 10;
		}
	}
	
	public void play1500000(int hitNum) {
		for (int i = 1; i <= 2000000; i++) {
			play(hitNum);
			
			if (money == 0) {
				break;
			}
		}
		totalGames = wins + ties + losses;
		winrate = (wins/totalGames) * 100;
		bjRate = (blackjacks/totalGames) * 100;
	}
	
	public void printData() {
		System.out.println("Hit if hand <= " + player.hitNum);
		System.out.println("Money: " + money);
		System.out.println("Blackjacks: " + blackjacks);
		System.out.println("Wins: " + wins);
		System.out.println("Ties: " + ties);
		System.out.println("Losses: " + losses);
		System.out.print("WR: ");
		System.out.format("%.2f", (wins/totalGames)*100);
		System.out.println("%");
		System.out.print("Blackjack %: ");
		System.out.format("%.2f", (blackjacks/totalGames)*100);
		System.out.println("%");
		System.out.println("");
	}
	
}
