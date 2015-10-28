
public enum UNOType { //卡片種類

    ZERO("0"), ONE("1"), TWO("2"), THREE("3"), FOUR("4"),
    FIVE("5"), SIX("6"), SEVEN("7"), EIGHT("8"), NINE("9"),
    SKIP("SKIP"), DRAW2("DRAW2"); //定義10個數字(0~9)加上2張特殊牌(skip跟draw2)

    private final String name;//一String參數名為name

    UNOType(String name) {//給定name的值
        this.name = name;
    }

    String getSymbol() {//回傳name的值
        return this.name;
    }
}
