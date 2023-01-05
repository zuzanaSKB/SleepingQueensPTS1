import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Player {

    private int playerIndex;
    private Game game;
    private Hand hand;
    private AwokenQueens awokenQueens;

    public Player(Game g, int index) {
        this.game = g;
        this.playerIndex = index;
        this.hand = new Hand(this);
        this.awokenQueens = new AwokenQueens(this);
    }

    public boolean play(List<Position> cards) {
        if (cards.isEmpty()) {
            System.out.println("Choose card to play.");
            return false;
        }
        if (!(cards.get(0) instanceof HandPosition)) {
            System.out.println("You have to choose card from hand.");
            return false;
        }

        List<HandPosition> gameCards = new ArrayList<>();
        if (cards.size() == 1) {
            gameCards.add((HandPosition) cards.get(0));
        } else if (cards.size() == 2) {
            Optional<Card> firstC = getPlayerState().getCards().get(cards.get(0).getCardIndex());
            Optional<Card> secondC = getPlayerState().getCards().get(cards.get(1).getCardIndex());
            if (firstC.get().getType() == CardType.NUMBER) {
                if (secondC.get().getType() == CardType.NUMBER) {
                    if (cards.get(1) instanceof HandPosition) {
                        System.out.println("Your second card have to be from your hand.");
                        return false;
                    } else {
                        EvaluateNumberedCards evaluateNumberedCards = new EvaluateNumberedCards();
                        if (!evaluateNumberedCards.play(List.of(firstC.get(), secondC.get()))) {
                            System.out.println("You cannot play with these 2 number cards.");
                            return false;
                        } else {
                            gameCards.add((HandPosition) cards.get(0));
                            gameCards.add((HandPosition) cards.get(1));
                        }
                    }
                } else {
                    System.out.println("Your second card have to be a number.");
                    return false;
                }

            } else if (firstC.get().getType() == CardType.KING) {
                MoveQueen moveQueen = new MoveQueen(this, awokenQueens);
                if (!moveQueen.play(cards.get(1))) {
                    System.out.println("You have to wake up sleeping queen.");
                    return false;
                }
                gameCards.add((HandPosition) cards.get(0));
            } else if (firstC.get().getType() == CardType.KNIGHT) {
                if (!(cards.get(1) instanceof AwokenQueenPosition)) {
                    System.out.println("You have to attack only awoken queen.");
                    return false;
                }
                EvaluateAttack attack = new EvaluateAttack(CardType.DRAGON, awokenQueens, this);
                if (!attack.play(cards.get(1), ((AwokenQueenPosition) cards.get(1)).getPlayerIndex())) {
                    System.out.println("Dragon has killed your knight");
                    return false;
                }
                gameCards.add((HandPosition) cards.get(0));
            } else if (firstC.get().getType() == CardType.SLEEPING_POTION) {
                if (!(cards.get(1) instanceof AwokenQueenPosition)) {
                    System.out.println("You have to attack only awoken queen.");
                    return false;
                }
                EvaluateAttack attack = new EvaluateAttack(CardType.MAGIC_WAND, awokenQueens, this);
                if (!attack.play(cards.get(1), ((AwokenQueenPosition) cards.get(1)).getPlayerIndex())) {
                    System.out.println("Magic wand has defended the queen.");
                    return false;
                }
                gameCards.add((HandPosition) cards.get(0));
            }
        } else {
            List<Card> evaluateNumCards = new ArrayList<>();
            for (Position position : cards) {
                if (!(position instanceof HandPosition)) {
                    System.out.println("Not card from your hand.");
                    return false;
                }
                if (((HandPosition) position).getPlayerIndex() != playerIndex) {
                    System.out.println("This card is from other player's hand.");
                    return false;
                }
                Optional<Card> card = getPlayerState().getCards().get(cards.get(0).getCardIndex());
                if (card.isEmpty()) {
                    System.out.println("There are no cards.");
                    return false;
                }
                evaluateNumCards.add(card.get());
                gameCards.add((HandPosition) position);
            }
            for (Card card : evaluateNumCards) {
                if (card.getType() != CardType.NUMBER) {
                    System.out.println("Not number cards.");
                    return false;
                }
            }
            EvaluateNumberedCards evaluateNumberedCards = new EvaluateNumberedCards();
            if (!evaluateNumberedCards.play(evaluateNumCards)) {
                System.out.println("Bad number combination.");
                return false;
            }

        }
        hand.pickCards(gameCards);
        hand.removePickedCardsAndRedraw();
        return true;
    }

    public PlayerState getPlayerState() {
        PlayerState playerState = new PlayerState();
        Map<Integer, Optional<Card>> cards = new HashMap<>();
        List<Card> cardsOnHand = hand.getCards();
        for (int i = 0; i < cardsOnHand.size(); i++) {
            cards.put(i, Optional.ofNullable(cardsOnHand.get(i)));
        }
        for (int i = cardsOnHand.size(); i < 5; i++) {
            cards.put(i, Optional.empty());
        }
        playerState.setCards(cards);
        Map<Integer, Queen> queens = new HashMap<>();
        for (Map.Entry<Position, Queen> queen : awokenQueens.getQueens().entrySet()) {
            queens.put(queen.getKey().getCardIndex(), queen.getValue());
        }
        playerState.setAwokenQueens(queens);
        return playerState;
    }

    public Game getGame() {
        return game;
    }

    public int getPlayerIndex() {
        return playerIndex;
    }

    public Hand getHand() {
        return hand;
    }

    public AwokenQueens getAwokenQueens() {
        return awokenQueens;
    }

}