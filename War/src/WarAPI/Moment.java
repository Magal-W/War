import java.util.*;
public class Moment {
    private Queue<Card> q1;
    private Queue<Card> q2;
    private int[] deckSizes = new int[2];
    private int[] trashSizes = new int[2];
    public Moment (Queue<Card> q1,Queue<Card> q2, int deckSize0, int deckSize1, int trashSize0, int trashSize1) {
        if(q1.peek() == null || q2.peek() == null){
            throw new IllegalArgumentException("empty submoment queue in moment");
        }
        if(q1.size() != q2.size()){
            throw new IllegalArgumentException("non-matching card queues in moment");
        }
        this.q1=q1;
        this.q2=q2;
        this.deckSizes[0] = deckSize0;
        this.deckSizes[1] = deckSize1;
        this.trashSizes[0] = trashSize0;
        this.trashSizes[1] = trashSize1;
    }
    public Moment (Queue<Card> q1,Queue<Card> q2, int[] deckSizes, int[] trashSizes) {
        if(q1.peek() == null || q2.peek() == null){
            throw new IllegalArgumentException("empty submoment queue in moment");
        }
        if(q1.size() != q2.size()){
            throw new IllegalArgumentException("non-matching card queues in moment");
        }
        this.q1=q1;
        this.q2=q2;
        this.deckSizes = deckSizes;
        this.trashSizes = trashSizes;
    }
    public Queue<Card> getCardQueue (int playerNum) {
        if(playerNum == 0){
            return this.q1;
        }else if(playerNum == 1){
            return this.q2;
        }else{
            throw new IllegalArgumentException("invalid player number in Mement.getCardQueue. MUST be 0 or 1.");
        }
    }
    public int[] getDeckSizes () {
        return this.deckSizes;
    }
    public int[] getTrashSizes () {
        return this.trashSizes;
    }
}