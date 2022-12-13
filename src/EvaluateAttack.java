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
        if (targetPlayerIdx >= player.getGame().getPlayers().size())
            return false;
        if (!player.getGame().getPlayers().get(targetPlayerIndex).getAwokenQueens().getQueens()
                .containsKey(targetQueen))
            return false;
    }
}