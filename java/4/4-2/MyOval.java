package ntou.cs.java2015.yuhang;

import java.awt.Color;
import java.awt.Graphics;

public final class MyOval extends MyShape {
    private Color myColor;
    private boolean filled;

    public MyOval() {
        this(0, 0, 0, 0, Color.BLACK, false);
    }

    public MyOval(int x1, int y1, int x2, int y2,Color color, boolean isFilled) {
        super(x1, y1, x2, y2);
        setColor(color);
        setFilled(isFilled);
    }

    public void setColor(Color color) {
        myColor = color;
    }

    public Color getColor() {
        return myColor;
    }

    public int getUpperLeftX() {
        return Math.min(getX1(), getX2());
    }

    public int getUpperLeftY() {
        return Math.min(getY1(), getY2());
    }

    @Override
    public int getWidth() {
        return Math.abs(getX2() - getX1());
    }

    @Override
    public int getHeight() {
        return Math.abs(getY2() - getY1());
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean isFilled) {
        filled = isFilled;
    }

    public void draw(Graphics g) {
        g.setColor(getColor());
        if (isFilled())
            g.fillOval(getUpperLeftX(), getUpperLeftY(),getWidth(), getHeight());
        else
            g.drawOval(getUpperLeftX(), getUpperLeftY(),getWidth(), getHeight());
    }
}
