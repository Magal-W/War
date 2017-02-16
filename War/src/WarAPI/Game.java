import java.util.*;
public class Game {
    private Queue<Moment> q;
    private int whoWonVal;
    public Game (Queue<Moment> q, int whoWon) {
        if(q.peek() == null){
            throw new IllegalArgumentException("empty moment queue in game");
        }
        if(whoWon != 0 && whoWon != 1 && whoWon != -1){
            throw new IllegalArgumentException("bad winning value in game, MUST be 0, 1 or -1");
        }
        this.q = q;
        this.whoWonVal = whoWon;
    }
    public Queue<Moment> getMomentQueue () {
        return this.q;
    }
    public int whoWon () {
        return this.whoWonVal;
    }
}