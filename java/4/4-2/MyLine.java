package ntou.cs.java2015.yuhang;

import java.awt.Color;
import java.awt.Graphics;

public final class MyLine extends MyShape {
    private Color myColor;

    public MyLine() {
        this(0, 0, 0, 0, Color.BLACK);
    }
    public MyLine(int x1, int y1, int x2, int y2, Color color) {
        super(x1, y1, x2, y2);
        setColor(color);
    }

    public void setColor(Color color) {
        myColor = color;
    }

    public Color getColor() {
        return myColor;
    }

    public void draw(Graphics g) {
        g.setColor(getColor());
        g.drawLine(getX1(), getY1(), getX2(), getY2());
    }
}
