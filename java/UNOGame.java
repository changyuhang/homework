
public class UNOGame {//組合UNO遊戲的牌（顏色+數字or特殊卡）

    private final UNOType number;//宣告一個UNOType物件叫number
    private final ColorType color;//宣告一個ColorType物件叫color

    public UNOGame(ColorType color, UNOType number) {//給定顏色(color)跟數字(number)的建構子
        this.color = color;
        this.number = number;
    }

    String getName() {//自定義一類似toString的功能，可回傳一張完整牌名
        return color.getSymbol() + " " + number.getSymbol();
    }
}
