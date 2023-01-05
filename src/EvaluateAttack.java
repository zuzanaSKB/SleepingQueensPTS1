import java.util.ArrayList;

public class EvaluateAttack {

    // evaluetes Knight and Sleeping potion play

    private CardType defenseCardType;
    private QueenCollection queens;
    private Player player;

    public EvaluateAttack(CardType dCardType, QueenCollection q, Player p) {
        defenseCardType = dCardType;
        queens = q;
        player = p;
    }

    public boolean play(Position targetQueen, int targetPlayerIndex) {
        if (targetPlayerIndex >= player.getGame().getPlayers().size())
            return false;
        if (!player.getGame().getPlayers().get(targetPlayerIndex).getAwokenQueens().getQueens()
                .containsKey(targetQueen))
            return false;
        HandPosition defenseCardHandPosition = player.getGame().getPlayers().get(targetPlayerIndex).getHand()
                .hasCardOfType(defenseCardType);
        if (defenseCardHandPosition == null) {
            MoveQueen moveQ = new MoveQueen(player, queens);
            moveQ.play(targetQueen);
        } else {
            ArrayList<HandPosition> defenseCardList = new ArrayList<>();
            defenseCardList.add(defenseCardHandPosition);
            player.getGame().getPlayers().get(targetPlayerIndex).getHand().pickCards(defenseCardList);
            player.getGame().getPlayers().get(targetPlayerIndex).getHand().removePickedCardsAndRedraw();
        }
        return true;
    }
}