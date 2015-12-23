package ntou.cs.java2015.yuhang;

import javax.swing.JFrame;

public class MyShape extends JFrame{
    private int x1, y1, x2, y2;
    public MyShape() {
        this.setX1(0);
        this.setY1(0);
        this.setX2(0);
        this.setY2(0);
    }
    public MyShape(int x1, int y1, int x2, int y2) {
        setX1(x1);
        setY1(y1);
        setX2(x2);
        setY2(y2);
    }

    public void setX1(int x1) {
        if (x1 >= 0 && x1 <= 300)
            this.x1 = x1;
        else
            this.x1 = 0;
    }

    public int getX1() {
        return x1;
    }

    public void setY1(int y1) {
        if (y1 >= 0 && y1 <= 300)
            this.y1 = y1;
        else
            this.y1 = 0;
    }

    public int getY1() {
        return y1;
    }

    public void setX2(int x2) {
        if (x2 >= 0 && x2 <= 300)
            this.x2 = x2;
        else
            this.x2 = 0;
    }

    public int getX2() {
        return x2;
    }

    public void setY2(int y2) {
        if (y2 >= 0 && y2 <= 300)
            this.y2 = y2;
        else
            this.y2 = 0;
    }

    public int getY2() {
        return y2;
    }

    @Override
    public String toString() {
        return String.format("(x1,y1): (%d,%d)\n (x2,y2): (%d,%d)", this.getX1(), this.getX2(),
                this.getY1(), this.getY2());
    }

}
