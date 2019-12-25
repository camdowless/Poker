package game;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class Poker {
    private Deck deck = new Deck();
    private Pot pot;
    private ArrayList<Card> flopCards = new ArrayList<>();
    private Card turnCard;
    private Card riverCard;
    private ArrayList<Card> playerCards = new ArrayList<>();
    private ArrayList<Card> opponentCards = new ArrayList<>();
    private int playerBet;
    private int opponentBet;

    private int gamePhase = 0;
    /*
    0 is the start, first bets
    1 is the cards being dealt
    2 is player's choice after deal
    3 is opponent's choice after deal
    4 is the flop
    5 is player's choice after flop
    6 is opponent's choice after flop
    7 is the turn
    8 is player's choice after turn
    9 is opponent's choice after turn
    10 is the river
    11 is player's choice after river
    12 is opponent's choice after river
    13 is comparison
     */

    Poker() throws IOException {
        this.pot = new Pot();
    }

    void play()   {
        Ante();
    }

    private void Ante(){
        gamePhase++;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter bet");
        playerBet = input.nextInt();
        opponentBet = playerBet;
        pot.addToPot(opponentBet + playerBet);

    }

    ArrayList<ArrayList<Card>> deal(){
        gamePhase++;
        System.out.println("Phase: " + gamePhase);
        Card p1 = Deck.draw();
        Card p2 = Deck.draw();
        playerCards.add(p1);
        playerCards.add(p2);
        Card o1 = Deck.draw();
        Card o2 = Deck.draw();
        opponentCards.add(o1);
        opponentCards.add(o2);
        ArrayList<ArrayList<Card>> cards = new ArrayList<>();
        cards.add(playerCards);

        /* System.out.println("p1: " + p1.getImage());
        System.out.println("p2: " + p2.getImage());
        System.out.println("o1: " + o1.getImage());
        System.out.println("o2: " + o2.getImage());
        p1 is cards.get(0).get(0)
        p2 is cards.get(0).get(1)
        o1 is cards.get(1).get(0)
        o2 is cards.get(1).get(1) */

        cards.add(opponentCards);
        return cards;
    }

     boolean playerCheck() throws InterruptedException {
         gamePhase++;
         System.out.println("Phase: " + gamePhase);
        boolean opponentRaise = false;
        Thread thread = new Thread();
        thread.sleep(2000);
        gamePhase++;
        System.out.println("Phase: " + gamePhase);
        return opponentRaise;
    }

    boolean playerRaise() throws InterruptedException {
        gamePhase++;
        System.out.println("Phase: " + gamePhase);
        boolean opponentRaise = false;
        Thread thread = new Thread();
        thread.sleep(2000);
        gamePhase++;
        System.out.println("Phase: " + gamePhase);
        return opponentRaise;
    }

    ArrayList<Card> flop() {
        gamePhase++;
        System.out.println("Phase: " + gamePhase);
        for(int i = 0; i < 3; i++){
            flopCards.add(Deck.draw());
        }
        return flopCards;
    }

    Card turn() {
        gamePhase++;
        System.out.println("Phase: " + gamePhase);
        turnCard = Deck.draw();
        return turnCard;
    }

    Card river() {
        gamePhase++;
        System.out.println("Phase: " + gamePhase);
        riverCard = Deck.draw();
        return riverCard;
    }

    void compareHands(){
        PokerHand playerHand = new PokerHand(playerCards, flopCards, turnCard, riverCard);
        PokerHand oppHand = new PokerHand(opponentCards, flopCards,turnCard,riverCard);

    }

    int getPhase(){
        return gamePhase;
    }
    private boolean checkBet(String a){
        return true;
    }
    int getPlayerBet(){
        return playerBet;
    }
     int getOpponentBet(){
        return opponentBet;
    }
     int getPotTotal(){
        return pot.getPotTotal();
    }
}