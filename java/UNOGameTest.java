package ntou.cs.java2015.yuhang;
public class UNOGameTest {
    public static void main(String[] args) {
        DeckOfUNOCards deck = new DeckOfUNOCards();
        System.out.println("洗牌前：");
        deck.showAllCards();
        System.out.println("---------------------");
        System.out.println("洗牌後：");
        deck.shuffle();
        deck.showAllCards();
        System.out.println("---------------------");
        deck.dealCard();
        System.out.println("---------------------");
        System.out.println("剩下的牌：");
        deck.showAllCards();
    }
}
