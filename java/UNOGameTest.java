
public class UNOGameTest {

    public static void main(String[] args) {
        // TODO code application logic here
        DeckOfUNOCards deck = new DeckOfUNOCards();//宣告一個UNO牌組物件

        System.out.println("洗牌前：");
        deck.showAllCards();//顯示所有的牌
        System.out.println("------------------------");
        System.out.println("洗牌後：");
        deck.shuffle();//洗牌
        deck.showAllCards();//顯示所有的牌
        System.out.println("------------------------");
        deck.dealCard();//發牌
        System.out.println("------------------------");
        System.out.println("剩下的牌組：");
        deck.showAllCards();//顯示剩下的牌
    }

}
