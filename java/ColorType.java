
public enum ColorType { //顏色種類

    BLUE("藍色"), GREEN("綠色"), RED("紅色"), YELLOW("黃色"); //定義四種顏色

    private final String name;//一String參數名為name

    ColorType(String name) {//給定name的值
        this.name = name;
    }

    String getSymbol() {//回傳name的值
        return this.name;
    }
}
