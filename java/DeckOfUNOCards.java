
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class DeckOfUNOCards {//UNO牌組

    private final int player = 4;//總共四個完家
    private final int newSize = 48;//總共48張牌
    private final List<UNOGame> deck = new ArrayList<>(newSize);//宣告一個有48個空間的LIST

    public DeckOfUNOCards() {//建構子
        for (ColorType color : ColorType.values()) {
            for (UNOType number : UNOType.values()) {
                UNOGame newCard = new UNOGame(color, number);//建立一張完整的牌（顏色+數字or特殊牌）
                this.deck.add(newCard);//把牌一張張按照順序放進list裡（還沒洗牌）
            }
        }

        if (deck.size() != newSize) {//判斷牌組是不是裝滿了
            throw new IndexOutOfBoundsException("牌組沒有四十八張！");//如果沒裝滿一副48張則會丟出exception
        }
    }

    void showAllCards() {//顯示剩下所有的牌的方法
        Iterator<UNOGame> itrCard = deck.iterator();//使用iterator宣告一個變數itrCard並給定牌組的iterator
        while (itrCard.hasNext()) {//如果還有下一張牌就繼續迴圈
            System.out.println(itrCard.next().getName());//把一張一張牌拿出來看
        }
    }

    int size() {//回傳deck大小的方法
        return this.deck.size();
    }

    String draw() {//抽牌方法
        Iterator<UNOGame> itrCard = deck.iterator();//宣告一個iterator
        if (!itrCard.hasNext()) {//如果沒有下一張
            throw new IndexOutOfBoundsException("牌組已經空了。");//原先會顯示超出範圍，但這改成牌組已經空的訊息
        }
        UNOGame next = itrCard.next();//用UNOGame宣告一個名為next的變數去存下一張牌
        String name = next.getName();//宣告一個名為name的String變數去存下一張牌名
        this.deck.remove(next);//從牌組中移除下一張牌
        return name;//回傳牌名
    }

    void shuffle() {//洗牌的方法
        Collections.shuffle(this.deck);//利用java內建集合亂數排序的方法來洗牌
    }

    void dealCard() {//發牌的方法
        for (int i = 0; i < this.player; i++) {//四位玩家
            System.out.println("Player " + (i + 1) + "：");
            for (int j = 0; j < 4; j++) {//一人四張牌
                System.out.println(this.draw());//抽牌
            }
            System.out.println();
        }
    }

}
