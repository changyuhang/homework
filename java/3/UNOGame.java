package ntou.cs.java2015.yuhang;
enum ColorType {
    BLUE, GREEN, RED, YELLOW;
}

enum UNOType {
    NUMBER,SKIP, DRAW2
}

public class UNOGame{
    private final UNOType type;
    private final ColorType color;
    private final int number;
    public UNOGame(UNOType type,ColorType color,int number) {
        this.type=type;
        this.color=color;
        this.number=number;
    }

    String getName() {
        return color+" "+(type==UNOType.NUMBER?number:type);
    }
}
