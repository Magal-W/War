import java.util.*;
public class Moment {
    private Queue<Submoment> q;
    private int[] deckSizes = new int[2];
    private int[] trashSizes = new int[2];
    public Moment (Queue<Submoment> q, int deckSize0, int deckSize1, int trashSize0, int trashSize1) {
        if(q.peek() == null){
            throw new IllegalArgumentException("empty submoment queue in moment");
        }
        this.q=q;
        this.deckSizes[0] = deckSize0;
        this.deckSizes[1] = deckSize1;
        this.trashSizes[0] = trashSize0;
        this.trashSizes[1] = trashSize1;
    }
    public Moment (Queue<Submoment> q, int[] deckSizes, int[] trashSizes) {
        if(q.peek() == null){
            throw new IllegalArgumentException("empty moment queue");
        }
        this.q=q;
        this.deckSizes = deckSizes;
        this.trashSizes = trashSizes;
    }
    public Queue<Submoment> getSubmomentQueue () {
        return this.q;
    }
    public int[] getDeckSizes () {
        return this.deckSizes;
    }
    public int[] getTrashSizes () {
        return this.trashSizes;
    }
}