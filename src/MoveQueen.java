import java.util.Optional;

public class MoveQueen {

    private Player player;
    private QueenCollection queenCollection;

    public MoveQueen(Player p, QueenCollection qC) {
        this.player = p;
        this.queenCollection = qC;
    }

    public boolean play(Position targetQueen) {
        if (targetQueen instanceof AwokenQueenPosition) {
            int targetPlayerIndex = ((AwokenQueenPosition) targetQueen).getPlayerIndex();
            Optional<Queen> removedQ = player.getGame().getPlayers().get(targetPlayerIndex).getAwokenQueens()
                    .removeQueen(targetQueen);
            if (removedQ.isEmpty()) {
                return false;
            }
            queenCollection.addQueen(removedQ.get());
            return true;
        } else if (targetQueen instanceof SleepingQueenPosition) {
            Optional<Queen> removedQ = player.getGame().getSleepingQ().removeQueen(targetQueen);
            if (removedQ.isEmpty()) {
                return false;
            }
            queenCollection.addQueen(removedQ.get());
            return true;
        }
        return false;
    }

}