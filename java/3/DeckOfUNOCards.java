package ntou.cs.java2015.yuhang;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class DeckOfUNOCards{
    private final int player = 4;
    private final int newSize = 48;
    private final List<UNOGame> deck = new ArrayList<>(newSize);

    public DeckOfUNOCards(){
        for (ColorType color:ColorType.values()){
            for (int i=0;i<12;i++){
                UNOGame newCard;
                if(i==10)       newCard = new UNOGame(UNOType.SKIP,color, -1);
                else if(i==11)  newCard = new UNOGame(UNOType.DRAW2,color, -1);
                else            newCard = new UNOGame(UNOType.NUMBER,color, i);
                this.deck.add(newCard);
            }
        }
    }

    void showAllCards(){
        Iterator<UNOGame> itrCard=deck.iterator();
        while (itrCard.hasNext())
            System.out.println(itrCard.next().getName());
    }

    String draw(){
        Iterator<UNOGame> itrCard=deck.iterator();
        UNOGame next=itrCard.next();
        String name=next.getName();
        this.deck.remove(next);
        return name;
    }

    void shuffle(){
        Collections.shuffle(this.deck);
    }

    void dealCard(){
        for (int i=0;i<this.player;i++){
            System.out.println("Player "+(i+1)+":");
            for (int j=0;j<4;j++)
                System.out.println(this.draw());
            System.out.println();
        }
    }
}
